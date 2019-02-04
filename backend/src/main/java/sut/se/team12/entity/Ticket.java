package sut.se.team12.entity;

import lombok.*;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_ticket")
public class Ticket {
    @Id
    @SequenceGenerator(name="ticket_seq",sequenceName = "ticket_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @Column(name = "TICKET_ID")
    private Long ticketId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private LocalTime  time;
    private String name;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TicketType.class)
    @JoinColumn(name = "TicketType_ID", insertable = true)
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Field.class)
    @JoinColumn(name = "Field_ID", insertable = true)
    private Field field;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;

}