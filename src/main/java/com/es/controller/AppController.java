package com.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.es.service.AppService;

@RestController
public class AppController {
	
	@Autowired
	private AppService appService;

	@RequestMapping(value = "/app", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> getAllAccounts() {
		return appService.getAllAccounts();
	}
}
