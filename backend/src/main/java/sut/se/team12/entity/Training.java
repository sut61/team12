package sut.se.team12.entity;

import lombok.*;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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
    @Column(name = "TRAINING_ID",unique = true)
    private Long trainingId;

    
    @NotNull
    @Column(unique = true)
    private String title;

    @NotNull
    private String description;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    
    @NotNull
    @Size(min=2,max=30)
    @Pattern(regexp="[A-Za-z\\s\\.]+")
    private String instructor;

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9'\\.\\-\\s\\,]+")
    private String location;

    @NotNull
    private Integer enrollment;

    @NotNull
    private Long cost;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private  Admin admin;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingType.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    private  TrainingType trainingType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TrainingProgram.class)
    @JoinColumn(name = "PROGRAM_ID", insertable = true)
    private  TrainingProgram trainingProgram;

}