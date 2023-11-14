package com.api.repository.repositories.interfaces.contractRepos;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.api.repository.entities.entityImplementations.contractEntities.TimeTypeEntity;

@Repository
public interface ITimeTypeRepository extends ListCrudRepository<TimeTypeEntity, String> {
}
