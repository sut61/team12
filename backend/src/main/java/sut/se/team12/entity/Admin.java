package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_admin")
public class Admin {
    @Id
    @SequenceGenerator(name="admin_seq",sequenceName = "admin_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
    @Column(name = "ADMIN_ID")
    private Long adminId;
    private String name;
    private String username;
    private String password;

}
