package com.example.wickramagalleSportsAcademy.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "class_details")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class ClassEntity {

    @Id
    @Column(name = "class_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int classId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "class_category")
    private String classCategory;

    @Column(name = "class_Fee_Per_Month")
    private double classFeePerMonth;

    @Column(name = "active_state")
    private boolean activeState;

    @OneToMany(mappedBy="classes")
    private Set<PaymentDetailsEntity> paymentDetails;
}
