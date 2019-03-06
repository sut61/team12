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
@Table(name = "tb_title")
public class Title {
    @Id
    @SequenceGenerator(name="title_seq",sequenceName = "title_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "title_seq")
    @Column(name = "TITLE_ID",unique = true)
    private Long titleId;
    @NotNull
    private String titleType;
}
