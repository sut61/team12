package sut.se.team12.entity;


import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_fieldDuration")


public class FieldDuration {
    @Id
    @SequenceGenerator(name="fieldDuration_seq",sequenceName="fieldDuration_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fieldDuration_seq")
    @Column(name="FIELDDURATION_ID")
    private Long fieldDurationId;
    private String fieldDuration;
}