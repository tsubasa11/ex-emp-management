package jp.co.sample.domain;

public class Administrator {

	/** 従業員id */
	private Integer id;

	/** 従業員の名前 */
	private String name;

	/** 従業員のアドレス */
	private String mailAdress;

	/** 従業員のパスワード */
	private String password;

	/** 全ての情報を定義 */
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
