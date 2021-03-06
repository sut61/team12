package sut.se.team12.entity;

import lombok.*;

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
@Table(name = "tb_lease")

public class Lease {
    @Id
    @SequenceGenerator(name="lease_seq",sequenceName="lease_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lease_seq")
    @Column(name="LEASE_ID",unique=true)
    private Long leaseId;

    @NotNull
    @Size(min=5,max=30)
    @Pattern(regexp="[a-zA-z0-9. ]+")
    private String note;

    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private  Member member;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LeaseAccessory.class)
    @JoinColumn(name = "LEASEACCEESSORY_ID", insertable = true)
    private  LeaseAccessory accessory;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LeaseDuration.class)
    @JoinColumn(name = "LEASEDURATION_ID", insertable = true)
    private  LeaseDuration duration;



	
}