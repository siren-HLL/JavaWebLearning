package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ControllerTest implements Controller{
	//handleRequest()是controller接口的实现方法，controllertest类会调用该方法处理请求，返回一个包含视图名或包含视图名与模型modelandview对象
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		//创建ModelAndView对象
		ModelAndView m = new ModelAndView();
		//向模型对象添加一个名称为msg的字符串对象
		m.addObject("msg","第一个springmvc程序");
		//设置返回的视图路径
		m.setViewName("first");
		return m;
	}

}
