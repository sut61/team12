package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_locker")


public class Locker {
    @Id
    @SequenceGenerator(name="locker_seq",sequenceName="locker_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="locker_seq")
    @Column(name="LOCKER_ID")
    private Long lockerId;
    private String lockerName;
}
