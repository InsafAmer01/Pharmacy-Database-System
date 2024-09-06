package application;

public class PatinetData {
	private int id;
	private String name;
	private int age;
	private String gender;
	private int phoneNumber;
	private String siknesName;
	private int doctor_ID;
	private int drug_ID;

	PatinetData(int id, String name, int age, String gender, int phoneNumber, String siknesName, int doctor_ID,
			int drug_ID) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.siknesName = siknesName;
		this.doctor_ID = doctor_ID;
		this.drug_ID = drug_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSiknesName() {
		return siknesName;
	}

	public void setSiknesName(String siknesName) {
		this.siknesName = siknesName;
	}

	public int getDoctor_ID() {
		return doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		this.doctor_ID = doctor_ID;
	}

	public int getDrug_ID() {
		return drug_ID;
	}

	public void setDrug_ID(int drug_ID) {
		this.drug_ID = drug_ID;
	}

	@Override
	public String toString() {
		return "PatinetData [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", siknesName=" + siknesName + ", doctor_ID=" + doctor_ID + ", drug_ID=" + drug_ID
				+ "]";
	}
}
