package application;	
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));	
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Bookstore APP");
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}
	
	public static class Information{
        public static ArrayList<Account> accounts = new ArrayList<Account>();
        public static ArrayList<Book> books = new ArrayList<Book>();
        public static ArrayList<Customer> customers = new ArrayList<Customer>();
        public static int personId = 0, bookId = 0;  
    	public static long start = System.currentTimeMillis(), finish, timeElapsed;
    }
}