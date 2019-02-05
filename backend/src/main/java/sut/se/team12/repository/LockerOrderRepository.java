package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.LockerOrder;

@RepositoryRestResource
public interface LockerOrderRepository extends  JpaRepository<LockerOrder, Long>{
    LockerOrder findByLockerOrderId(Long lockerOrderId);
}
