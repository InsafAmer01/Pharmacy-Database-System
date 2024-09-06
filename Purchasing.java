package application;

public class Purchasing {
	private int purchase_ID;
	private int patients_ID;
	private int drug_ID;

	public Purchasing(int purchase_ID, int patients_ID, int drug_ID) {
		super();
		this.purchase_ID = purchase_ID;
		this.patients_ID = patients_ID;
		this.drug_ID = drug_ID;
	}

	public int getPurchase_ID() {
		return purchase_ID;
	}

	public void setPurchase_ID(int purchase_ID) {
		this.purchase_ID = purchase_ID;
	}

	public int getPatients_ID() {
		return patients_ID;
	}

	public void setPatients_ID(int patients_ID) {
		this.patients_ID = patients_ID;
	}

	public int getDrug_ID() {
		return drug_ID;
	}

	public void setDrug_ID(int drug_ID) {
		this.drug_ID = drug_ID;
	}

}
