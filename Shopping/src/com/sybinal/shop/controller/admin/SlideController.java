package com.sybinal.shop.controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sybinal.shop.common.PageInformation;
import com.sybinal.shop.service.catalog.SlideService;
import com.sybinal.shop.utils.UserUtils;

@Controller
public class SlideController {

	@Autowired
	SlideService slideService;
	
	@RequestMapping(value = "/admin/slideList", method = RequestMethod.GET)
	public ModelAndView slideManage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/slide/slideList");
		return model;
	}
	
	@RequestMapping(value = "/admin/addSlide", method = RequestMethod.GET)
	public ModelAndView addSlide() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/slide/slideEdit");
		return model;
	}
	

	
	

}
