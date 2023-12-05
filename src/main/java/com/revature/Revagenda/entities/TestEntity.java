package com.revature.Revagenda.entities;

import jakarta.persistence.*;

import java.util.Objects;

/*
This is to test composite keys in Spring Data JPA
 */
@Entity
public class TestEntity {
    @EmbeddedId
    @Column(name = "test_id")
    private CompositeKey testId;

    @Column
    private String value;

    public TestEntity() {
    }

    public TestEntity(CompositeKey testId, String value) {
        this.testId = testId;
        this.value = value;
    }

    public TestEntity(String value) {
        this.value = value;
    }

    public CompositeKey getTestId() {
        return testId;
    }

    public void setTestId(CompositeKey testId) {
        this.testId = testId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return Objects.equals(testId, that.testId) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, value);
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "testId=" + testId +
                ", value='" + value + '\'' +
                '}';
    }
}
