package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	@Column(length = 30)
	private String paymentDesc;
	private double paymentAmount;
	private LocalDate paymentDate;
	
	public Payment() {
		System.out.println("in payment constructor ");
	}

	public Payment(String paymentDesc, double paymentAmount, LocalDate paymentDate) {
		super();
		this.paymentDesc = paymentDesc;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentDesc() {
		return paymentDesc;
	}

	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDesc=" + paymentDesc + ", paymentAmount=" + paymentAmount
				+ ", paymentDate=" + paymentDate + "]";
	}

}
