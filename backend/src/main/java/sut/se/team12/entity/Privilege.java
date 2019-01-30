package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

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
    @Column(name="PRIVILEGE_ID")
    private Long privilegeId;
    private String privilegeName;
    private Double price;
}