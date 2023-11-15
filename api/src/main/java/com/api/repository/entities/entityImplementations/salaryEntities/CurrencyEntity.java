package com.api.repository.entities.entityImplementations.salaryEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "CURRENCIES")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyEntity {
    
    @Id
    @Column(name = "code", nullable = false)
    private String code;
}
