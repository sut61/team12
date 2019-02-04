package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_training_type")
public class TrainingType {
    @Id
    @SequenceGenerator(name="trainingType_seq",sequenceName = "trainingType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainingType_seq")
    @Column(name = "TYPE_ID")
    private Long typeId;
    private String typeName;
}