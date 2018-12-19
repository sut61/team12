package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_degree")
public class Degree {
    @Id
    @SequenceGenerator(name="degree_seq",sequenceName = "degree_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "degree_seq")
    @Column(name = "DEGREE_ID")
    private Long degreeId;
    private String degreeType;
}