package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Position;

@RepositoryRestResource
public interface PositionRepository extends JpaRepository<Position, Long>{
    Position findByPositionId(Long positionId);
    Position findByPositionType(String positionType);
}
