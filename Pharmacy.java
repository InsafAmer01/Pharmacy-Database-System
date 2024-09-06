package application;

public class Pharmacy {
	private int pharmacy_ID;
	private String phname;
	private String address;
	private int phPhone;

	public Pharmacy(int pharmacy_ID, String phname, String address, int phPhone) {
		super();
		this.pharmacy_ID = pharmacy_ID;
		this.phname = phname;
		this.address = address;
		this.phPhone = phPhone;
	}

	public int getPharmacy_ID() {
		return pharmacy_ID;
	}

	public void setPharmacy_ID(int pharmacy_ID) {
		this.pharmacy_ID = pharmacy_ID;
	}

	public String getPhname() {
		return phname;
	}

	public void setPhname(String phname) {
		this.phname = phname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhPhone() {
		return phPhone;
	}

	public void setPhPhone(int phPhone) {
		this.phPhone = phPhone;
	}

}