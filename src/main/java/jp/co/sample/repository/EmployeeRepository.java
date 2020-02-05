package jp.co.sample.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/** RowMapperを定義 */
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hire_date"));
		employee.setMailAdress(rs.getString("mail_adress"));
		employee.setZipCode(rs.getString("zip_code"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDepenentsCount(rs.getInt("depenentsCount"));
		return employee;
	};

	/**全件検索*/
	public List<Employee> findAll() {
		String sql = "select id,name,image,gender,hire_date,mail_adress,zip_code,address, telephone,salary,characteristics,depenentsCount";
		
		List<Employee> list = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return list;

	}
	
	/**id検索*/
	public Employee load(Integer id) {
		String sql="select id,name,image,gender,hire_date,mail_adress,zip_code,address, telephone,salary,characteristics,depenentsCount where id=:id";
		
		SqlParameterSource param =new  MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		
		return employee;
	}
	
	/**扶養人数の更新*/
	public void update(Employee employee) {
		String updateSql="update employees set depenentsCount=:depenentsCount where id=:id";
		SqlParameterSource param =new  MapSqlParameterSource().addValue("id", employee.getId()).addValue("depenentsCount", employee.getDepenentsCount());
		template.queryForObject(updateSql, param, EMPLOYEE_ROW_MAPPER);
	}
}
