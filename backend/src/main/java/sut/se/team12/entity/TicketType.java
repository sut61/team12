package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @Column(name = "TICKETTYPE_ID",unique=true)
    private Long ticketTypeId;
    @NotNull
    private String ticketType;
    @NotNull
    private Double price;
}
