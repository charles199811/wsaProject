package com.example.wickramagalleSportsAcademy.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "payment_details")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
//Associate entity//
public class PaymentDetailsEntity {

    @Id
    @Column(name = "payment_Details_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentDetailsId;

    @Column(name = "student_name", length = 100, nullable = false)
    private String studentName;

    @Column(name = "class_name", length = 100, nullable = false)
    private String className;

    @ManyToOne
    @JoinColumn(name="class_Id", nullable=false)
    private ClassEntity classes;

    @ManyToOne
    @JoinColumn(name="payment_Id", nullable=false)
    private PaymentEntity payments;

}
