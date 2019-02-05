package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Locker;

@RepositoryRestResource
public interface LockerRepository extends  JpaRepository<Locker, Long>{
    Locker findByLockerId(Long lockerId);
    Locker findByLockerName(String lockerName);
}
