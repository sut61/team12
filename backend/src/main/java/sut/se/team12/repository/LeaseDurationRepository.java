package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sut.se.team12.entity.LeaseDuration;;

@RepositoryRestResource
public interface LeaseDurationRepository extends JpaRepository<LeaseDuration, Long>{
    LeaseDuration findByDurationId(Long durationId);
    LeaseDuration findByDurationName(String durationName);
}
