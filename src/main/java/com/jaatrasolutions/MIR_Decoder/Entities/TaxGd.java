package com.jaatrasolutions.MIR_Decoder.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the TAX_GD database table.
 * 
 */
@Entity
@Table(name="TAX_GD")
@NamedQuery(name="TaxGd.findAll", query="SELECT t FROM TaxGd t")
@IdClass(TaxGdPK.class)
public class TaxGd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DT_DATA_LOAD_TIME")
	private Timestamp dtDataLoadTime;

	@Column(name="NU_TAX_AMOUNT")
	private BigDecimal nuTaxAmount;

	@Column(name="VC_COMP_CODE")
	private String vcCompCode;

	@Id @Column(name="VC_TAX_TYPE")
	private String vcTaxType;

	@Id @Column(name="VC_TICKET_NO")
	private String vcTicketNo;

	public TaxGd() {
	}

	public Timestamp getDtDataLoadTime() {
		return this.dtDataLoadTime;
	}

	public void setDtDataLoadTime(Timestamp dtDataLoadTime) {
		this.dtDataLoadTime = dtDataLoadTime;
	}

	public BigDecimal getNuTaxAmount() {
		return this.nuTaxAmount;
	}

	public void setNuTaxAmount(BigDecimal nuTaxAmount) {
		this.nuTaxAmount = nuTaxAmount;
	}

	public String getVcCompCode() {
		return this.vcCompCode;
	}

	public void setVcCompCode(String vcCompCode) {
		this.vcCompCode = vcCompCode;
	}

	public String getVcTaxType() {
		return this.vcTaxType;
	}

	public void setVcTaxType(String vcTaxType) {
		this.vcTaxType = vcTaxType;
	}

	public String getVcTicketNo() {
		return this.vcTicketNo;
	}

	public void setVcTicketNo(String vcTicketNo) {
		this.vcTicketNo = vcTicketNo;
	}

}