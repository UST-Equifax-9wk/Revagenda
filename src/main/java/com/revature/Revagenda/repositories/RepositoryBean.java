package com.revature.Revagenda.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryBean {
    private Map<String, Object> objectStore;

    public RepositoryBean() {
        this.objectStore = new HashMap<>();
    }

    public void create(String name, Object obj) {
        this.objectStore.put(name, obj);
    }

    public Object read(String name) {
        return this.objectStore.get(name);
    }
}
