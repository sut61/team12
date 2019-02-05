package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

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
    private String Note;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private  Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Field.class)
    @JoinColumn(name = "FIELD_ID", insertable = true)
    private Field field;

}

