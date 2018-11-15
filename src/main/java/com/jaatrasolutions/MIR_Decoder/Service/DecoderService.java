package com.jaatrasolutions.MIR_Decoder.Service;

import com.jaatrasolutions.MIR_Decoder.Entities.FareGd;
import com.jaatrasolutions.MIR_Decoder.Entities.TaxGd;
import com.jaatrasolutions.MIR_Decoder.Entities.TicketGd;

public interface DecoderService {
	public void insetIntoTicket_GD(TicketGd ticketGd) throws Exception ;

	public void insertIntoFare_GD(FareGd fareGd) throws Exception;

	public void insertIntoTax_GD(TaxGd taxGd)throws Exception;
}
