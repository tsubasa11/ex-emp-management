package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * employeesテーブルのサービスクラス.
 * 
 * @author namikitsubasa
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * リポジトリーのfindAllメソッドの呼び出し.
	 * 
	 * @return 従業員情報を全て取得.
	 */

	
	public List<Employee> showList(){
		return employeeRepository.findAll();
	}
	
	/**
	 * 
	 * リポジトリーのloadメソッドの呼び出し.
	 * 
	 * @param id
	 * @return 従業員のid検索
	 */
	public Employee showDetail(Integer id) {
		return employeeRepository.load(id);
	}
	
	/**
	 * リポジトリーのupdateメソッドの呼び出し.
	 * 
	 * @param employee 従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}
}
