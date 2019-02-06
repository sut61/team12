package sut.se.team12.entity;

import lombok.*;

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
@Table(name = "tb_member")
public class Member {
    @Id
    @SequenceGenerator(name="member_seq",sequenceName = "member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @NotNull
    @Size(min=2, max=20)
    @Pattern(regexp="[A-Za-z]+")
    private String firstName;
    @NotNull
    @Size(min=2, max=20)
    @Pattern(regexp="[A-Za-z]+")
    private String lastName;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @NotNull
    @Size(min=10,max=30)
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    @Column(unique=true)
    private String email;
    @NotNull
    @Pattern(regexp= "^0([0-9]{9})")
    private String phoneNumber;
    @NotNull
    @Size(min=2,max=50)
    @Pattern(regexp = "[A-Za-z0-9'\\.\\-\\s\\,]+")
    private String address;
    @NotNull
    @Size(min=3, max=20)
    @Pattern(regexp="[A-Za-z]+")
    private String subDistrict;
    @NotNull
    @Size(min=3, max=20)
    @Pattern(regexp="[A-Za-z]+")
    private String district;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Title.class)
    @JoinColumn(name = "TITLE_ID", insertable = true)
    private Title title;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province province;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Privilege.class)
    @JoinColumn(name = "PRIVILEDGE_ID", insertable = true)
    private Privilege privilege;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;

}