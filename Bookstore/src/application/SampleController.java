package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Scanner;
import application.Main.Information;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class SampleController implements Initializable {
	
	 	@FXML
	    private Button btnAccount, btnCustomer, btnBook, btnExit, btnAddPerson, btnAddBook, btnAddCustomer;
	 	@FXML
	    private GridPane pnAccount, pnCustomer, pnBook;
	    @FXML
	    private Pane pnlStatus;
	    @FXML
	    private Label lblStatus, lblWelcome;    
	    @FXML
	    private ComboBox<String> boxCustomer, boxBook;
	    @FXML
	    private TextField txtName, txtSurname, txtPhone, txtBookName, txtAuthor, txtCustomerId, txtBookId;
	    @FXML
	    private DatePicker processDate;
	    @FXML
	    private TableView<Account> tablePerson;
	    @FXML
	    private TableColumn<Account, String> Account_id, Account_name, Account_surname, Account_phone;
	    @FXML
	    private TableView<Book> tableBook;   
	    @FXML
	    private TableColumn<Book, String> Book_id, Book_name, Book_author, Book_category, Book_stock;
	    @FXML
	    private TableView<Customer> tableCustomer;    
	    @FXML
	    private TableColumn<Customer, String> Customer_account_id, Customer_book_id, Type, Date;
	    @FXML
	    public static String temp;
	    @FXML
	    private StringBuffer sbuf1 = new StringBuffer("");
	    @FXML
        private String message;
	    
	    @FXML    
		private void handleClicks (ActionEvent event) throws FileNotFoundException {		
	    		    	
	    	lblStatus.setVisible(true);
	    	pnlStatus.setVisible(true);
	    	lblWelcome.setVisible(false); 	
	    	message = sbuf1.toString();
	    	
	    	if(event.getSource() == btnAccount){
			
	    		message = ("Create Account");
	    		lblStatus.setText(message);
	    		pnAccount.setVisible(true);
	    		pnBook.setVisible(false);
	    		pnCustomer.setVisible(false);
	    	}
		
	    	else if(event.getSource() == btnCustomer){
	    	
	    		message = ("Transactions");
	    		lblStatus.setText(message);
	    		pnCustomer.setVisible(true);
	    		pnAccount.setVisible(false);
	    		pnBook.setVisible(false);
	    	}
	    	
	    	else if(event.getSource() == btnBook){
			
	    		message = ("Book List");
	    		lblStatus.setText(message);
	    		pnBook.setVisible(true);
	    		pnAccount.setVisible(false);
				pnCustomer.setVisible(false);
	    	}
		
	    	else if(event.getSource() == btnExit) {
	    		Information.finish = System.currentTimeMillis();
	    		writeText();
	    		Information.timeElapsed = Information.finish - Information.start;
	    		System.out.println("Execution time of program is : "+Information.timeElapsed);
	    		System.exit(0);		
	    	}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			loadText();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Account_id.setCellValueFactory(new PropertyValueFactory<Account, String> ("id"));
		Account_name.setCellValueFactory(new PropertyValueFactory<Account, String> ("name"));
		Account_surname.setCellValueFactory(new PropertyValueFactory<Account, String> ("surname"));
		Account_phone.setCellValueFactory(new PropertyValueFactory<Account, String> ("phone"));	
		
		Book_id.setCellValueFactory(new PropertyValueFactory<Book, String> ("id"));
		Book_name.setCellValueFactory(new PropertyValueFactory<Book, String> ("name"));
		Book_author.setCellValueFactory(new PropertyValueFactory<Book, String> ("author"));
		Book_category.setCellValueFactory(new PropertyValueFactory<Book, String> ("category"));	
		Book_stock.setCellValueFactory(new PropertyValueFactory<Book, String> ("stock"));	

		Customer_account_id.setCellValueFactory(new PropertyValueFactory<Customer, String> ("id"));
		Customer_book_id.setCellValueFactory(new PropertyValueFactory<Customer, String> ("bookId"));
		Type.setCellValueFactory(new PropertyValueFactory<Customer, String> ("type"));
		Date.setCellValueFactory(new PropertyValueFactory<Customer, String> ("date"));	

		boxCustomer.getItems().addAll("Rent", "Sale");
		boxBook.getItems().addAll("Arts & Music", "Biographies", "Business", "Comics", "Computers & Tech", "Cooking"
				,"Edu & Reference", "Entertainment","Health & Fitness","History","Hobbies & Crafts","Home & Garden"
				,"Horror","Kids","Literature & Fiction","Medical","Mysteries","Parenting","Religion","Romance"
				,"Sci-Fi & Fantasy","Science & Math","Self-Help","Social Sciences","Romance","Sports","Teen","Travel");
	}
	
	@FXML
    private void clickAddPerson(ActionEvent event) {
		event.consume();              
        if (Information.accounts.size()>0) {
        	
        	for (int i=0; i<Information.accounts.size(); i++) {
        		
        		if (txtName.getText().equals(Information.accounts.get(i).getName() ) ) {
        			
        			if (txtSurname.getText().equals(Information.accounts.get(i).getSurname() ) ) {
        				
        				if (txtPhone.getText().equals(Information.accounts.get(i).getPhone() ) ) {

        					Alert alert = new Alert(AlertType.INFORMATION);
        					alert.setTitle("Warning");
        					alert.setHeaderText("Account match");
        					alert.setContentText("Account you have been trying to create is already exists. Please try another accounr or continue with any other operation.");
        					alert.showAndWait();
        					return;
        				}
        				else {
        					Information.accounts.get(i).setPhone(txtPhone.getText());
        					tablePerson.refresh();
        					Alert alert = new Alert(AlertType.INFORMATION);
        					alert.setTitle("Information");
        					alert.setHeaderText("Account updated");
        					alert.setContentText("Account information you have entered is already exists with other phone number. Phone value updated.");
        					alert.showAndWait();
        					return;
        				}
                    }
                }
        	}
        }
        Account account = new Account(String.valueOf(Information.personId),txtName.getText(), txtSurname.getText(), txtPhone.getText());
        Information.accounts.add(account);
        tablePerson.getItems().add(account);
        Information.personId++;
	}
	
	@FXML
    private void clickAddBook(ActionEvent event) {
        event.consume();              
        if (Information.books.size()>0) {
        	
        	for (int j=0; j<Information.books.size(); j++) {
        		
        		if (txtBookName.getText().equals(Information.books.get(j).getName() ) ) {
        			
        			if (txtAuthor.getText().equals(Information.books.get(j).getAuthor() ) ) {
        				
        				if (boxBook.getValue().equals(Information.books.get(j).getCategory() ) ) {

        					Information.books.get(j).setStock(String.valueOf(Integer.parseInt(Information.books.get(j).getStock())+1));
        					tableBook.refresh();
        					return;
        				}
                    }
                }
        	}
        }
        StringBuilder sbui1 = new StringBuilder("1");
        String one = sbui1.toString();
        Book book = new Book(String.valueOf(Information.bookId),txtBookName.getText(),txtAuthor.getText(),boxBook.getValue(), one);
        Information.books.add(book);
        tableBook.getItems().add(book);
        Information.bookId++;
	}
	
	@FXML
    private void clickAddCustomer(ActionEvent event) {
        event.consume();
        boolean checkBook = false;
        boolean checkAccount = false;
        Book book = null;
        for(int i=0;i<Information.books.size();i++) {
        	if(txtBookId.getText().equals(Information.books.get(i).getId())) {
        		checkBook=true;
        		book = Information.books.get(i);
        	}
        }
        for(int i=0;i<Information.accounts.size();i++) {
        	if(txtCustomerId.getText().equals(Information.accounts.get(i).getId())) {
        		checkAccount=true;
        	}
        }
        if(checkBook && checkAccount) {	
        	if (!book.getStock().equals("0")) {
        		String date = processDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        		Customer customer = new Customer( txtCustomerId.getText(),txtBookId.getText(),boxCustomer.getValue(),date);
        		Information.customers.add(customer);
        		tableCustomer.getItems().add(customer);
        		int k = Integer.parseInt(book.getStock());
        		k--;  		
        		book.setStock(Integer.toString(k));
        		tableBook.refresh();
        	}
        	else {
        		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Warning");
				alert.setHeaderText("Insufficient Stock ");
				alert.setContentText("Book you have ordered is currently out of stock. Please check on later due.");
				alert.showAndWait();
        	}
        }
        else {
        	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Warning");
			alert.setHeaderText("Invalid ID");
			alert.setContentText("Either book id or account id which you have entered is invalid. Please check list and try again.");
			alert.showAndWait();
			return;
        }
    }
	
	@FXML
	private void loadText() throws FileNotFoundException {
		FileInputStream fisAccount = new FileInputStream("account.txt");
		try (Scanner scAccount = new Scanner(fisAccount)) {
			while (scAccount.hasNext()) {
			
				Account account = new Account(scAccount.nextLine(),scAccount.nextLine(), scAccount.nextLine(), scAccount.nextLine());
				Information.accounts.add(account);
				tablePerson.getItems().add(account);
				Information.personId++;
			}
		}
		FileInputStream fisBook = new FileInputStream("book.txt");
		try (Scanner scBook = new Scanner(fisBook)) {
			while (scBook.hasNext()) {
			
				Book book = new Book(scBook.nextLine(),scBook.nextLine(), scBook.nextLine(), scBook.nextLine(), scBook.nextLine());
				Information.books.add(book);
				tableBook.getItems().add(book);
				Information.bookId++;
			}
		}
		FileInputStream fisCustomer = new FileInputStream("customer.txt");
		try (Scanner scCustomer = new Scanner(fisCustomer)) {
			while (scCustomer.hasNext()) {
			
				Customer customer = new Customer(scCustomer.nextLine(),scCustomer.nextLine(), scCustomer.nextLine(), scCustomer.nextLine());
				Information.customers.add(customer);
				tableCustomer.getItems().add(customer);
			}
		}
	}
	
	@FXML
	public static void writeText() throws FileNotFoundException {
		FileOutputStream fosAccount = new FileOutputStream("account.txt",false);
		PrintWriter pwAccount = new PrintWriter(fosAccount);
		FileOutputStream fosBook = new FileOutputStream("book.txt",false);
		PrintWriter pwBook = new PrintWriter(fosBook);
		FileOutputStream fosCustomer = new FileOutputStream("customer.txt",false);
		PrintWriter pwCustomer = new PrintWriter(fosCustomer);
		
		for (int i=0; i<Information.accounts.size(); i++) {
    		
			temp = Information.accounts.get(i).getId(); 
			pwAccount.println(temp);
			temp = Information.accounts.get(i).getName(); 
			pwAccount.println(temp);
    		temp = Information.accounts.get(i).getSurname();
    		pwAccount.println(temp);
    		temp = Information.accounts.get(i).getPhone();
    		pwAccount.println(temp);
		}
		pwAccount.close();
		
		for (int j=0; j<Information.books.size(); j++) {
    		
			temp = Information.books.get(j).getId(); 
			pwBook.println(temp);
			temp = Information.books.get(j).getName(); 
			pwBook.println(temp);
    		temp = Information.books.get(j).getAuthor();
    		pwBook.println(temp);
    		temp = Information.books.get(j).getCategory();
    		pwBook.println(temp);
    		temp = Information.books.get(j).getStock();
    		pwBook.println(temp);
		}
		pwBook.close();
		
		for (int k=0; k<Information.customers.size(); k++) {
    		
			temp = Information.customers.get(k).getId(); 
			pwCustomer.println(temp);
			temp = Information.customers.get(k).getBookId(); 
			pwCustomer.println(temp);
    		temp = Information.customers.get(k).getType();
    		pwCustomer.println(temp);
    		temp = Information.customers.get(k).getDate();
    		pwCustomer.println(temp);
		}
		pwCustomer.close();	
	}
}