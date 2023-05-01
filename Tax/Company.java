package entities;
public class Company extends TaxPayer {
	private Integer numberOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		double taxTotal = 0;
		if (this.numberOfEmployees <= 10) {
			taxTotal = this.getAnualIncome() * 0.16;
		} else if (this.numberOfEmployees > 10) {
			taxTotal = this.getAnualIncome() * 0.14;
		}
		return taxTotal;
	}
}
