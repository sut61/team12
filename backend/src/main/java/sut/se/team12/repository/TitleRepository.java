package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Title;

@RepositoryRestResource
public interface TitleRepository extends JpaRepository<Title,Long>{
    Title findByTitleId(Long titleId);
    Title findByTitleType(String titleType);
}
