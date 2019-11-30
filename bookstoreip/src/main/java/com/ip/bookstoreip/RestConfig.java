package com.ip.bookstoreip;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("org.liferayasif.backend")
public class RestConfig extends WebMvcConfigurerAdapter{
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
	        configurer.enable();
	    }

	    /*
	     * (non-Javadoc)
	     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	     * To avoid 'Access-Control-Allow-Origin'
	     * Above error arising when I am hitting from angular to our rest service
	     */
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
}
