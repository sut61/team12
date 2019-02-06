package sut.se.team12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.CrossOrigin;

import sut.se.team12.entity.Notification;
@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface NotificationRepository extends JpaRepository<Notification,Long>{
    // PostalOrder findFirstByPostalOrderByIdDesc(Long postalOrderId);
    Notification findByNotificationId(Long notificationId);
    
}
