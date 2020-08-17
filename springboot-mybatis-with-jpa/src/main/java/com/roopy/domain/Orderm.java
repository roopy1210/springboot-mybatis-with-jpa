package com.roopy.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Orderm {

	@Id
	@Column(name = "order_id", nullable = false, length = 15)
	public String orderId;
	
	@Column(name = "orderer_id", nullable = false, length = 35)
	public String ordererId;
	
	@Column(name = "order_dtm", nullable = false, length = 14)
	public String orderDtm;
	
	@Column(name = "total_order_amt", nullable = false)
	public Integer orderCmpnyNm;
	
	@Column(name = "order_status", nullable = false, length = 1)
	public String orderStatus;
	
	@OneToMany(mappedBy="orderm",cascade=CascadeType.ALL)
	public List<OrderDetail> orderDetails;
	
}
