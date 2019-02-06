package sut.se.team12.entity;

import lombok.*;
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
@Table(name = "tb_notification")

public class Notification {
    @Id
    @SequenceGenerator(name="notification_seq",sequenceName="notification_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="notification_seq")
    @Column(name="NOTIFICATION_ID")
    private Long notificationId;

    @NotNull
    @Size(min=5,max=30)
    @Pattern(regexp="[a-zA-z0-9. ]+")
    private String Note;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private  Employee employee;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Field.class)
    @JoinColumn(name = "FIELD_ID", insertable = true)
    private Field field;

}

