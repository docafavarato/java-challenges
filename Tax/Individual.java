package entities;
public class Individual extends TaxPayer {
	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public Double tax() {
		double taxTotal = 0;
		if (this.getAnualIncome() < 20000.00) {
			taxTotal = this.getAnualIncome() * 0.15;
		} else if (this.getAnualIncome() >= 20000.00) {
			taxTotal = this.getAnualIncome() * 0.25;
		}
		
		if (this.healthExpenditures > 0) {
			taxTotal -= (this.healthExpenditures * 0.5);
		}
		return taxTotal;
	}
}
