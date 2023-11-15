package com.api.repository.repositories.interfaces.salaryRepos;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.api.repository.entities.entityImplementations.salaryEntities.CurrencyEntity;

@Repository
public interface ICurrencyRepository extends ListCrudRepository<CurrencyEntity, String> {
}
