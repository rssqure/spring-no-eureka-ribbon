package com.rs2.ribbon.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ClientController {

	Logger logger = LogManager.getLogger(ClientController.class.getName());

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/call-ribbon-service")
	public String callService(Model model) {
		logger.trace("In call-ribbon-service.");
		String retValue = this.restTemplate.getForObject("http://providerservice/provider/service", String.class);
		model.addAttribute("service", retValue);
		logger.trace("In call-ribbon-service: retValue: " + retValue);
		return "service-view";
	}
}
