package sut.se.team12.entity;
import lombok.*;
import java.util.Date;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_roomCancelOrder")
public class RoomCancelOrder {
    @Id
    @SequenceGenerator(name="roomCancelOrder_seq",sequenceName = "roomCancelOrder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomCancelOrder_seq")
    @Column(name = "ROOMCANCELORDER_ID")
    private Long roomCancelOrderId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String note;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomOrder.class)
    @JoinColumn(name = "ROOMORDER_ID", insertable = true)
    private RoomOrder roomOrder;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomStatus.class)
    @JoinColumn(name = "ROOMSTATUS_ID", insertable = true)
    private RoomStatus roomStatus;

}
