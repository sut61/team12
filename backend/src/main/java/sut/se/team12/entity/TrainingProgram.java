package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_training_program")
public class TrainingProgram {
    @Id
    @SequenceGenerator(name="trainingProgram_seq",sequenceName = "trainingProgram_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainingProgram_seq")
    @Column(name = "PROGRAM_ID")
    private Long programId;
    private String programName;
}