package application;
import javafx.beans.property.SimpleStringProperty;

public class Account {
	private SimpleStringProperty Col_id, Col_name, Col_surname, Col_phone;
	
	public Account(String id, String name, String surname, String phone) {
		this.Col_id = new SimpleStringProperty(id);
		this.Col_name = new SimpleStringProperty(name);
		this.Col_surname = new SimpleStringProperty(surname);
		this.Col_phone = new SimpleStringProperty(phone);
	}

	public String getId() {
		return Col_id.get();
	}
	public void setId(String id) {
		this.Col_id.set(id);
	}
	public String getName() {
		return Col_name.get();
	}
	public void setName(String name) {
		this.Col_name.set(name);
	}
	public String getSurname() {
		return Col_surname.get();
	}
	public void setSurname(String surname) {
		this.Col_surname.set(surname);
	}
	public String getPhone() {
		return Col_phone.get();
	}
	public void setPhone(String phone) {
		this.Col_phone.set(phone);
	}
}