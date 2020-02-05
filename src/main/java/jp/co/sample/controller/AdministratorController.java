package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * administratorリポジトリを実行するコントローラ.
 * 
 * @author namikitsubasa
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	/**
	 * 入力画面から情報を受け取る
	 * 受け取った情報をInsertAdministratorFormオブジェクトに格納し、そのオブジェクトをリクエストスコープに格納
	 * 
	 * @return 画面遷移
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * insertメソッドの実行
	 * 
	 * @return　画面遷移
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {

		return "administrator/insert.html";
	}

}
