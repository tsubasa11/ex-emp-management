package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
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
	private AdministratorService administratorService;

	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * 管理者情報登録画面へ遷移する.
	 * 
	 * @return　管理者情報登録画面
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
		
		administratorService.insert(administrator);
		
		return "redirect:/";
		
	}

}
