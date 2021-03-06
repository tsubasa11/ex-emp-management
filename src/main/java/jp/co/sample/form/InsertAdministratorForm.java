package jp.co.sample.form;

/**
 * AdministratorsテーブルのFormクラス.
 * 
 * @author namikitsubasa
 *
 */
public class InsertAdministratorForm {
	
	/**名前*/
	private String name;
	/**アドレス*/
	private String mailAddress;
	/**パスワード*/
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ ", getName()=" + getName() + ", getMailAddress()=" + getMailAddress() + ", getPassword()="
				+ getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
