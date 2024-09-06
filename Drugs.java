package application;


public class Drugs {
	private int drug_ID;
	private int Quantity;
	private int Doctor_ID;
	private int patient_ID;
	private int comp_ID;
	private String drname;
	private int drprice;
	private String description;
	private String production_Date;
	private String expiry_date;

	public Drugs(int drug_ID, int quantity, int doctor_ID, int patient_ID, int comp_ID, String drname, int drprice,
			String description, String production_Date, String expiry_date) {
		super();
		this.drug_ID = drug_ID;
		Quantity = quantity;
		Doctor_ID = doctor_ID;
		this.patient_ID = patient_ID;
		this.comp_ID = comp_ID;
		this.drname = drname;
		this.drprice = drprice;
		this.description = description;
		this.production_Date = production_Date;
		this.expiry_date = expiry_date;
	}

	public int getDrug_ID() {
		return drug_ID;
	}

	public void setDrug_ID(int drug_ID) {
		this.drug_ID = drug_ID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getDoctor_ID() {
		return Doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		Doctor_ID = doctor_ID;
	}

	public int getPatient_ID() {
		return patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		this.patient_ID = patient_ID;
	}

	public int getComp_ID() {
		return comp_ID;
	}

	public void setComp_ID(int comp_ID) {
		this.comp_ID = comp_ID;
	}

	public String getDrname() {
		return drname;
	}

	public void setDrname(String drname) {
		this.drname = drname;
	}

	public int getDrprice() {
		return drprice;
	}

	public void setDrprice(int drprice) {
		this.drprice = drprice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduction_Date() {
		return production_Date;
	}

	public void setProduction_Date(String production_Date) {
		this.production_Date = production_Date;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

}
