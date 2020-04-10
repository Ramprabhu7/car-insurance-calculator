package com.car.Insurance.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.Insurance.Service.InsuranceService;
import com.car.Insurance.model.Insurance;

@Controller
public class InsuranceController {
	InsuranceService service;
	@Autowired
	public InsuranceController(InsuranceService service) {
		super();
		this.service = service;
	}

	@GetMapping("/")
	public String showhome(Model model) {
		Insurance insurance=new Insurance();
		model.addAttribute(insurance);
		return "detail";
	}
	
	@GetMapping("/process")
	public String processForm(@RequestParam("modelName") String modelName,@RequestParam("fuelType") String fuelType,
			 @RequestParam("year") String year,Model model) throws ParseException {
		
		//Admin a=service.gettotal(modelName,fuelType,year);
		int no_month=service.getmonth(year);
		int no_year=service.getyear(year);
		long premium1=service.getPremium1(modelName,fuelType,no_month,no_year);
		model.addAttribute("premium1", premium1);
		long IDV1=service.getIDV1(modelName,fuelType,no_month,no_year);
		System.out.println(IDV1+"hghg");
		model.addAttribute("IDV1", IDV1);
		long premium2=service.getPremium2(modelName,fuelType,no_month,no_year);
		model.addAttribute("premium2", premium2);
		long IDV2=service.getIDV2(modelName,fuelType,no_month,no_year);
		model.addAttribute("IDV2", IDV2);
		long premium3=service.getPremium3(modelName,fuelType,no_month,no_year);
		model.addAttribute("premium3", premium3);
		long IDV3=service.getIDV3(modelName,fuelType,no_month,no_year);
		model.addAttribute("IDV3", IDV3);
		return "display";
		}
		
}
