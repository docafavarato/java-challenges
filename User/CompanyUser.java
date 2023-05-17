package entities;

public class CompanyUser extends User {
	private String companyName;
	public CompanyUser(String userName, String email, String password, String companyName) {
		super(userName, email, password);
		this.companyName = companyName;
	}
}
