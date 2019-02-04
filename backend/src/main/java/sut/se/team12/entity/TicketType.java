package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_ticketType")
public class TicketType {
    @Id
    @SequenceGenerator(name="ticketType_seq",sequenceName = "ticketType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketType_seq")
    @Column(name = "TICKETTYPE_ID")
    private Long ticketTypeId;
    private String ticketType;
    private Double price;
}
