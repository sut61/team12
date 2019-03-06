package sut.se.team12.entity;
import lombok.*;
import javax.persistence.*;
//import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_roomStatus")
public class RoomStatus {
    @Id
    @SequenceGenerator(name="RoomStatus_seq",sequenceName = "RoomStatus_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RoomStatus_seq")
    @Column(name = "RoomStatus_ID")
    private Long roomStatusId;
    private String roomStatus;

}
