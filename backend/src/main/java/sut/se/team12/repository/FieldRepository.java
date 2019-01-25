package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Field;

@RepositoryRestResource
public interface FieldRepository extends  JpaRepository<Field, Long>{
    Field findByFieldId(Long fieldId);
    Field findByFieldName(String fieldName);
}
