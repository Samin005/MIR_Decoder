package com.jaatrasolutions.MIR_Decoder.Entities;

import java.io.Serializable;

public class TaxGdPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vcTicketNo;
	private String vcTaxType;

	public String getVcTicketNo() {
		return vcTicketNo;
	}

	public void setVcTicketNo(String vcTicketNo) {
		this.vcTicketNo = vcTicketNo;
	}

	public String getVcTaxType() {
		return vcTaxType;
	}

	public void setVcTaxType(String vcTaxType) {
		this.vcTaxType = vcTaxType;
	}

}