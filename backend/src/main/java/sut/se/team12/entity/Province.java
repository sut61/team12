package sut.se.team12.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_province")

public class Province {
    @Id
    @SequenceGenerator(name="porvince_seq",sequenceName="province_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="province_seq")
    @Column(name="PROVINCE_ID")
    private Long provinceId;
    private String provinceName;
}