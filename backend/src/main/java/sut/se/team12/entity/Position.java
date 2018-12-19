package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_position")
public class Position {
    @Id
    @SequenceGenerator(name="position_seq",sequenceName = "position_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq")
    @Column(name = "POSITION_ID")
    private Long positionId;
    private String positionType;
}