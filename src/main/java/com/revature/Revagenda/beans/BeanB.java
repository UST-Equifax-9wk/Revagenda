package com.revature.Revagenda.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {
    BeanC dependentBean;

    @Autowired
    public BeanB(BeanC beanC) {
        this.dependentBean = beanC;
    }

    public void test() {
        this.dependentBean.test();
    }
}
