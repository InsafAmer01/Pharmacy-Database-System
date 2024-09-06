package application;

public class Doctor {
	private int Doctor_ID;
	private String dname;
	private int Phone;
	private String address;

	public Doctor(int doctor_ID, String dname, int phone, String address) {
		super();
		Doctor_ID = doctor_ID;
		this.dname = dname;
		Phone = phone;
		this.address = address;
	}

	public int getDoctor_ID() {
		return Doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		Doctor_ID = doctor_ID;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
