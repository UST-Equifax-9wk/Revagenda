package com.revature.Revagenda.beans;

import org.springframework.stereotype.Component;

@Component("ComponentBean")
public class ComponentBean {

    public void whoAmI() {
        System.out.println(this);
    }
}
