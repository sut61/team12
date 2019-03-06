package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @Column(name = "ADMIN_ID",unique=true)
    private Long adminId;
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;

}
