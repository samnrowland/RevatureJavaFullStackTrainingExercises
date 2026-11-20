
public class Wrapper {
	public static void wrapperDemo(String intValue, String doubleValue, String booleanValue) {
		try {
			Integer intAge = Integer.parseInt(intValue);
			Double dSalary = Double.parseDouble(doubleValue);
			Boolean bActive = Boolean.parseBoolean(booleanValue);
			
			System.out.println("Age: " + intAge + " Type: " + ((Object)intAge).getClass().getSimpleName());
			System.out.println("Salary: " + dSalary + " Type: " + ((Object)dSalary).getClass().getSimpleName());
			System.out.println("Active: " + bActive + " Type: " + ((Object)bActive).getClass().getSimpleName());
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format: " + e.getMessage());
			return;
		}
	}
	
	
	public static void main(String[] args) {
		String age = "25";
		String salary = "45000.75";
		String active = "true";
		
		wrapperDemo(age, salary, active);
	}

}
