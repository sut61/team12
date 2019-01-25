package sut.se.team12.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_room")
public class Room {
    @Id
    @SequenceGenerator(name="room_seq",sequenceName = "room_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @Column(name = "ROOM_ID")
    private Long roomId;
    private String roomNumber;
}
