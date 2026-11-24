package week2.day4.fileHandling;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		Employee[] empArray = new Employee[5];
		Employee[] empFileArray;
		
		for (int i = 0; i < empArray.length; i++) {
			empArray[i] = new Employee(i, "Employee" + i, "IT", 75000);
		}
		
		try {
			FileOutputStream fos = new FileOutputStream("employees.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(empArray);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream("employees.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			empFileArray = (Employee[]) ois.readObject();
			ois.close();
			
			for (Employee e : empFileArray) {
				System.out.println(e.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
