package com.excelr.service;
import java.util.List;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.model.Headphones;
import com.excelr.model.Laptops;
import com.excelr.model.Login;
import com.excelr.model.Mobiles;
import com.excelr.repo.HeadPhonesRepo;
import com.excelr.repo.LaptopsRepo;
import com.excelr.repo.LoginRepo;
import com.excelr.repo.MobilesRepo;
@Service

public class ExcelRService {

	    @Autowired
	    private LaptopsRepo laptopsRepo;

	    @Autowired 
	    private MobilesRepo mobilesRepo;

	    @Autowired 
	    private HeadPhonesRepo headphonesRepo; 
	    @Autowired
	    private LoginRepo loginRepo;
	    
	    public List<Laptops> getAllLaptops() {
	        return laptopsRepo.findAll();
	    }

	    public List<Mobiles> getAllMobiles() {
	        return mobilesRepo.findAll();
	    }

	    public List<Headphones> getAllHeadphones() {
	        return headphonesRepo.findAll();
	    }

	    public Login performLogin(String username) {
	        return loginRepo.findByUsername(username);
	    }
	    @Value("${twilio.from.whatsapp}")
	    private String fromNumber;

	    @Value("${twilio.certified.number}")
	    private String certifiedToNumber;  // ✅ only one fixed number

	    public String sendWhatsAppMessage(String text) {
	        try {
	            Message message = Message.creator(
	                new PhoneNumber("whatsapp:" + certifiedToNumber),
	                new PhoneNumber(fromNumber),
	                text
	            ).create();

	            return "Message sent! SID: " + message.getSid();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Failed: " + e.getMessage();
	        }
	    }

	    
//	    @Value("${twilio.from.whatsapp}")
//	    private String fromNumber;
	//
//	    public String sendWhatsAppMessage(String toNumber, String text) {
//	        Message message = Message.creator(
//	            new PhoneNumber("whatsapp:" + toNumber),
//	            new PhoneNumber(fromNumber),
//	            text
//	        ).create();
	//
//	        return message.getSid();
//	    }

	}



