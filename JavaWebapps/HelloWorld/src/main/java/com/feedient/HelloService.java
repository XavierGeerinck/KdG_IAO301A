package com.feedient;

import org.springframework.stereotype.Component;

@Component("hello")
public class HelloService implements IHello {
    public String sayHello() {
        return "Hello world!";
    }
}
