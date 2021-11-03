package application;

public class Bug {
	 private Integer id;
	 String datetime;
	 String location;
	 String description;
	 String steps;
	 String expected;
	 String actual;
	 
	 
	 // Constructor
	 public Bug(Integer id, String datetime, String loc, String descr, String steps, String expected, String actual) {
		 this.id = id;
		 this.datetime = datetime;
		 this.location = loc;
		 this.description = descr;
		 this.steps = steps;
		 this.expected = expected;
		 this.actual = actual;
	 }
	 // Getters
	 public Integer get_id() {
		 return this.id;
	 }
	 public String get_datetime() {
		 return this.datetime;
	 }
	 public String get_location() {
		 return this.location;
	 }
	 public String get_description() {
		 return this.description;
	 }
	 public String get_steps() {
		 return this.steps;
	 }
	 public String get_expected() {
		 return this.expected;
	 }
	 public String get_actual() {
		 return this.actual;
	 }
	 
	 // Setters for edit and updates
	 public void set_location(String location) {
		 this.location = location;
	 }
	 public void set_description(String description) {
		 this.description = description;
	 }
	 public void set_steps(String steps) {
		 this.steps = steps;
	 }
	 public void set_expected(String expected) {
		 this.expected = expected;
	 }
	 public void set_actual(String actual) {
		 this.actual = actual;
	 }
	 // Bug return string for export
	 
	 
	 /// Print bug
	 public void printBug() {
		 System.out.println("ID: "+this.id + " DateTime: "+this.datetime);
		 System.out.println("Location: " + this.location);
		 System.out.println("Description: " + this.description);
		 System.out.println("Steps to Reproduce: ");
		 System.out.println(this.steps);
		 System.out.println("Expected results: ");
		 System.out.println(this.expected);
		 System.out.println("Actual results: ");
		 System.out.println(this.actual);
	 }
}
