package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.CompositeKey;
import com.revature.Revagenda.entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, CompositeKey> {
}
