package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Training;

@RepositoryRestResource
public interface TrainingRepository extends JpaRepository<Training,Long>{
    Training findByTrainingId(Long TrainingId);
}