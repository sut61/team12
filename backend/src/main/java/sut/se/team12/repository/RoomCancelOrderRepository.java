package sut.se.team12.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team12.entity.RoomCancelOrder;
@RepositoryRestResource
public interface RoomCancelOrderRepository extends JpaRepository<RoomCancelOrder,Long> {
    RoomCancelOrder findByroomCancelOrderId(Long roomCancelOrderId);
}
