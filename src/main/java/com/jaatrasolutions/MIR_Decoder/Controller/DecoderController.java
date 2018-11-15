package com.jaatrasolutions.MIR_Decoder.Controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jaatrasolutions.MIR_Decoder.FileParsing.ReadFromFile;
import com.jaatrasolutions.MIR_Decoder.Service.DecoderService;

@RestController
public class DecoderController {
	
	@Autowired
	private DecoderService decoderService;
	private WatchService watcher;
	@Autowired
	private Environment env;
	public void start() {
		
		String directory = env.getProperty("MIR.InputFile.Location");
		Path myDir = Paths.get(directory);
		String comp_code = env.getProperty("MIR.InputFile.CompCode");
        boolean createdFile = false;
        boolean deletedFile = false;
        while(true){
    		try {
        		watcher = myDir.getFileSystem().newWatchService();
                myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, 
                StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
                
                WatchKey watckKey = watcher.take();
                Thread.sleep(5000);
                List<WatchEvent<?>> events = watckKey.pollEvents();
         	   for (WatchEvent<?> event : events) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE && !createdFile) {
                        System.out.println("Created: " + event.context().toString());
                        createdFile = true;
                        deletedFile = false;
                        
                        ReadFromFile rff = new ReadFromFile();
                        if(rff.start(directory, event.context().toString(), comp_code)){
                     	   System.out.println("Operation OK.");
                     	   //dashboardService.insertIntoTicketGD(rff.getPNR(), rff.getTicket_No(), rff.getPax_Name(), rff.getSector(), rff.getFlight_No(), rff.getFlight_Date(), rff.getFlight_Start_Time(), rff.getFlight_End_Time(), rff.getFlight_Duration(), rff.getFlight_Status(), rff.getAirline_Code(), rff.getAirline_PNR(), rff.getData_Load_Time(), rff.getComp_Code(), rff.getCreate_Date(), rff.getVC_Class());
                     	  decoderService.insetIntoTicket_GD(rff.ticketGd);
                     	  decoderService.insertIntoFare_GD(rff.fareGd);
//                     	  decoderService.insertIntoTax_GD(rff.taxGd);
                     	  File file = new File(directory+"/"+event.context().toString());
                     	  file.renameTo(new File(directory+"/success/"+event.context().toString()));
                     	  deletedFile = true;
                     	  createdFile = false;
                     	  
                        }
                        else{
                     	  System.out.println("Something went wrong...");
//                     	  decoderService.insetIntoTickey_GD(rff.ticketGd);
//                     	  decoderService.insertIntoFare_GD(rff.fareGd);
//                     	  decoderService.insertIntoTax_GD(rff.taxGd);
                     	  File file = new File(directory+"/"+event.context().toString());
                    	  file.renameTo(new File(directory+"/error/"+event.context().toString()));
                    	  deletedFile = true;
                          createdFile = false;
                        }
                        //rff.enterToDB();
                    }
                    else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE && !deletedFile) {
                        System.out.println("Deleted: " + event.context().toString());
                        deletedFile = true;
                        createdFile = false;
                    }
                }
         	   //watcher.close();
         	  //return "Working Perfectly";
            }	                       
    		catch (Exception e) {
             System.out.println("Error: " + e.toString());
             //return null;
    		}         		
        }
 	}
}
