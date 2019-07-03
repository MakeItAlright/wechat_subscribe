package com.wechat.library.controller;

import com.wechat.library.domain.DebitList;
import com.wechat.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/library/debit")
// 只要在@SessionAttributes注解的names属性里面列出的名字，那么最终就会自动存储到Session里面！
@SessionAttributes(names = { "debitList" })
public class DebitController {

	@Autowired
	private LibraryService libraryService;

//	@RequestMapping
//	public String debit(@RequestParam("bookId") String bookId, //
//			// 从Session中获取名为debitList的对象，并且不是必须的
//			@SessionAttribute(name = "debitList", required = false) DebitList list, //
//			Model model) {
//		if (list == null) {
//			list = new DebitList();
//			// 如果debitList在Session里面是空的，那么创建一个并放入Model里面。
//		}
//		model.addAttribute("debitList", list);
//		return "";
//	}

	@RequestMapping
	public ModelAndView debit(@RequestParam("bookId") String bookId, //
	// 从Session中获取名为debitList的对象，并且不是必须的
//			@SessionAttribute(required = false) DebitList list//
			// WebRequest本身是Spring MVC对Servlet API的封装
			WebRequest request) {

		ModelAndView mav = new ModelAndView();
		DebitList list = (DebitList) request.getAttribute("debitList", WebRequest.SCOPE_SESSION);
		if (list == null) {
			list = new DebitList();
			// 如果debitList在Session里面是空的，那么创建一个并放入Model里面。
			request.setAttribute("debitList", list, WebRequest.SCOPE_SESSION);
		}
//		model.addAttribute("debitList", list);
//		mav.addObject("debitList", list);

		libraryService.add(list, bookId);

		// setViewName就跟原来的返回String相同
		mav.setViewName("redirect:/library/debit/list");
		return mav;
	}

	@RequestMapping("list")
	public String list() {
		return "/WEB-INF/views/library/debit/list.jsp";
	}

	@RequestMapping("detail")
	public String detail() {
		return "/WEB-INF/views/library/debit/detail.jsp";
	}

	// 以后基本上非常少使用?方式传递参数，几乎都是用【路径参数】，因为路径参数才符合RESTful规范。
	// {}里面的内容是参数的名称，可以随便写，但是要跟@PathVariable注解中的字符串相同。
	// @PathVariable用于获取{}里面的参数对应的值。
	@RequestMapping("remove/{id}")
	public String remove(@PathVariable("id") String id, @SessionAttribute(name = "debitList") DebitList list) {
		libraryService.remove(list, id);
		return "redirect:/library/debit/list";
	}
	@RequestMapping("refer/{id}")
	public String refer(@PathVariable("id") String id, @SessionAttribute(name = "debitList") DebitList list){
		libraryService.remove(list, id);
		return "redirect:/library/debit/detail";
	}
	@RequestMapping("confirm")
	public ModelAndView confirm(@RequestParam("bookId") String bookId, //
							  // 从Session中获取名为debitList的对象，并且不是必须的
//			@SessionAttribute(required = false) DebitList list//
							  // WebRequest本身是Spring MVC对Servlet API的封装
							  WebRequest request) {

		ModelAndView mav = new ModelAndView();
		DebitList list2 = (DebitList) request.getAttribute("debitList", WebRequest.SCOPE_SESSION);
		if (list2 == null) {
			list2 = new DebitList();
			// 如果debitList在Session里面是空的，那么创建一个并放入Model里面。
			request.setAttribute("debitList", list2, WebRequest.SCOPE_SESSION);
		}
//		model.addAttribute("debitList", list);
//		mav.addObject("debitList", list);

		libraryService.add(list2, bookId);

		// setViewName就跟原来的返回String相同
		mav.setViewName("redirect:/library/debit/detail");
		return mav;
	}
}
