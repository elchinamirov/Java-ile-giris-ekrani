package az.developia.springrest;

public class Student {
	
	private String name;
	private String surname;
	private String adress;
	private int phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Student(String name, String surname, String adress, int phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.phone = phone;
	}
	


}
