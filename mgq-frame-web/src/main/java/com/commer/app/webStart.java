package com.commer.app;


import com.commer.app.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * 博客內容展示站點
 */
@SpringBootApplication
@ImportResource(locations={"classpath:dubbo-consumer.xml"})
public class webStart extends SpringBootServletInitializer
{

    public static void main( String[] args )
    {
        ApplicationContext tc = SpringApplication.run(webStart.class, args);
        UserService userService = tc.getBean(UserService.class);
        System.out.println(userService.selectByPrimaryKey(1).getUsername());
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(webStart.class);
    }
    /*@Configuration
    static class WebMvcConfigurer extends WebMvcConfigurerAdapter {

        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new HandlerInterceptorAdapter() {

                @Override
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                         Object handler) throws Exception {
                	
                	HttpSession userVo = request.getSession();
                	String uVo = request.getSession().getId();
                    request.getContextPath();
                    System.out.println("interceptor====");
                    return true;
                }
            }).addPathPatterns("/*");
        }
    }*/
    
    /*@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

       return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
       });
    }*/
}
