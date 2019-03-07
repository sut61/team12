package sut.se.team12.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_lockerOrder")
public class LockerOrder {

    @NotNull
    @Id
    @SequenceGenerator(name="lockerOrder_seq",sequenceName = "lockerOrder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lockerOrder_seq")
    @Column(name = "LOCKERORDER_ID",unique=true)
    private Long lockerOrderId;


    @NotNull 
    @Size(min=2,max=20) 
    @Pattern(regexp = "[A-Za-z0-9]+") 
    private String note;

    @NotNull 
    @Temporal(TemporalType.DATE)private Date Date;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Locker.class)
    @JoinColumn(name = "LOCKER_ID", insertable = true)
    private Locker locker;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private Member member;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LockerDuration.class)
    @JoinColumn(name = "LOCKERDURATION_ID", insertable = true)
    private LockerDuration lockerDuration;



    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;
}