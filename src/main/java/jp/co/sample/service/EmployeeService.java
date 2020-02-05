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

	private EmployeeRepository repository;
	
	/**
	 * リポジトリーのfindAllメソッドの呼び出し.
	 * 
	 * @return 従業員情報を全て取得.
	 */
	@Autowired
	
	public List<Employee> showList(){
		return repository.findAll();
	}
}
