package com.example.wickramagalleSportsAcademy.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student_details")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class StudentEntity {

    @Id
    @Column(name = "student_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_address")
    private String studentAddress;

    @Column(name = "reg_date", columnDefinition = "DATETIME")
    private Date regDate;

    @Type(type = "json")
    @Column(name = "contact_number", columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "nic")
    private  String nic;

    @Column(name = "active_state")
    private boolean activeState;

    @OneToMany(mappedBy="student")
    private Set<PaymentEntity> payments;

}
