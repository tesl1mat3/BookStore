package application;
import javafx.beans.property.SimpleStringProperty;

public final class  Book {
	private SimpleStringProperty Col_id, Col_name, Col_author, Col_category, Col_stock;

	public Book(String id, String name, String author, String category, String stock) {
		this.Col_id = new SimpleStringProperty(id);
		this.Col_name = new SimpleStringProperty(name);
		this.Col_author = new SimpleStringProperty(author);
		this.Col_category = new SimpleStringProperty(category);
		this.Col_stock = new SimpleStringProperty(stock);
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
	public String getAuthor() {
		return Col_author.get();
	}
	public void setAuthor(String author) {
		this.Col_author.set(author);
	}
	public String getCategory() {
		return Col_category.get();
	}
	public void setCategory(String category) {
		this.Col_category.set(category);
	}
	public String getStock() {
		return Col_stock.get();
	}
	public void setStock(String stock) {
		this.Col_stock.set(stock);
	}
}