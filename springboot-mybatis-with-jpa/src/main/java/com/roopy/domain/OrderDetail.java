package com.roopy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

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
@Table(name = "order_detail")
@IdClass(OrderDetailIdentity.class)
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -178105276989733750L;
	
	@Id
	@Column(name = "order_id", nullable = false, length = 15)
    public String orderId;

	@Id
	@Column(name = "order_seq", nullable = false)
	public int orderSeq;
	
	/*상품코드*/
	@Column(name = "prod_cd", nullable = false, length = 10)
	public String prodCd;
	
	/*수량*/
	@Column(name = "qty", nullable = false)
	public int qty;
	
	/*주문금액*/
	@Column(name = "order_amt", nullable = false)
	public int orderAmt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
		@JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
	})
	public Orderm orderm;
	
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, new MultilineRecursiveToStringStyle()).toString();
	}
}
