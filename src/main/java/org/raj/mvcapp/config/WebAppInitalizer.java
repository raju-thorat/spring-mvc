package org.raj.mvcapp.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.raj.mvcapp.interceptors.MyInterceptor1;
import org.raj.mvcapp.interceptors.MyInterceptor2;
import org.raj.mvcapp.interceptors.MyInterceptor3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebMvc
@ComponentScan("org.raj.mvcapp")
public class WebAppInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { WebAppInitalizer.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[0];
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
	}

	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Map<String, Object> map = new HashMap<>();
		map.put("/hello", httpRequestHandler());
		mapping.setUrlMap(map);
		mapping.setInterceptors(new Object[] { new MyInterceptor1(), new MyInterceptor2() });
		return mapping;
	}

	@Bean
	HttpRequestHandler httpRequestHandler() {
		return new MyHttpRequestHandler();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/v1/**");
		registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/v2/**");
		registry.addInterceptor(new MyInterceptor3());
	}
}