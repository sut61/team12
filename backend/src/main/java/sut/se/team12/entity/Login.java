package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_login")
public class Login {
    @Id
    @SequenceGenerator(name="login_seq",sequenceName = "login_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login_seq")
    @Column(name = "LOGIN_ID")
    private Long loginId;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

}