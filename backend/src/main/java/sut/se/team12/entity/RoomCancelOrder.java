package sut.se.team12.entity;

import lombok.*;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Column(name = "ROOMCANCELORDER_ID",unique=true)
    @NotNull
    private Long roomCancelOrderId;
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @NotNull
    @Size(min = 5, max = 30)
    @Pattern(regexp = "[A-Za-z /t]+")
    private String note;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomOrder.class)
    @JoinColumn(name = "ROOMORDER_ID", insertable = true)
    @NotNull
    private RoomOrder roomOrder;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    @NotNull
    private Admin admin;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomStatus.class)
    @JoinColumn(name = "ROOMSTATUS_ID", insertable = true)
   @NotNull
    private RoomStatus roomStatus;

}
