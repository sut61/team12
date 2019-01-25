package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.LeaseAccessory;;

@RepositoryRestResource
public interface LeaseAccessoryRepository extends JpaRepository<LeaseAccessory, Long>{
    LeaseAccessory findByAccessoryId(Long accessoryId);
    LeaseAccessory findByAccessoryName(String accessoryName);
}
