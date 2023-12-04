package com.revature.Revagenda.controllers;

import com.revature.Revagenda.services.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class ControllerBean {
    private ServiceBean service;

    @Autowired
    public ControllerBean(ServiceBean service) {
        this.service = service;
    }

    //HTTP GET
    public Object get(String name) {
        return this.service.find(name);
    }

    //HTTP POST
    public void post(String name, Object obj) {
        this.service.save(name, obj);
    }


}
