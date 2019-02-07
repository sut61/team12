package sut.se.team12.repository;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.RoomOrder;
@RepositoryRestResource
public interface RoomOrderRepository extends JpaRepository<RoomOrder,Long> {
    RoomOrder findByRoomOrderId(Long roomOrderId);
    @Query(value = "SELECT * FROM TB_ROOM_ORDER WHERE ROOMSTATUS_ID = 1L", nativeQuery = true)
    Collection<RoomOrder> findByRoomStatus1();
}
