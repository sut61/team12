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
@Table(name = "tb_privilege")

public class Privilege {
    @Id
    @SequenceGenerator(name="privilege_seq",sequenceName="privilege_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="privilege_seq")
    @Column(name="PRIVILEGE_ID",unique=true)
    private Long privilegeId;
    @NotNull
    private String privilegeName;
    @NotNull
    private Double price;
}