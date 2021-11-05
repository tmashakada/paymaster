package com.fmauye.paymaster;

import com.sun.faces.config.ConfigureListener;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
@SpringBootApplication
public class SpringbootprimefacesApplication {

    
	public static void main(String[] args) {
		SpringApplication.run(SpringbootprimefacesApplication.class, args);
	}
 @Bean
  ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
      //spring boot only works if this is set
      servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
     servletContext.setInitParameter("com.sun.faces.compressJavaScript", FALSE.toString());
		 servletContext.setInitParameter("com.sun.faces.enableClientStateDebugging", TRUE.toString());
		 servletContext.setInitParameter("com.sun.faces.expressionFactory", "org.apache.el.ExpressionFactoryImpl");
		 servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", TRUE.toString());
		 servletContext.setInitParameter("com.sun.faces.sendPoweredByHeader", TRUE.toString());
		 servletContext.setInitParameter("facelets.DEVELOPMENT", TRUE.toString());
		 servletContext.setInitParameter("Javax.faces.CONFIG_FILES", "/WEB-INF/faces-config.xml");
		 servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
		 servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", FALSE.toString());
		 servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", TRUE.toString());
		 servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		 servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
		 servletContext.setInitParameter("primefaces.THEME", "nova-light");
      
//registration
      ServletRegistrationBean srb = new ServletRegistrationBean();
      srb.setServlet(new FacesServlet());
      srb.setUrlMappings(Arrays.asList("*.xhtml"));
      srb.setLoadOnStartup(1);
      return srb;
  }

}
