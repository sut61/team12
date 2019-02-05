package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.LockerDuration;

@RepositoryRestResource
public interface LockerDurationRepository extends  JpaRepository<LockerDuration, Long>{
    LockerDuration findByLockerDurationId(Long lockerDurationId);
    LockerDuration findByLockerDuration(String lockerDuration);

}
