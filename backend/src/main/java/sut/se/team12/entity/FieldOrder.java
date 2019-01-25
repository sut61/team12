package sut.se.team12.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_fieldOrder")
public class FieldOrder {
    @Id
    @SequenceGenerator(name="fieldOrder_seq",sequenceName = "fieldOrder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fieldOrder_seq")
    @Column(name = "FIELDORDER_ID")
    private Long fieldOrderId;
    @Temporal(TemporalType.DATE)private Date Date;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Field.class)
    @JoinColumn(name = "FIELD_ID", insertable = true)
    private Field field;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = FieldDuration.class)
    @JoinColumn(name = "FIELDDURATION_ID", insertable = true)
    private FieldDuration fieldDuration;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;
}