package com.jaatrasolutions.MIR_Decoder.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the FARE_GD database table.
 * 
 */
@Entity
@Table(name="FARE_GD")
//@NamedQuery(name="FareGd.findAll", query="SELECT f FROM FareGd f")
public class FareGd implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp createddate;

	@Column(name="DT_DATA_LOAD_TIME")
	private Timestamp dtDataLoadTime;

	@Column(name="NU_BASE_FARE_AMOUNT")
	private BigDecimal nuBaseFareAmount;

	@Column(name="NU_TOTAL_AMNT")
	private BigDecimal nuTotalAmnt;

	@Column(name="NU_TOTAL_TAX_AMOUNT")
	private BigDecimal nuTotalTaxAmount;

	@Column(name="NU_USD_FARE_AMOUNT")
	private BigDecimal nuUsdFareAmount;

	@Column(name="VC_COMP_CODE")
	private String vcCompCode;

	@Column(name="VC_CURR_TYPE_BASE")
	private String vcCurrTypeBase;

	@Column(name="VC_CURR_TYPE_USD")
	private String vcCurrTypeUsd;

	@Column(name="VC_PAX_TYPE")
	private String vcPaxType;

	@Column(name="VC_PNRNO")
	private String vcPnrno;

	@Id @Column(name="VC_TICKET_NO")
	private String vcTicketNo;

	public FareGd() {
	}

	public Timestamp getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public Timestamp getDtDataLoadTime() {
		return this.dtDataLoadTime;
	}

	public void setDtDataLoadTime(Timestamp dtDataLoadTime) {
		this.dtDataLoadTime = dtDataLoadTime;
	}

	public BigDecimal getNuBaseFareAmount() {
		return this.nuBaseFareAmount;
	}

	public void setNuBaseFareAmount(BigDecimal nuBaseFareAmount) {
		this.nuBaseFareAmount = nuBaseFareAmount;
	}

	public BigDecimal getNuTotalAmnt() {
		return this.nuTotalAmnt;
	}

	public void setNuTotalAmnt(BigDecimal nuTotalAmnt) {
		this.nuTotalAmnt = nuTotalAmnt;
	}

	public BigDecimal getNuTotalTaxAmount() {
		return this.nuTotalTaxAmount;
	}

	public void setNuTotalTaxAmount(BigDecimal nuTotalTaxAmount) {
		this.nuTotalTaxAmount = nuTotalTaxAmount;
	}

	public BigDecimal getNuUsdFareAmount() {
		return this.nuUsdFareAmount;
	}

	public void setNuUsdFareAmount(BigDecimal nuUsdFareAmount) {
		this.nuUsdFareAmount = nuUsdFareAmount;
	}

	public String getVcCompCode() {
		return this.vcCompCode;
	}

	public void setVcCompCode(String vcCompCode) {
		this.vcCompCode = vcCompCode;
	}

	public String getVcCurrTypeBase() {
		return this.vcCurrTypeBase;
	}

	public void setVcCurrTypeBase(String vcCurrTypeBase) {
		this.vcCurrTypeBase = vcCurrTypeBase;
	}

	public String getVcCurrTypeUsd() {
		return this.vcCurrTypeUsd;
	}

	public void setVcCurrTypeUsd(String vcCurrTypeUsd) {
		this.vcCurrTypeUsd = vcCurrTypeUsd;
	}

	public String getVcPaxType() {
		return this.vcPaxType;
	}

	public void setVcPaxType(String vcPaxType) {
		this.vcPaxType = vcPaxType;
	}

	public String getVcPnrno() {
		return this.vcPnrno;
	}

	public void setVcPnrno(String vcPnrno) {
		this.vcPnrno = vcPnrno;
	}

	public String getVcTicketNo() {
		return this.vcTicketNo;
	}

	public void setVcTicketNo(String vcTicketNo) {
		this.vcTicketNo = vcTicketNo;
	}

}