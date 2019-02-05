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
@Table(name = "tb_lease")

public class Lease {
    @Id
    @SequenceGenerator(name="lease_seq",sequenceName="lease_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lease_seq")
    @Column(name="LEASE_ID")
    private Long leaseId;
    private String note;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private  Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LeaseAccessory.class)
    @JoinColumn(name = "LEASEACCEESSORY_ID", insertable = true)
    private  LeaseAccessory accessory;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LeaseDuration.class)
    @JoinColumn(name = "LEASEDURATION_ID", insertable = true)
    private  LeaseDuration duration;



	
}