import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employee;
import entities.OutsourcedEmployee;

public class app {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i+1) + " data:");
			System.out.print("Outsourced? (y/n): ");
			char outBool = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			Integer hours = sc.nextInt();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			if (outBool == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				OutsourcedEmployee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				employees.add(employee);
			} else if (outBool == 'n') {
				Employee employee = new Employee(name, hours, valuePerHour);
				employees.add(employee);
			}
		}
		
		System.out.println("PAYMENTS: ");
		for (Employee e : employees) {
			System.out.println(e.getName() + " - $" + e.payment());
		}
		sc.close();
	}
} 
