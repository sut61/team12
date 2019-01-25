package sut.se.team12.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.Room;
@RepositoryRestResource
public interface RoomRepository extends JpaRepository<Room,Long>{
    Room findByRoomId(Long roomId);
    Room findByRoomNumber(String roomNumber);
}
