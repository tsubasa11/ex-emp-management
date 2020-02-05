package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.service.EmployeeService;

/**
 * employeesテーブルのcontrollerクラス
 * 
 * @author namikitsubasa
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 従業員一覧表示.
	 * 
	 * @param model
	 * @return 従業員一覧に画面遷移
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employList=employeeService.showList();
		model.addAttribute("employList", employList);
		
		return "employee/list";
	}

}
