package com.api.repository.entities.entityImplementations.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity(name = "CONTRACT_TIME_TYPES")

@NoArgsConstructor
@AllArgsConstructor
public class TimeTypeEntity {

    @Id
    @Column(name = "time_type", nullable = false)
    
    private String timeType;
}
