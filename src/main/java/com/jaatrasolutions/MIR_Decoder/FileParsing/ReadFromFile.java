package com.jaatrasolutions.MIR_Decoder.FileParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//import com.jaatrasolutions.MIR_Decoder.Service.DecoderService;
import com.jaatrasolutions.MIR_Decoder.Entities.*;


//@RestController
public class ReadFromFile {

    public TicketGd ticketGd;
    public FareGd fareGd;
    
//    @Autowired
//	private DecoderService decoderService;

    public boolean start(String directory, String fName, String vcCompCode) throws FileNotFoundException{
		
    	ticketGd = new TicketGd();
    	fareGd = new FareGd();
//    	taxGd = new TaxGd();
    	
		String fileName = fName;
		String path = directory+"/"+fileName;
		
		File mir = new File(path);
        Scanner mirSC = new Scanner(mir);
        
        int EmptyLineCount = 0;
        boolean status = false;
        String airlineCodeDigits = "";
        String vcAirlineCode = "";
        
        try {
        	while(mirSC.hasNextLine()){


        		if(EmptyLineCount==0) {
            		String firstLine = mirSC.nextLine();
            		//Company Code
            		ticketGd.setVcCompCode(vcCompCode);
            		fareGd.setVcCompCode(vcCompCode);
            		//airline code
            		vcAirlineCode = firstLine.substring(24, 26);
            		System.out.println("Airline code: "+vcAirlineCode);
            		ticketGd.setVcAirlineCode(vcAirlineCode);
            		//airline code in digits
            		airlineCodeDigits = firstLine.substring(27, 30);
            		
            		String secondLine = mirSC.nextLine();
            		secondLine = secondLine.trim().replaceAll(" +", " ");
            		
            		String thirdLine = mirSC.nextLine();
            		thirdLine = thirdLine.trim().replaceAll(" +", " ");
            		//PNR
            		String vcPnrno = thirdLine.substring(13, 19);
            		ticketGd.setVcPnrno(vcPnrno);
            		fareGd.setVcPnrno(vcPnrno);
            		System.out.println("PNR number: "+vcPnrno);
        			EmptyLineCount++;
        		}
        		
        		String currentLine = "";
            	if(mirSC.nextLine().equals("") && EmptyLineCount == 1){
            		boolean paxDone = false;
            		while(!(currentLine = mirSC.nextLine()).equals("")) {
            			if(!paxDone) {
	            			String firstLine = currentLine;
	                    	//Pax Name
	                    	String vcPaxName = firstLine.substring(0,33).replaceAll(" ","");
	                    	System.out.println("Pax Name: "+vcPaxName);
	                    	ticketGd.setVcPaxName(vcPaxName);
	                    	//Ticket No
	                    	String ticketNo = firstLine.substring(48,58);
	                    	String vcTicketNo = airlineCodeDigits+ticketNo;
	                    	System.out.println("Ticket No: "+vcTicketNo);
	                    	ticketGd.setVcTicketno(vcTicketNo);
	                    	fareGd.setVcTicketNo(vcTicketNo);
	                    	
	                    	
	//                    	fareGd.setVcPaxType(vcPaxType);
	                    	String secondLine = mirSC.nextLine();
	                    	secondLine = secondLine.trim().replaceAll(" +", " ");
	                		
	                		String thirdLine = mirSC.nextLine();
	                		//Currency Type Usd
	                		String vcCurrTypeUsd = thirdLine.substring(0,3);
	                		System.out.println("Currency Type Usd: "+vcCurrTypeUsd);
	                		fareGd.setVcCurrTypeUsd(vcCurrTypeUsd);
	                		//USD Fare Amount
	                		String usdAmount = thirdLine.substring(3, 15).replaceAll(" ", "");
	                		System.out.println("Usd Fare Amount: "+usdAmount);
	                		if(usdAmount.equals("")) {
	                			usdAmount = "0";
	                    	}
	                		BigDecimal nuUsdFareAmount = new BigDecimal(usdAmount);
	                		fareGd.setNuUsdFareAmount(nuUsdFareAmount);
	                		List<TaxGd> taxGdList = new ArrayList<>();
	                		for(int i=15;i<thirdLine.length();){
	                			TaxGd taxGd = new TaxGd();
	                			taxGd.setVcTicketNo(vcTicketNo);
	                			taxGd.setVcCompCode(vcCompCode);
	                			String tax = thirdLine.substring(i, i+17);
	                			//Tax Amount
	                			String taxAmount = tax.substring(3,15).replaceAll(" ", "");
	                			boolean amountOK = false;
	                    		if(!taxAmount.equals("")) {
	                    			System.out.println("Tax Amount: "+taxAmount);
	                        		BigDecimal nuTaxAmount = new BigDecimal(taxAmount);
	                        		taxGd.setNuTaxAmount(nuTaxAmount);
	                        		amountOK = true;
	                    		}
	                    		//Tax Type
	                    		String vcTaxType = tax.substring(15,17);
	                    		boolean typeOK = false;
	                    		if(!vcTaxType.equals("  ")) {
	                    			System.out.println("Tax Type: "+vcTaxType);
	                        		taxGd.setVcTaxType(vcTaxType);
	                        		typeOK = true;
	                    		}
	                    		if(amountOK && typeOK) {
	                    			taxGdList.add(taxGd);
	                    		}	                    		
	                			i = i+17;
	                		}               		
	                			                		
	                    	String fourthLine = mirSC.nextLine();
	                    	for(int i=0;i<51;){
	                			TaxGd taxGd = new TaxGd();
	                			taxGd.setVcTicketNo(vcTicketNo);
	                			taxGd.setVcCompCode(vcCompCode);
	                			String tax = fourthLine.substring(i, i+17);
	                			//Tax Amount
	                			String taxAmount = tax.substring(3,15).replaceAll(" ", "");
	                			boolean amountOK = false;
	                    		if(!taxAmount.equals("")) {
	                    			System.out.println("Tax Amount: "+taxAmount);
	                        		BigDecimal nuTaxAmount = new BigDecimal(taxAmount);
	                        		taxGd.setNuTaxAmount(nuTaxAmount);
	                        		amountOK = true;
	                    		}
	                    		//Tax Type
	                    		String vcTaxType = tax.substring(15,17);
	                    		boolean typeOK = false;
	                    		if(!vcTaxType.equals("  ")) {
	                    			System.out.println("Tax Type: "+vcTaxType);
	                        		taxGd.setVcTaxType(vcTaxType);
	                        		typeOK = true;
	                    		}
	                    		if(amountOK && typeOK) {
	                    			taxGdList.add(taxGd);
	                    		}	                    		
	                			i = i+17;
	                		}
	                    	ticketGd.setTaxGdList(taxGdList);
	                    	String baseFare = fourthLine.substring(81);
	                    	//Currency Type Base
	                    	String vcCurrTypeBase = baseFare.substring(0,3);
	                    	System.out.println("Currency Type Base: "+vcCurrTypeBase);
	                    	fareGd.setVcCurrTypeBase(vcCurrTypeBase);
	                    	//Base Fare Amount
	                    	String baseFareAmount = baseFare.substring(3).replaceAll(" ", "");
	                    	if(baseFareAmount.equals("") && vcCurrTypeUsd.equals("BDT")) {
	                    		baseFareAmount = ""+nuUsdFareAmount;
	                    	}
	                    	BigDecimal nuBaseFareAmount = new BigDecimal(baseFareAmount);
	                    	System.out.println("Base Fare Amount: "+nuBaseFareAmount);
	                    	fareGd.setNuBaseFareAmount(nuBaseFareAmount);
	                    	//Total Amount
	                    	String totalAmount = fourthLine.substring(54,81).replaceAll(" ","");
	                    	if(totalAmount.equals("")) {
	                    		totalAmount = "0";
	                    	}
	                    	BigDecimal nuTotalAmnt = new BigDecimal(totalAmount);
	                    	System.out.println("Total Amount: "+nuTotalAmnt);
	                    	fareGd.setNuTotalAmnt(nuTotalAmnt);
	                    	//Total Tax Amount
	                    	BigDecimal nuTotalTaxAmount = nuTotalAmnt.subtract(nuBaseFareAmount);
	                    	System.out.println("Total Tax Amount: "+nuTotalTaxAmount);
	                    	fareGd.setNuTotalTaxAmount(nuTotalTaxAmount);
	                    	
	            		}
            			paxDone = true;
            		}
                	EmptyLineCount++;
            	}
            	if(currentLine.equals("") && EmptyLineCount == 2){
            		System.out.print("Current Line 2: ");
            		while(!(currentLine = mirSC.nextLine()).equals("")) {
            			String firstLine = currentLine;
            			//Flight No
            			String vcFlightNo = vcAirlineCode+firstLine.substring(59, 62);
            			System.out.println("Flight No: "+vcFlightNo);
						ticketGd.setVcFlightNo(vcFlightNo );
            			//Class
            			String vcClass = firstLine.substring(62, 63);
            			System.out.println("Class: "+vcClass);
            			ticketGd.setVcClass(vcClass);
            			//Flight Date
            			String sDate = firstLine.substring(66, 73);
            			Date dtFlightDate = new SimpleDateFormat("ddMMMyy").parse(sDate);
            			System.out.println("Flight Date: "+dtFlightDate);
            			ticketGd.setDtFlightDate(dtFlightDate);
                    	
                    	String secondLine = mirSC.nextLine();
                		//Sector
                		String vcSector = secondLine.substring(0, 3)+"/"+secondLine.substring(22, 25);
                		System.out.println("Sector: "+vcSector);
                		ticketGd.setVcSector(vcSector);
            		}
            		EmptyLineCount++;
//            		currentLine = mirSC.nextLine();
            	}
            	
				if (currentLine.equals("") && EmptyLineCount == 3) {
					System.out.print("Current Line 3: ");
            		while(!(currentLine = mirSC.nextLine()).equals("")) {
            			System.out.println(currentLine);
            		}
            		EmptyLineCount++;
				}
				
				if (currentLine.equals("") && EmptyLineCount == 4) {
					System.out.print("Current Line 4: ");
            		while(!(currentLine = mirSC.nextLine()).equals("")) {
            			System.out.println(currentLine);
            		}
            		EmptyLineCount++;
				}
				
				if (currentLine.equals("") && EmptyLineCount == 5) {
					System.out.print("Current Line 5: ");
            		while(!(currentLine = mirSC.nextLine()).equals("")) {
            			System.out.println(currentLine);
            		}
            		EmptyLineCount++;
				}
				
				if (currentLine.equals("") && EmptyLineCount == 6) {
					System.out.print("Current Line 6: ");
            		while(!(currentLine = mirSC.nextLine()).equals("")) {
            			System.out.println(currentLine);
            		}
            		EmptyLineCount++;
				}				
            }
        	System.out.println(EmptyLineCount);
        	mirSC.close();       	
        	status = true;
        	return status;
        	
		} 
        catch (Exception e) {
        	mirSC.close();
        	System.out.println("Error Found: "+e);
        	status = false;
        	return status;
		}        
        //System.out.print(count);        
	}	
}
