package com.biz.big.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biz.big.model.DeptVO;
import com.biz.big.service.DeptService;

@RequestMapping(value="/dept")
@Controller
public class DeptController {

	
	@Qualifier("deptServiceV1")
	@Autowired
	private DeptService dService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<DeptVO> deptList = dService.selectAll();
		
		model.addAttribute("DEPT_LIST",deptList);
		model.addAttribute("BODY","DEPT_LIST");
		return "home";
	
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public ModelAndView insert(@ModelAttribute("DEPT_VO") DeptVO deptVO) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("BODY","DEPT_WRITE"); 
		model.setViewName("home"); // 여기에 실제로 쓰는 view 이름
		return model;
		
	}
	

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("DEPT_VO") DeptVO deptVO, Model model) {
		
		int ret = dService.insert(deptVO);
		return "redirect:/dept/";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/get_dcode",method=RequestMethod.GET)
	public String getDCode() {
		
		
		String d_code = dService.getDCode();
		
		return d_code;
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("id")String d_code, Model model) {
		
		
		DeptVO deptVO = dService.findById(d_code);
		
		model.addAttribute("DEPT_VO",deptVO);
		model.addAttribute("BODY","DEPT_DETAIL");
		return "home";
	}

	
	
	
	
	
	
}
