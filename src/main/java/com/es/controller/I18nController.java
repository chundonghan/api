package com.es.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/i18n")
public class I18nController {

	@Autowired
	private MessageSource messageSource;
	@GetMapping("/msg")
	public Map<String,String> msg(){
		Map<String,String> msg = new HashMap<>();
		Locale locale = LocaleContextHolder.getLocale();
		String message = messageSource.getMessage("msg", null, locale);
		msg.put("msg", message);
		return msg;
	}
	
	@GetMapping("/page")
	public String page(HttpServletRequest request){
		return "i18n/page";
	}
}
