package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.FieldDuration;

@RepositoryRestResource
public interface FieldDurationRepository extends  JpaRepository<FieldDuration, Long>{
    FieldDuration findByFieldDurationId(Long fieldDurationId);
    FieldDuration findByFieldDuration(String fieldDuration);

}
