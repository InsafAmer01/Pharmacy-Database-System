package application;

public class Company {
	private int comp_ID;
	private String comname;
	private int cPhone;

	public Company(int comp_ID, String comname, int cPhone) {
		super();
		this.comp_ID = comp_ID;
		this.comname = comname;
		this.cPhone = cPhone;
	}

	public int getComp_ID() {
		return comp_ID;
	}

	public void setComp_ID(int comp_ID) {
		this.comp_ID = comp_ID;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public int getcPhone() {
		return cPhone;
	}

	public void setcPhone(int cPhone) {
		this.cPhone = cPhone;
	}

}