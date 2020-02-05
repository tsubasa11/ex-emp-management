package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報を操作するコントローラ.
 * 
 * @author namikitsubasa
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private HttpSession session;

	@Autowired
	private AdministratorService administratorService;

	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/**
	 * 管理者情報登録画面へ遷移する.
	 * 
	 * @return 管理者情報登録画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {

		return "administrator/insert.html";
	}

	/**
	 * 
	 * @param form 入力された情報を格納する変数(リクエストパラメータ)
	 * @return ログイン画面
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		administrator.setName(form.getName());
		administrator.setMailAdress(form.getMailAddress());
		administrator.setPassword(form.getPassword());
//		SqlParameterSource param = new BeanPropertySqlParameterSource(form);

		administratorService.insert(administrator);

		return "redirect:/";

	}

	/**
	 * ログイン画面に遷移.
	 * 
	 * @return ログイン画面に遷移.
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

	/**
	 * ログイン処理.
	 * 
	 * @param form  管理者情報
	 * @param model リクエストスコープ
	 * @return ログイン画面、もしはログイン後の画面を表示
	 */
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator=administratorService.login(form.getMailAddress(), form.getPassword());
		if (administrator == null) {
			String error = "メールアドレスまたはパスワードが不正です。";
			model.addAttribute("error", error);
			
			return "administrator/login";
		} else {
			session.setAttribute("administratorName",administrator.getName());
			return "forward:/employee/showList";
		}
		
		
	}

}
