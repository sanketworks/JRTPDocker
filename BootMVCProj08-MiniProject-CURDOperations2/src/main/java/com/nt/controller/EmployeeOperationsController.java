package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private  IEmployeeMgmtService  empService;
	
	
	@GetMapping("/")
	public  String showHomePage() {
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/report")
	public   String  showReport(Map<String,Object> map) {
		try {
		System.out.println("EmployeeOperationsController.showReport()");
		//use service
		List<EmployeeVO>  listVO=empService.showAllEmployees();
		//keep the result in model attribute
		map.put("empsList", listVO);
		//return LVN
		return "show_report";
		}
		catch(Exception  e) {
			map.put("resultMsg", "Problem in Report Generation");
			return  "show_report";
		}
	}
		
		
		
	
	
	@GetMapping("/add")  //--->GET
	public  String  showAddEmployeeFormPage(@ModelAttribute("emp") EmployeeVO empVO) {
		System.out.println("EmployeeOperationsController.showAddEmployeeFormPage()");
		//return  LVN
		return "register_employee";
	}
	
	
	/*	@PostMapping("/add")  // ---> POST
		public    String  processAddEmployeeFormPageSumbission(Map<String,Object> map,
				                                                                                                      @ModelAttribute("emp") EmployeeVO empVO) {
			System.out.println("EmployeeOperationsController.processAddEmployeeFormPageSumbission()");
			//use  service
			String resultMsg=empService.registerEmployee(empVO);
			//keep the results in model attributes
			map.put("resultMsg",resultMsg);
			//return LVN
			return "redirect:report";  //--->  R ---> Redirect
			//return "forward:report";
		}*/
	
	@PostMapping("/add")  // ---> POST
	public    String  processAddEmployeeFormPageSumbission(RedirectAttributes attrs,
			                                                                                                      @ModelAttribute("emp") EmployeeVO empVO) {
		try {
		System.out.println("EmployeeOperationsController.processAddEmployeeFormPageSumbission()");
		//use  service
		String resultMsg=empService.registerEmployee(empVO);
		//keep the results in model attributes
	    attrs.addFlashAttribute("resultMsg",resultMsg);
		//return LVN
		return "redirect:report";  //--->  R ---> Redirect
		}
	   catch(Exception e) {
		   attrs.addFlashAttribute("resultMsg","problem in add employee operation" );
		   return "redirect:report";
	   }
			                                                                                                      
		
	}
	
	/*@PostMapping("/add")  // ---> POST
	public    String  processAddEmployeeFormPageSumbission(HttpSession ses,
			                                                                                                      @ModelAttribute("emp") EmployeeVO empVO) {
		System.out.println("EmployeeOperationsController.processAddEmployeeFormPageSumbission()");
		//use  service
		String resultMsg=empService.registerEmployee(empVO);
		//keep the results in model attributes
	    ses.setAttribute("resultMsg", resultMsg);
		//return LVN
		return "redirect:report";  //--->  R ---> Redirect
		//return "forward:report";
	}*/
	
	
	@GetMapping("/edit") //Edit employee form launching page
	public  String   showEditEmployeeFormPage(@ModelAttribute("emp") EmployeeVO empVO,
			                                                                           @RequestParam("no") int no) {
		//use  service
		EmployeeVO  empVO1=empService.showEmployeeById(no);
		//copy  empVO1  object to empVO object
		BeanUtils.copyProperties(empVO1, empVO);
		//return LVN
		return "edit_employee_form";
	}
	
	@PostMapping("/edit")
	public  String  editEmployee(@ModelAttribute("emp") EmployeeVO vo,
			                                               RedirectAttributes attrs) {
		try {
		//use Service method
		String msg=empService.editEmployee(vo);
		//keep result in FlashAttributes
		attrs.addFlashAttribute("resultMsg", msg);
		//redirect  the request
		return "redirect:report";
		}
		catch(Exception e) {
			attrs.addFlashAttribute("resultMsg", "Problem in Edit Employee operation");
			return "redirect:report";
		}
	}
	
	@GetMapping("/delete")
	public  String removeEmployee(@RequestParam("no") int no,
			                                                      RedirectAttributes  attrs) {
		try {
		//use  service
		String msg=empService.removeEmployeeById(no);
		//keep result as flash attribute
		attrs.addFlashAttribute("resultMsg", msg);
		//redirect the request
		return "redirect:report";
		}
		catch(Exception e) {
			attrs.addFlashAttribute("resultMsg", "Problem in delete operation");
			return "redirect:report"; 
		}
		
	}

	

}
