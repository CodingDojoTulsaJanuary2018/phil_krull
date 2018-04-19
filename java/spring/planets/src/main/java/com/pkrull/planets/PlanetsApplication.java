package com.pkrull.planets;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// had to change to imports on the platform to these, as the locations have changed
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlanetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanetsApplication.class, args);
	}
	
	@Bean
	// different method from the platform instructions
    public ServletWebServerFactory servletContainer() {
		// different class needed for the web server container
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        Connector ajpConnector = new Connector("AJP/1.3");
        ajpConnector.setPort(9090);
        ajpConnector.setSecure(false);
        ajpConnector.setAllowTrace(false);
        ajpConnector.setScheme("http");
        tomcat.addAdditionalTomcatConnectors(ajpConnector);
        return tomcat;
    }
}
