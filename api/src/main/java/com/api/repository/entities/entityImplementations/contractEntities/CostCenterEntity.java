package com.api.repository.entities.entityImplementations.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "COST_CENTERS")

@NoArgsConstructor
@AllArgsConstructor
public class CostCenterEntity {

    @Id
    @Column(name = "id", nullable = false)
    
    private String id;

    @Column(name = "center_name")
    private String centerName;

}
