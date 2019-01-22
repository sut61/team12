package sut.se.team12.entity;

import lombok.*;
import java.util.Date;
import javax.persistence.*;

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
    private String name;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String address;
    private String subDistric;
    private String distric;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Title.class)
    @JoinColumn(name = "TITLE_ID", insertable = true)
    private Title title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Privilege.class)
    @JoinColumn(name = "PRIVILEDGE_ID", insertable = true)
    private Privilege privilege;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;
}
