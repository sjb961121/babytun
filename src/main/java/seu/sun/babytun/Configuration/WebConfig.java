package seu.sun.babytun.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import seu.sun.babytun.Interceptor.AntiRefreshInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AntiRefreshInterceptor antiRefreshInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(antiRefreshInterceptor).addPathPatterns("/goods");
    }
}
