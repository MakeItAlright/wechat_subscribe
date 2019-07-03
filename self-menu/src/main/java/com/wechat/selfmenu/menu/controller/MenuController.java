package com.wechat.selfmenu.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wechat_subscribe/menu")
public class MenuController {

	@GetMapping
	public ModelAndView index() {
		System.out.println("显示首页");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/self/menu/index.jsp");
		return mav;
	}
}
