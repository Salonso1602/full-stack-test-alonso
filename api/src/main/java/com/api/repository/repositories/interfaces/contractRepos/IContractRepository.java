package com.api.repository.repositories.interfaces.contractRepos;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.api.repository.entities.entityImplementations.contractEntities.ContractEntity;

@Repository
public interface IContractRepository extends ListCrudRepository<ContractEntity, String> {
}
