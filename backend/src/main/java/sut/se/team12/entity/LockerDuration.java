package sut.se.team12.entity;


import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_lockerDuration")


public class LockerDuration {
    @Id
    @SequenceGenerator(name="lockerDuration_seq",sequenceName="lockerDuration_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lockerDuration_seq")
    @Column(name="LOCKERDURATION_ID")
    private Long lockerDurationId;
    private String lockerDuration;
}