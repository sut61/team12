package sut.se.team12.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Column(name = "FIELDORDER_ID",unique=true)
    @NotNull 
    private Long fieldOrderId;
    

    @NotNull 
    @Size(min=2,max=20) 
    @Pattern(regexp = "[A-Za-z0-9]+") 
    private String note;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date Date;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Field.class)
    @JoinColumn(name = "FIELD_ID", insertable = true)
    private Field field;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", insertable = true)
    private Member member;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = FieldDuration.class)
    @JoinColumn(name = "FIELDDURATION_ID", insertable = true)
    private FieldDuration fieldDuration;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "ADMIN_ID", insertable = true)
    private Admin admin;
}