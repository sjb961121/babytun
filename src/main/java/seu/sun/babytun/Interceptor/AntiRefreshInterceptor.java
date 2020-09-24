package seu.sun.babytun.Interceptor;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class AntiRefreshInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Prehandler");
        response.setContentType("text/html;charset=utf-8");
        String remoteAddr = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String key="anti:refresh:"+DigestUtils.md5Hex(remoteAddr+"_"+userAgent);

        Integer num = (Integer) redisTemplate.opsForValue().get(key);

        if (redisTemplate.hasKey("anti:refresh:blacklist")){
            if (redisTemplate.opsForSet().isMember("anti:refresh:blacklist",remoteAddr)){
                response.getWriter().println("检测到您的IP访问异常，已加入黑名单");
                return false;
            }
        }
        if (num==null){
            redisTemplate.opsForValue().set(key,1,60, TimeUnit.SECONDS);
        }
        else {
//            response.setContentType("text/html;charset=utf-8");
            if (num>30 && num<100){
                response.getWriter().println("请求过于频繁，请稍后再试！");
                redisTemplate.opsForValue().increment(key, 1L);
                return false;
            }
            else if (num>=100){
                response.getWriter().println("检测到您的IP访问异常，已加入黑名单");
                redisTemplate.opsForSet().add("anti:refresh:blacklist",remoteAddr);
                return false;
            }
            else {
                redisTemplate.opsForValue().increment(key, 1L);
            }
        }
        return true;
    }
}
