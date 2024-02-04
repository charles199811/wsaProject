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
@Table(name = "payments")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class PaymentEntity {

    @Id
    @Column(name = "payment_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;

    @ManyToOne
    @JoinColumn(name="student_Id", nullable=false)
    private StudentEntity student;

    @Column(name = "date", columnDefinition = "DATETIME")
    private Date Date;

    @Column(name = "paid_month")
    private String  paymentMonth;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "nic")
    private  String nic;

    @Column(name = "payment_active_state")
    private boolean activeState;

    @OneToMany(mappedBy="payments")
    private Set<PaymentDetailsEntity> paymentDetails;

    public PaymentEntity(StudentEntity student, java.util.Date date, String paymentMonth, Double amount, String nic) {
        this.student = student;
        Date = date;
        this.paymentMonth = paymentMonth;
        this.amount = amount;
        this.nic = nic;
    }
}
