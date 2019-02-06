package sut.se.team12.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.RoomStatus;
@RepositoryRestResource
public interface RoomStatusRepository extends JpaRepository<RoomStatus,Long>{
    RoomStatus findByroomStatusId(Long roomStatusId);
    RoomStatus findByroomStatus(Long roomStatus);
}
