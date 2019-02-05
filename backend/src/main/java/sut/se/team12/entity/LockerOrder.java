package sut.se.team12.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_lockerOrder")
public class LockerOrder {
    @Id
    @SequenceGenerator(name="lockerOrder_seq",sequenceName = "lockerOrder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lockerOrder_seq")
    @Column(name = "LOCKERORDER_ID")
    private Long lockerOrderId;
    @Temporal(TemporalType.DATE)private Date Date;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Locker.class)
    @JoinColumn(name = "LOCKER_ID", insertable = true)
    private Locker locker;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LockerDuration.class)
    @JoinColumn(name = "LOCKERDURATION_ID", insertable = true)
    private LockerDuration lockerDuration;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;
}