package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * administratorsテーブルを操作するリポジトリ.
 * 
 * @author namikitsubasa
 *
 */
@Repository
public class AdministratorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/** RowMapperを定義 */
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAdress(rs.getString("mail_adress"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};

	/** sqlにデータを挿入する */
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		String insertSql = "insert into administrators (name,mail_adress,password) values(:name,:mailAdress,:password)";

		template.update(insertSql, param);
	}

	/** メールアドレスとパスワードで検索　リストにない場合はnullを表示 */
	public List<Administrator> findByMailAddressAndPassword(String mailAddress, String password) {

		String sql = "select id,name,mail_adress,password from administrators where mail_address=:mailAdress and password=:password";

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("mailAdress", mailAddress)
				.addValue("password", password);


		List<Administrator> administrator = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);

		if (administrator.size()==0){
		return null;
	}
		
		return administrator;
	}

}
