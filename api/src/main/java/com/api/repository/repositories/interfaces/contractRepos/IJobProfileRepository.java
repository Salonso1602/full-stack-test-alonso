package com.api.repository.repositories.interfaces.contractRepos;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.api.repository.entities.entityImplementations.contractEntities.JobProfileEntity;

@Repository
public interface IJobProfileRepository extends ListCrudRepository<JobProfileEntity, String> {
}
