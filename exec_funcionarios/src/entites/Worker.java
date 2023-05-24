package entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entites.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}


	/// Métodos para adicionar e remover contratos da lista declarada lá em cima.
	public void addContracts(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContracts(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month ) {
		double sum = baseSalary;
		
		// Instancia o objeto Calendar
		Calendar cal = Calendar.getInstance();
		
		for(HourContract c: contracts) {
			// Ele pega o objeto instanciado e coloca nele a data que o User digitou.
			cal.setTime(c.getDate());
			
			// Aqui ele pega apenas o ano que o usuário digitou e dps o mês.
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
			
			
		}
		return sum;
		
	}
	
}
