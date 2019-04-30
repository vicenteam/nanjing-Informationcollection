package com.stylefeng.guns;

import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringBoot方式启动类
 *
 * @author stylefeng
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
@EnableScheduling
public class GunsApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(GunsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GunsApplication.class, args);
        logger.info("GunsApplication is success!");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/.well-known/**").addResourceLocations("classpath:/.well-known/");
        super.addResourceHandlers(registry);
    }

//    @Bean
//    public TomcatServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");//confidential
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(httpConnector());
//        return tomcat;
//
//    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");

        //Set the scheme that will be assigned to requests received through this connector
        //@param scheme The new scheme
        connector.setScheme("http");

        //Set the port number on which we listen for requests.
        // @param port The new port number
        connector.setPort(80);

        //Set the secure connection flag that will be assigned to requests received through this connector.
        //@param secure The new secure connection flag
        //if connector.setSecure(true),the http use the http and https use the https;else if connector.setSecure(false),the http redirect to https;
        connector.setSecure(false);

        //redirectPort The redirect port number (non-SSL to SSL)
//        connector.setRedirectPort(443);
        return connector;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
