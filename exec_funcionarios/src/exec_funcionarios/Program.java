package exec_funcionarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Departament;
import entites.HourContract;
import entites.Worker;
import entites.enums.WorkerLevel;


public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter department's name: ");
		String departamentName = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));
		
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Enter Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContracts(contract);
			
		}
		
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String montAndYear = sc.next();
		int month = Integer.parseInt(montAndYear.substring(0, 2)); // converte para inteiro
		int year = Integer.parseInt(montAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament " + worker.getDepartament().getName());
		System.out.println("Income for: " + montAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		
		sc.close();
	}

}
