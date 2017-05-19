package by.kanarski.profito.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan("by.kanarski.profito")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(
                Application.class,
                ServletInitializer.class
        );
        applicationBuilder.run(args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class, SecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        servletContext.addFilter("springSecurityFilterChain",
                new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/*");
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/", "/index.html", "*.html");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder
                .sources(
                        Application.class,
                        ServletInitializer.class);
    }

}
