package com.api.repository.entities.entityImplementations.contractEntities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="JOB_PROFILES")

@NoArgsConstructor
@AllArgsConstructor
public class JobProfileEntity {

    @Id
    @Column(name = "profile", nullable = false)
    
    private String profile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="family", referencedColumnName = "family_name", nullable = false)
    
    private JobFamilyEntity family;
}
