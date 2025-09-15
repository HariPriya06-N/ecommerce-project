package com.excelr.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.model.Headphones;
import com.excelr.model.Laptops;
import com.excelr.model.Login;
import com.excelr.model.Mobiles;
import com.excelr.service.ExcelRService;
import com.excelr.model.WhatsAppRequest;

@RestController
@CrossOrigin("*")
public class ExcelRController {
	@Autowired
	private ExcelRService excelrService;
	@GetMapping("/laptops")
	public List<Laptops> getLaptops(){
		return excelrService.getAllLaptops();
	}
	
	@GetMapping("/mobiles")
	public List<Mobiles> getMobiles(){
		return excelrService.getAllMobiles();
	}
	@GetMapping("/headphones")
	public List<Headphones> getHeadphones(){
		return excelrService.getAllHeadphones();
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Login login) {
	    Login loginResponse = excelrService.performLogin(login.getUsername());

	    if (loginResponse != null && loginResponse.getPassword().equals(login.getPassword())) {
	        return "Login success";
	    } else {
	        return "Login failed";
	    }
	}

	@PostMapping("/send-whatsapp")
	public String sendWhatsApp(@RequestBody WhatsAppRequest request) {
	    return excelrService.sendWhatsAppMessage(request.getMessage());
	}

	}