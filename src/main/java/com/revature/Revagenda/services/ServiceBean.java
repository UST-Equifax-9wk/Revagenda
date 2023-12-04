package com.revature.Revagenda.services;

import com.revature.Revagenda.repositories.RepositoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBean {
    private RepositoryBean repo;

    @Autowired
    public ServiceBean(RepositoryBean repo) {
        this.repo = repo;
    }

    public Object find(String name) {
        return this.repo.read(name);
    }

    public void save(String name, Object obj) {
        this.repo.create(name, obj);
    }

}
