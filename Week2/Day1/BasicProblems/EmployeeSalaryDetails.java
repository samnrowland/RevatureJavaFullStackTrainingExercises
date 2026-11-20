
public class EmployeeSalaryDetails {
	public static double calculateBonus(double salary, double bonusPercentage) {
		return salary * (bonusPercentage / 100);
	}
	
	public static void main(String[] args) {
		String id = "Employee ID: 101";
		String name = "Name: Rahul";
		String salary = "Basic Salary: 60000";
		String bonus = "Bonus Percentage: 20";
		String active = "Active: true";
		
		try {
			int empId = Integer.parseInt(id.split(":")[1].trim());
			String empName = name.split(":")[1].trim();
			double empSalary = Double.parseDouble(salary.split(":")[1].trim());
			double empBonus = Double.parseDouble(bonus.split(":")[1].trim());
			boolean empActive = Boolean.parseBoolean(active.split(":")[1].trim());
			
			
			System.out.println("Employee ID: " + empId);
			System.out.println("Employee Name: " + empName.toUpperCase());
			System.out.println("Basic Salary: " + empSalary);
			System.out.println("Bonus: " + calculateBonus(empSalary, empBonus));
			System.out.println("Final Salary: " + (empSalary + calculateBonus(empSalary, empBonus)));
			System.out.println("Active: " + empActive);
			System.out.println("Reversed Name: " + new StringBuilder(empName).reverse().toString());
			System.out.println("Salary above 75000: " + ((empSalary > 75000) ? "Yes" : "No"));
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format: " + e.getMessage());
		}

	}
}
