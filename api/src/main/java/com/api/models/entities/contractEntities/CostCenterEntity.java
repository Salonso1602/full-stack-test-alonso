package com.api.models.entities.contractEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "COST_CENTERS")
public class CostCenterEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "center_name")
    private String centerName;

}
