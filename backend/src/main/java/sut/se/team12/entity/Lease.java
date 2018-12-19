package sut.se.team12.entity;

import lombok.*;
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
    private String leaseName;
}