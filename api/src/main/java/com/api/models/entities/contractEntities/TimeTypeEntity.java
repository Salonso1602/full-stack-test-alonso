package com.api.models.entities.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "CONTRACT_TIME_TYPES")
public class TimeTypeEntity {

    @Id
    @Column(name = "time_type")
    private String timeType;
}
