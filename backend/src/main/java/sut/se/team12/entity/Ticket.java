package sut.se.team12.entity;

import lombok.*;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Column(unique = true)
    private Long ticketId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private LocalTime  time;
    @NotNull
    @Size(min=2, max=20)
    @Pattern(regexp="[A-Za-z]+")
    private String name;
    @NotNull
    @Pattern(regexp="(0[0-9]{9})")
    private String phoneNumber;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TicketType.class)
    @JoinColumn(name = "TicketType_ID", insertable = true)
    private TicketType ticketType;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Field.class)
    @JoinColumn(name = "Field_ID", insertable = true)
    private Field field;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;

}