package sut.se.team12.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_roomDuration")
public class RoomDuration {
    @Id
    @SequenceGenerator(name="RoomDuration_seq",sequenceName = "RoomDuration_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RoomDuration_seq")
    @Column(name = "RoomDuration_ID")
    private Long roomDurationId;
    private String roomDuration;
}
