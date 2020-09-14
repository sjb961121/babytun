package seu.sun.babytun.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import seu.sun.babytun.Exception.SecKillException;
import seu.sun.babytun.Service.SecKillService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SecKillController {
    @Autowired
    private SecKillService secKillService;

    @RequestMapping("/seckill")
    @ResponseBody
    public Map secKill(@RequestParam(value = "psId") Long psId, @RequestParam(value = "userId") String userId){
        Map result=new HashMap();
        try {
            secKillService.seckill(psId,userId,1);
            result.put("code","0");
            result.put("message","success");
        } catch (SecKillException e) {
            result.put("code","500");
            result.put("message",e.getMessage());
        }
        return result;
    }
}
