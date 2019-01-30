package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;

import sut.se.team12.entity.Member;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface MemberRepository extends JpaRepository<Member,Long>{
    // PostalOrder findFirstByPostalOrderByIdDesc(Long postalOrderId);
    Member findByMemberId(Long memberId);
}
