package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_employee")
public class Employee {
    @Id
    @SequenceGenerator(name="employee_seq",sequenceName = "employee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    private String id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Title.class)
    @JoinColumn(name = "TITLE_ID", insertable = true)
    private  Title title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Degree.class)
    @JoinColumn(name = "DEGREE_ID", insertable = true)
    private  Degree degree;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", insertable = true)
    private  Position position;

}