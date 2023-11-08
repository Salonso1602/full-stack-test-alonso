package com.api.models.entities.contractEntities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name="JOB_PROFILES")
public class JobProfileEntity {

    @Id
    @Column(name = "profile")
    private String profile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="family", referencedColumnName = "family_name")
    private JobFamilyEntity family;
}
