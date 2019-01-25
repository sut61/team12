package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;

import sut.se.team12.entity.Privilege;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface PrivilegeRepository extends JpaRepository<Privilege,Long>{
    // PostalOrder findFirstByPostalOrderByIdDesc(Long postalOrderId);
    Privilege findByPrivilegeName(String privilegeName);
    Privilege findByPrivilegeId(Long priviledgeId);
}