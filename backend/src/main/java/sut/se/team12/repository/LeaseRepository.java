package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Lease;

@RepositoryRestResource
public interface LeaseRepository extends JpaRepository<Lease, Long>{
    Lease findByLeaseId(Long leaseId);
}
