package com.feedient;

import com.feedient.service.BlogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xaviergeerinck on 21/11/13.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        final BlogService blogService = context.getBean(BlogService.class);


    }
}
