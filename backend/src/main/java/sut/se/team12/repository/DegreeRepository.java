package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Degree;

@RepositoryRestResource
public interface DegreeRepository extends JpaRepository<Degree,Long>{
    Degree findByDegreeId(Long degreeId);
    Degree findByDegreeType(String degreeType);
}
