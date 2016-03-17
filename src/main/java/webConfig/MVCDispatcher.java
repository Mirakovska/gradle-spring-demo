package webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * This class creates the dispatcher servlet
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
public class MVCDispatcher extends WebMvcConfigurerAdapter {

    /**
     * Registers a location where static resources can be found
     * <p>
     * No controller needs to be defines, request to /resources/something goes straight to the resource
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("adding resource handlers.....");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    /**
     * @param configurer : Configures a request handler for serving static resources
     *                   by forwarding the request to the Servlet container's "default" Servlet.
     *                   This is intended to be used when the Spring MVC DispatcherServlet is mapped to "/"
     *                   thus overriding the Servlet container's default handling of static resources.
     *                   Since this handler is configured at the lowest precedence, effectively it allows all
     *                   other handler mappings to handle the request, and if none of them do,
     *                   this handler can forward it to the "default" Servlet.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * jsp view resolver
     */
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        bean.setOrder(2);
        return bean;
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

}
