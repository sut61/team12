package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_leaseduration")

public class LeaseDuration {
    @Id
    @SequenceGenerator(name="leaseduration_seq",sequenceName="leaseduration_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="leaseduration_seq")
    @Column(name="LEASEDURATION_ID")
    private Long durationId;
    private String durationName;
    
}