package com.roopy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderDetailIdentity implements Serializable {
	
	private static final long serialVersionUID = 2339510329475348248L;

	@Column(name = "order_id", nullable = false, length = 15)
    public String orderId;

	@Column(name = "order_seq", nullable = false)
	public int orderSeq;
	
    
	public OrderDetailIdentity() {
	}

	public OrderDetailIdentity(String orderId, int orderSeq) {
		super();
		this.orderId = orderId;
		this.orderSeq = orderSeq;
	}
	
}
