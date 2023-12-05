package com.revature.Revagenda.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;


@Embeddable
public class CompositeKey implements Serializable {
    private Integer keyPartOne;

    private String keyPartTwo;
}
