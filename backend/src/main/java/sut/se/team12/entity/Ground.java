package sut.se.team12.entity;


import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_ground")


public class Ground {
    @Id
    @SequenceGenerator(name="ground_seq",sequenceName="ground_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ground_seq")
    @Column(name="GROUND_ID")
    private Long groundId;
    private String groundName;
}
