package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {
	// Bugs will be stored and retrieved from here
	BugManager bugManager = new BugManager();
	
	String str;
	
	@FXML
	private TextField locationField;
	@FXML
	private TextField descriptionField;
	@FXML
	private TextArea stepsArea;
	@FXML
	private TextArea expectedArea;
	@FXML
	private TextArea actualArea;
	@FXML
	private Label numberOfBugsFound;
	
	@FXML
	private TableView<Bug> tvBugs;
	
	@FXML
	private TableColumn<Bug,Integer> columnID;
	@FXML
	private TableColumn<Bug,String> columnLocation;
	@FXML
	private TableColumn<Bug,String> columnDescription;
	
	
	public void incrementFoundBugs() {
		
		int number = Integer.parseInt(numberOfBugsFound.getText());
		number += 1;
		numberOfBugsFound.setText(Integer.toString(number));
	}
	
	
	
	@FXML
	private Button submitBtn;
	
	@FXML
	private Button exportBtn;
	
	// If one text area or field is left empty then not valid and return false
	public boolean check_validation() {
		boolean isValid = true;
		
		if(locationField.getText().length() < 1) {
			isValid = false;
		}
		if(descriptionField.getText().length() < 1) {
			isValid = false;
		}
		if(stepsArea.getText().length() < 1) {
			isValid = false;
		}
		if(expectedArea.getText().length() < 1) {
			isValid = false;
		}
		if(actualArea.getText().length() < 1) {
			isValid = false;
		}
		return isValid;
		
	}
	
	public void clear_all_fields() {
		String setEmpty = "";
		locationField.setText(setEmpty);
		descriptionField.setText(setEmpty);
		stepsArea.setText(setEmpty);
		expectedArea.setText(setEmpty);
		actualArea.setText(setEmpty);
	}
	
	public void submit(ActionEvent event) {
		try {
			// Check all fields are filled or not empty
			if(this.check_validation()) {
				// Store the bug to memory in bug manager 
				bugManager.addBug(locationField.getText(), descriptionField.getText(), stepsArea.getText(), expectedArea.getText(), actualArea.getText());
				
				System.out.println("Data stored in BugManager");
				this.clear_all_fields();
				this.incrementFoundBugs();
			} else {
				System.out.println("ERROR! some fields have no data entry :(");
			}
			
			//str = locationField.getText();
			//System.out.println(str.length());
			//System.out.println(str);
			//System.out.println(stepsArea.getText());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public void export(ActionEvent event) {
		try {
			int bug_count = bugManager.get_bugCount();
			// Check that bugs have been logged first 
			if(bug_count > 0) {
				bugManager.export();
				System.out.println("Data exported to CSV");
			}else {
				System.out.println("No bugs have been logged yet");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	// Get all bugs
	//public ObservableList<Bug> getBugsList(){
	//	ObservableList<Bug> buglist = FXCollections.observableArrayList();
	//}
	
	
}
