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
@Table(name = "tb_training")
public class Training {
    @Id
    @SequenceGenerator(name="training_seq",sequenceName = "training_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_seq")
    @Column(name = "TRAINING_ID")
    private Long trainingId;
    private String title;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
    private Date dateTo;
    
    private String instructor;
    private String location;
    private int enrollment;
    private Long cost;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingType.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    private  TrainingType trainingType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingProgram.class)
    @JoinColumn(name = "PROGRAM_ID", insertable = true)
    private  TrainingProgram trainingProgram;

}