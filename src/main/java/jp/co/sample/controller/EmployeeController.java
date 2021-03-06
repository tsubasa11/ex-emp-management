package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
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
	
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
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
//		System.out.println(employList.get(4));
		model.addAttribute("employList", employList);
		
		return "employee/list";
	}
	
	/**
	 * id検索で取得した従業員情報をリクエストスコープに格納
	 * 
	 * @param id 従業員id
	 * @param model 
	 * @return 従業員詳細画面に遷移
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		
		Employee employee=employeeService.showDetail(Integer.parseInt(id));

		model.addAttribute("employee", employee);
		
		return "employee/detail";
	}
	
	/**
	 * 従業員の扶養人数の更新.
	 * 
	 * @param form リクエストパラメータ
	 * @return 従業員一覧画面遷移のメソッドにリダイレクト
	 */
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));

		employeeService.update(employee);
		
		return "redirect:/employee/showList";
	}

}
