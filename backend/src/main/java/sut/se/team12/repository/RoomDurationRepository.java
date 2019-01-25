package sut.se.team12.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.RoomDuration;
@RepositoryRestResource
public interface RoomDurationRepository extends JpaRepository<RoomDuration,Long>{
    RoomDuration findByroomDurationId(Long roomDurationId);
    RoomDuration findByRoomDuration(Long roomDuration);

}
