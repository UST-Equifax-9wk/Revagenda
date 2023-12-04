package com.revature.Revagenda.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;

@Component
public class BeanC {
    @Value("value annotation")
    private String myString;

    public BeanC() {
    }

    public void test() {
        System.out.println(myString);
    }


}
