package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import sut.se.g12.entity.Admin;
import sut.se.team12.entity.Login;

@RepositoryRestResource
public interface LoginRepository extends  JpaRepository<Login, Long>{
   Login findByLoginId(Long loginId);
   // Login findByUsername(String username);
   // Login findByPassword(String password);
}