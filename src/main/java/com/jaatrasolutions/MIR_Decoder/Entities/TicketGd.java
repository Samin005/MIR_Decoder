package com.jaatrasolutions.MIR_Decoder.Entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;


/**
 * The persistent class for the TICKET_GD database table.
 * 
 */
@Entity
@Table(name="TICKET_GD")

public class TicketGd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="CREATEDDATE")
	private Timestamp createddate;

	@Column(name="DT_DATA_LOAD_TIME")
	private Timestamp dtDataLoadTime;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_FLIGHT_DATE")
	private Date dtFlightDate;

	@Column(name="VC_AIRLINE_CODE")
	private String vcAirlineCode;

	@Column(name="VC_AIRLINE_PNR")
	private String vcAirlinePnr;

	@Column(name="VC_CLASS")
	private String vcClass;

	@Column(name="VC_COMP_CODE")
	private String vcCompCode;

	@Column(name="VC_FLIGHT_DURATION")
	private String vcFlightDuration;

	@Column(name="VC_FLIGHT_END_TIME")
	private String vcFlightEndTime;

	@Column(name="VC_FLIGHT_NO")
	private String vcFlightNo;

	@Column(name="VC_FLIGHT_START_TIME")
	private String vcFlightStartTime;

	@Column(name="VC_FLIGHT_STATUS")
	private String vcFlightStatus;

	@Column(name="VC_PAX_NAME")
	private String vcPaxName;

	@Column(name="VC_PNRNO")
	private String vcPnrno;

	@Column(name="VC_SECTOR")
	private String vcSector;

	@Column(name="VC_SSRREQTEXT")
	private String vcSsrreqtext;

	@Id @Column(name="VC_TICKETNO")
	private String vcTicketno;
	
//	@OneToMany
//	@JoinColumn(name="VC_TICKETNO", referencedColumnName="VC_TICKET_NO")
	@Transient
	public List<TaxGd> taxGdList;

	public TicketGd() {
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

	public Date getDtFlightDate() {
		return this.dtFlightDate;
	}

	public void setDtFlightDate(Date dtFlightDate) {
		this.dtFlightDate = dtFlightDate;
	}

	public String getVcAirlineCode() {
		return this.vcAirlineCode;
	}

	public void setVcAirlineCode(String vcAirlineCode) {
		this.vcAirlineCode = vcAirlineCode;
	}

	public String getVcAirlinePnr() {
		return this.vcAirlinePnr;
	}

	public void setVcAirlinePnr(String vcAirlinePnr) {
		this.vcAirlinePnr = vcAirlinePnr;
	}

	public String getVcClass() {
		return this.vcClass;
	}

	public void setVcClass(String vcClass) {
		this.vcClass = vcClass;
	}

	public String getVcCompCode() {
		return this.vcCompCode;
	}

	public void setVcCompCode(String vcCompCode) {
		this.vcCompCode = vcCompCode;
	}

	public String getVcFlightDuration() {
		return this.vcFlightDuration;
	}

	public void setVcFlightDuration(String vcFlightDuration) {
		this.vcFlightDuration = vcFlightDuration;
	}

	public String getVcFlightEndTime() {
		return this.vcFlightEndTime;
	}

	public void setVcFlightEndTime(String vcFlightEndTime) {
		this.vcFlightEndTime = vcFlightEndTime;
	}

	public String getVcFlightNo() {
		return this.vcFlightNo;
	}

	public void setVcFlightNo(String vcFlightNo) {
		this.vcFlightNo = vcFlightNo;
	}

	public String getVcFlightStartTime() {
		return this.vcFlightStartTime;
	}

	public void setVcFlightStartTime(String vcFlightStartTime) {
		this.vcFlightStartTime = vcFlightStartTime;
	}

	public String getVcFlightStatus() {
		return this.vcFlightStatus;
	}

	public void setVcFlightStatus(String vcFlightStatus) {
		this.vcFlightStatus = vcFlightStatus;
	}

	public String getVcPaxName() {
		return this.vcPaxName;
	}

	public void setVcPaxName(String vcPaxName) {
		this.vcPaxName = vcPaxName;
	}

	public String getVcPnrno() {
		return this.vcPnrno;
	}

	public void setVcPnrno(String vcPnrno) {
		this.vcPnrno = vcPnrno;
	}

	public String getVcSector() {
		return this.vcSector;
	}

	public void setVcSector(String vcSector) {
		this.vcSector = vcSector;
	}

	public String getVcSsrreqtext() {
		return this.vcSsrreqtext;
	}

	public void setVcSsrreqtext(String vcSsrreqtext) {
		this.vcSsrreqtext = vcSsrreqtext;
	}

	public String getVcTicketno() {
		return this.vcTicketno;
	}

	public void setVcTicketno(String vcTicketno) {
		this.vcTicketno = vcTicketno;
	}

	public List<TaxGd> getTaxGdList() {
		return taxGdList;
	}

	public void setTaxGdList(List<TaxGd> taxGdList) {
		this.taxGdList = taxGdList;
	}

}