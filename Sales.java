package application;

public class Sales {
	private int sales_ID;
	private int Patient_ID;
	private int drugs_ID;
	private int count;
	private int phar_ID;
	private String phar_com;
	private int saleprice;

	public Sales(int sales_ID, int patient_ID, int drugs_ID, int count, int phar_ID, String phar_com,
			int saleprice) {
		super();
		this.sales_ID = sales_ID;
		Patient_ID = patient_ID;
		this.drugs_ID = drugs_ID;
		this.count = count;
		this.phar_ID = phar_ID;
		this.phar_com = phar_com;
		this.saleprice = saleprice;
	}

	public int getSales_ID() {
		return sales_ID;
	}

	public void setSales_ID(int sales_ID) {
		this.sales_ID = sales_ID;
	}

	public int getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}

	public int getDrugs_ID() {
		return drugs_ID;
	}

	public void setDrugs_ID(int drugs_ID) {
		this.drugs_ID = drugs_ID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPhar_ID() {
		return phar_ID;
	}

	public void setPhar_ID(int phar_ID) {
		this.phar_ID = phar_ID;
	}

	public String getPhar_com() {
		return phar_com;
	}

	public void setPhar_com(String phar_com) {
		this.phar_com = phar_com;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

}