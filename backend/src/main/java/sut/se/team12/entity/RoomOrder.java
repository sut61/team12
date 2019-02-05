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
@Table(name = "tb_roomOrder")
public class RoomOrder {
    @Id
    @SequenceGenerator(name="roomOrder_seq",sequenceName = "roomOrder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomOrder_seq")
    @Column(name = "ROOMORDER_ID")
    
    
    private Long roomOrderId;
    @Temporal(TemporalType.DATE)
    private Date date;
    
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Room.class)
    @JoinColumn(name = "ROOM_ID", insertable = true)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomDuration.class)
    @JoinColumn(name = "RoomDuration_ID", insertable = true)
    private RoomDuration roomDuration;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomStatus.class)
    @JoinColumn(name = "ROOMSTATUS_ID", insertable = true)
    private RoomStatus roomStatus;
}
