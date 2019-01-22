package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Admin;

@RepositoryRestResource
public interface AdminRepository extends  JpaRepository<Admin, Long>{
   Admin findByAdminId(Long adminId);
   Admin findByUsername(String username);
   Admin findByPassword(String password);
}
