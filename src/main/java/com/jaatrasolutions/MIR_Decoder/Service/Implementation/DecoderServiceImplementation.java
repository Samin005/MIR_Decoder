package com.jaatrasolutions.MIR_Decoder.Service.Implementation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaatrasolutions.MIR_Decoder.Entities.*;
import com.jaatrasolutions.MIR_Decoder.Repository.*;
import com.jaatrasolutions.MIR_Decoder.Service.DecoderService;

@Service
public class DecoderServiceImplementation implements DecoderService{

	@Autowired
	private TicketGdRepository ticketGdRepository;
	
	@Autowired
	private FareGdRepository fareGdRepository;
	
	@Autowired
	private TaxGdRepository taxGdRepository;

	@Override
	public void insetIntoTicket_GD(TicketGd ticketGd) throws Exception {
		java.util.Date current_date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy HH.mm.ss.SSSSSSSSS a");
		String current_date_day = sdf.format(current_date);
	    Date parsedDate = sdf.parse(current_date_day);
	    Timestamp current_timestamp = new java.sql.Timestamp(parsedDate.getTime());
		

	    ticketGd.setVcFlightStartTime("");
	    ticketGd.setVcFlightEndTime("");
	    ticketGd.setVcFlightDuration("");
	    ticketGd.setVcFlightStatus("");
	    ticketGd.setVcAirlinePnr("");
	    ticketGd.setDtDataLoadTime(current_timestamp);
	    ticketGd.setCreateddate(current_timestamp);
		
        ticketGdRepository.save(ticketGd);
//        taxGdRepository.saveAll(ticketGd.getTaxGdList());
        for(int i=0; i<ticketGd.taxGdList.size();i++) {
        	insertIntoTax_GD(ticketGd.taxGdList.get(i));
        }
	}

	@Override
	public void insertIntoFare_GD(FareGd fareGd) throws Exception {
//		fareGd.setVcTicketNo("YOLO");
//		fareGd.setVcCurrTypeUsd("NUL");
//		fareGd.setNuUsdFareAmount(new BigDecimal("123456"));
//		fareGd.setVcCurrTypeBase("NUL");
//		fareGd.setNuBaseFareAmount(new BigDecimal("123456"));
//		fareGd.setNuTotalAmnt(new BigDecimal("123456"));
//		fareGd.setNuTotalTaxAmount(new BigDecimal("123456"));
		
		java.util.Date current_date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy HH.mm.ss.SSSSSSSSS a");
		String current_date_day = sdf.format(current_date);
	    Date parsedDate = sdf.parse(current_date_day);
	    Timestamp current_timestamp = new java.sql.Timestamp(parsedDate.getTime());
		
	    fareGd.setDtDataLoadTime(current_timestamp);
//        fareGd.setVcCompCode("Company_Code");
        fareGd.setCreateddate(current_timestamp);
		
        fareGdRepository.save(fareGd);
	}

	@Override
	public void insertIntoTax_GD(TaxGd taxGd) throws Exception {
//		taxGd.setVcTicketNo("YOLO");
//		taxGd.setVcTaxType("Null");
//		taxGd.setNuTaxAmount(new BigDecimal("123456"));
		
		java.util.Date current_date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy HH.mm.ss.SSSSSSSSS a");
		String current_date_day = sdf.format(current_date);
	    Date parsedDate = sdf.parse(current_date_day);
	    Timestamp current_timestamp = new java.sql.Timestamp(parsedDate.getTime());
		
	    taxGd.setDtDataLoadTime(current_timestamp);
//        taxGd.setVcCompCode("Company_Code");        
        
//        if(!taxGdRepository.exists(taxGd.getVcTicketNo())) {
        	taxGdRepository.save(taxGd);
//        }
//        else {
//			System.out.println("Looks like this data already exists");
//			taxGdRepository.delete(taxGd.getVcTicketNo());
//			taxGdRepository.save(taxGd);
//		}
	}

}
