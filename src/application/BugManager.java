package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;




public class BugManager {
	private int IDCounter = 0;
	int bugCounter = 0;
	private String filePath = "data.csv";
	HashMap<Integer,Bug> bugList = new HashMap<Integer,Bug>();
	

	//Get date and time
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		return dateFormat.format(date);
	}
	
	//Get current bug count
	public int get_bugCount() {
		return this.bugCounter;
	}
	
	//Add bug to the bugsList
	public void addBug(String location, String description, String steps, String expected, String actual) {
		IDCounter += 1;
		int bugID = IDCounter;
		String datetime_stamp = getDateTime();
		Bug bug = new Bug(bugID, datetime_stamp, location, description, steps, expected, actual);
		bugList.put(bugID, bug);
		bugCounter += 1;
	}
	//Get bug
	public Bug getBug(int bugID) {
		return bugList.get(bugID);
	}
	
	//Remove bug
	public void removeBug(int bugID) {
		bugList.remove(bugID);
		bugCounter -= 1;
	}
	
	
	//Write all bugs from memory to CSV
	public void export() {
		for(int key: bugList.keySet()) {
			Bug bug = bugList.get(key);
			writeCSV(bug.get_id(),
					 bug.get_datetime(),
					 bug.get_location(),
					 bug.get_description(),
					 bug.get_steps(),
					 bug.get_expected(),
					 bug.get_actual());
		}
		
	}
	public void writeCSV(int id, String dt, String loc, String des, String steps, String exp, String act) {
		try {
			FileWriter fw = new FileWriter(filePath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(id+","+dt+","+loc+","+des+","+steps+","+exp+","+act);
			pw.flush();
			pw.close();
			
		}catch(Exception e) {
			
		}
	}
	
	
}
