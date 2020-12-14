package com.ziumks.iot;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ClassUtils;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

//import com.samskivert.mustache.Mustache;

@SpringBootApplication
public class IotApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotApplication.class, args);
	}

	
	
	@Bean
	public BeanPostProcessor mutacheHackerBeanPostProcessor() {
	    return new BeanPostProcessor() {
	        private static final String BEAN_NAME = "mustacheCompiler";

	        @Override
	        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	            return bean;
	        }

	        // mustache의 key 혹은 value가 null일때 에러 방지.
//	        @Override
//	        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//	            if (ClassUtils.isAssignable(bean.getClass(), Mustache.Compiler.class) || BEAN_NAME.equals(beanName)) {
//	                System.out.println("----------");
//	                System.out.println("hack ok!!!");
//	                System.out.println("----------");
//	                Mustache.Compiler compiler = (Mustache.Compiler) bean;
//	                return compiler.defaultValue("").nullValue("");
//	            }
//
//	            return bean;
//	        }




	    };
	}
}

