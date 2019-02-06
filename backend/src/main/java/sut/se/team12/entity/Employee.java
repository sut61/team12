package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// import org.hibernate.validator.constraints.UniqueElements;

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

    @NotNull
    @Size(min=13, max=13)
    @Pattern(regexp = "\\d+")
    @Column(unique = true)
    private String id;

    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-z]+")
    @Size(min=2,max=20)
    private String firstName;
    
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-z]+")
    @Size(min=2,max=20)
    private String lastName;

    // @Size(min = 10, max = 10)
    // @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
    // @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])\\-(0[1-9]|1[012])\\-\\d{4}$")
    // @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    @Size(min=10, max=10)
    @Pattern(regexp = "\\d+")
    private String phone;

    // @Size(min=13, max=13)
    @NotNull
    @Size(min=6,max=50)
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String email;

    @NotNull
    @Size
    @Pattern(regexp = "[A-Za-z0-9'\\.\\-\\s\\,]+")
    private String address;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Title.class)
    @JoinColumn(name = "TITLE_ID", insertable = true)
    private  Title title;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Degree.class)
    @JoinColumn(name = "DEGREE_ID", insertable = true)
    private  Degree degree;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", insertable = true)
    private  Position position;

}