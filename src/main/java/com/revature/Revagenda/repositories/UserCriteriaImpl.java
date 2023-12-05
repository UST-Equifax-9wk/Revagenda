package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public class UserCriteriaImpl implements UserCriteria{
    private EntityManager entityManager;

    /*
    EntityManager is the spring class that wraps around the hibernate session. This is the thing
    which manages persistent entities. The hibernate session is a "context", a configurable system loaded
    into memory to do a job. So, we could also consider the hibernate session a "persistence context".

    Hibernate session, persistence context, entity manager... these are all names for the same thing.
    In spring it is the class EntityManager, and we can get it from the Spring ApplicationContext multiple
    ways
     */
    @PersistenceContext//This is effectively field autowiring, which is not best practice
    private EntityManager persistenceContext;

    @Autowired//here we are using constructor autowiring, this is a better method than above.
    public UserCriteriaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /*
    Criteria builder example. This exists here because we need to provide a concrete implementation, and we need
    to make use of the entity manager (the hibernate session). We create another interface, and here we define the
    concrete behavior of the method findUsersByFirstName. In the RepositoryBean interface we extend the UserCriteria
    interface as well as the repository interface. When spring proxies that interface into a bean, it will
    look here for the concrete implementation. Note for this to work all class names must conform to ordinary Java
     conventions, that is the concrete class should be named with the "Impl" suffix.
     */
    @Override
    public List<User> findUsersByFirstName(String firstName) {
        //CriteriaBuilder builder = persistenceContext.getCriteriaBuilder();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();//the two methods above both get us the hibernate session
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("firstName"), firstName));
        return entityManager.createQuery(query).getResultList();
    }
}
