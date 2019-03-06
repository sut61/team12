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
@Table(name = "tb_field")


public class Field {
    @Id
    @SequenceGenerator(name="field_seq",sequenceName="field_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="field_seq")
    @Column(name="FIELD_ID",unique=true)
    private Long fieldId;
    @NotNull
    private String fieldName;
}
