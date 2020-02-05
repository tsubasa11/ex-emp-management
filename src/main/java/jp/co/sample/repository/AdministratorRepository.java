package jp.co.sample.repository;

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
		administrator.setMailAdress(rs.getString("mail_address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};

	/**
	 * 管理者情報を登録する.
	 * 
	 * @param administrator　管理者情報
	 */
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		String insertSql = "insert into administrators (name,mail_address,password) values(:name,:mailAdress,:password)";

		template.update(insertSql, param);
	}

	/**
	 * 管理者情報をメールアドレスとパスワードで検索する.
	 * @param mailAddress　メールアドレス
	 * @param password　パスワード
	 * @return　管理者情報一覧
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {

		String sql = "select id,name,mail_address,password from administrators where mail_address=:mailAddress and password=:password";

		MapSqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress)
				.addValue("password", password);

		try {
			Administrator administrator = template.queryForObject(sql, param, ADMINISTRATOR_ROW_MAPPER);
			return administrator;			
		}catch(Exception ex) {
			return null;			
		}

	//	if (administrator==null){}
		
	}

}
