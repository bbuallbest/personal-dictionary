package rest.api.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author bbuallbest
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpringContextInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("contextConfigLocation", "repository.config");
        WebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(rootAppContext));
    }
}
