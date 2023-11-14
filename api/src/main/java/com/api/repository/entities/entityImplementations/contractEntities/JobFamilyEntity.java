package com.api.repository.entities.entityImplementations.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity(name="JOB_FAMILIES")

@NoArgsConstructor
@AllArgsConstructor
public class JobFamilyEntity {

    @Id
    @Column(name = "family_name", nullable = false)
    
    private String familyName;

}
