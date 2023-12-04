package com.revature.Revagenda.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("BeanA")
public class BeanA {
    private BeanB dependentBean;

    @Autowired
    public BeanA(BeanB beanB) {
        this.dependentBean = beanB;
    }

    public void test() {
        this.dependentBean.test();
    }

    public BeanB getDependentBean() {
        return dependentBean;
    }

    public void setDependentBean(BeanB dependentBean) {
        this.dependentBean = dependentBean;
    }
}
