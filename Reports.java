package application;

public class Reports {

	private int report_ID;
	private int purchase_ID;
	private int drug_ID;
	private int Patient_ID;
	private int Doctor_ID;
	private String date;

	public Reports(int report_ID, int purchase_ID, int drug_ID, int patient_ID, int doctor_ID, String date) {
		super();
		this.report_ID = report_ID;
		this.purchase_ID = purchase_ID;
		this.drug_ID = drug_ID;
		Patient_ID = patient_ID;
		Doctor_ID = doctor_ID;
		this.date = date;
	}

	public int getReport_ID() {
		return report_ID;
	}

	public void setReport_ID(int report_ID) {
		this.report_ID = report_ID;
	}

	public int getPurchase_ID() {
		return purchase_ID;
	}

	public void setPurchase_ID(int purchase_ID) {
		this.purchase_ID = purchase_ID;
	}

	public int getDrug_ID() {
		return drug_ID;
	}

	public void setDrug_ID(int drug_ID) {
		this.drug_ID = drug_ID;
	}

	public int getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}

	public int getDoctor_ID() {
		return Doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		Doctor_ID = doctor_ID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}

