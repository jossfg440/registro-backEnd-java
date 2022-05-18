package ec.gob.como;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/cliente").setViewName("cliente");
		//registry.addViewController("/").setViewName("home");
		registry.addViewController("/lista").setViewName("lista");
		//registry.addViewController("/login").setViewName("login");
	}

}