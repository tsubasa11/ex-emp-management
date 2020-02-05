package jp.co.sample.domain;

/**
 * 管理者情報を表すドメイン.
 * 
 * @author namikitsubasa
 *
 */
public class Administrator {

	/** id */
	private Integer id;

	/** 名前 */
	private String name;

	/** アドレス */
	private String mailAdress;

	/** パスワード */
	private String password;

	public Administrator(Integer id, String name, String mailAdress, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mailAdress = mailAdress;
		this.password = password;
	}

	public Administrator() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mailAdress=" + mailAdress + ", password=" + password
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getMailAdress()=" + getMailAdress()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
