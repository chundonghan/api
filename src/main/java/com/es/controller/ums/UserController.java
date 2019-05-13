package com.es.controller.ums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.es.service.ums.UserService;


@RestController
@CrossOrigin //解决ajax跨域问题
public class UserController extends BaseController{

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public ModelAndView index() {
	    ModelAndView mv = new ModelAndView("ums/index");
	    return mv;
	}
	
}
