package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.TrainingType;

@RepositoryRestResource
public interface TrainingTypeRepository extends JpaRepository<TrainingType,Long>{
    TrainingType findByTypeId(Long typeId);
    TrainingType findByTypeName(Long typeName);
}