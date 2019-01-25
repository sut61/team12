package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_leaseaccessory")

public class LeaseAccessory {
    @Id
    @SequenceGenerator(name="leaseaccessory_seq",sequenceName="leaseaccessory_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="leaseaccessory_seq")
    @Column(name="LEASEACCESSORY_ID")
    private Long accessoryId;
    private String accessoryName; 
}