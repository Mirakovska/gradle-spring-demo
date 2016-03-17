package webConfig;

import config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * An implementation of the WebApplicationInitializer interface configures
 * the ServletContext programmatically.  In particular, it allows for the creation,
 * configuration, and registration of the DispatcherServlet programmatically.
 */
public class WebInitializer implements WebApplicationInitializer {

    public static final String DISPATCHER_SERVLET_MAPPING = "/";
    public static final java.lang.String DISPATCHER_NAME = "dispatcher";


    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("on startup.............................");
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        /**
         * The ApplicationContext is where your Spring beans live.
         * The purpose of the ContextLoaderListener is two-fold:
         * - to tie the lifecycle of the ApplicationContext to the lifecycle of the ServletContext and
         * - to automate the creation of the ApplicationContext, so you don't have to write explicit code to do create it - it's a convenience function.
         */
        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();

        dispatcherServlet.register(MVCDispatcher.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_NAME, new DispatcherServlet(dispatcherServlet));


        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);

    }


}
