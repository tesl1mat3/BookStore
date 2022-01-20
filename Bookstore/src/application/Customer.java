package application;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleStringProperty Col_account_id, Col_book_id, Col_type, Col_date;
	
	public Customer(String id, String bookId, String type, String date) {
		this.Col_account_id = new SimpleStringProperty(id);
		this.Col_book_id = new SimpleStringProperty(bookId);
		this.Col_type = new SimpleStringProperty(type);
		this.Col_date = new SimpleStringProperty(date);	
	}
	
	public String getId() {
		return Col_account_id.get();
	}
	public void setId(String customerAccountId) {
		this.Col_account_id.set(customerAccountId);
	}
	public String getBookId() {
		return Col_book_id.get();
	}
	public void setBookId(String customerBookId) {
		this.Col_book_id.set(customerBookId);
	}
	public String getType() {
		return Col_type.get();
	}
	public void setType(String type) {
		this.Col_type.set(type);
	}
	public String getDate() {
		return Col_date.get();
	}
	public void setDate(String date) {
		this.Col_date.set(date);
	}
}