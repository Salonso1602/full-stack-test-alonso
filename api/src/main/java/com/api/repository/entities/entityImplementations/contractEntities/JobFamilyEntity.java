package com.api.repository.entities.entityImplementations.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="JOB_FAMILIES")
public class JobFamilyEntity {

    @Id
    @Column(name = "family_name")
    private String familyName;

}
