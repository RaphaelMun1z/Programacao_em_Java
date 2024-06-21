package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String strPath = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			List<Employee> emp = new ArrayList<>();

			String line = br.readLine();

			while (line != null) {
				String[] employeeData = line.split(",");

				String name = employeeData[0];
				String email = employeeData[1];
				Double salary = Double.parseDouble(employeeData[2]);

				emp.add(new Employee(name, email, salary));

				line = br.readLine();
			}

			System.out.print("Enter salary: ");
			double salaryValue = sc.nextDouble();

			List<String> empFilter = emp.stream()
					.filter(e -> e.getSalary() > salaryValue)
					.map(e -> e.getEmail())
					.sorted()
					.collect(Collectors.toList());

			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryValue) + ":");
			empFilter.forEach(System.out::println);

			double salarySum = emp.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (x, y) -> x + y);

			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", salarySum));
		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
	}

}
