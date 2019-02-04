package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.TrainingProgram;

@RepositoryRestResource
public interface TrainingProgramRepository extends JpaRepository<TrainingProgram,Long>{
    TrainingProgram findByProgramId(Long ProgramId);
    TrainingProgram findByProgramName(Long ProgramName);
}