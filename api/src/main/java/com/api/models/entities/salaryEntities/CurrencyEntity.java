package com.api.models.entities.salaryEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "CURRENCIES")
public class CurrencyEntity {
    
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;
}
