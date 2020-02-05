package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * administratorテーブルのサービスクラス.
 * 
 * @author namikitsubasa
 *
 */
@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	/**
	 * administratorレポジトリーのinsertメソッドを呼び起こす
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}
	
	/**
	 * レポジトリーのloginメソッドを呼び出す.
	 * 
	 * @param mailAddress　メールアドレス
	 * @param password パスワード
	 * @return　メールアドレスとパスワード情報を取得
	 */
	public Administrator login(String mailAddress,String password) {
		return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
	}

}
