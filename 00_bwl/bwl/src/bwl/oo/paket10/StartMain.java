package bwl.oo.paket10;

import com.ml.views.AusgabeFenster;


public class StartMain {

  /**
   * The function creates a company, two offices, four departments and six employees. The employees are added to the
   * departments and the departments are added to the offices. The function then prints out the name of the company, the
   * amount of departments in the first office, the amount of employees in the first department, the employee with the ID 1
   * and the employee with the ID 6
   */
  public static void main(String[] args) {
    
    Company u1 = new Company("SAP");

    Office o1 = new Office("o1","test",u1);
    Office o2 = new Office("o2","test",u1);

    Department d1 = new Department("d1",u1);
    Department d2 = new Department("d2",u1);
    Department d3 = new Department("d3",u1);
    Department d4 = new Department("d4",u1);

    Employee employee1 = new Employee(1,"Hans", "Bert");
    Employee employee2 = new Employee(2,"Franz", "Gerd");
    Employee employee3 = new Employee(3,"Gerd", "Herd");
    Employee employee4 = new Employee(4,"Kann","Mann");
    Employee employee5 = new Employee(5,"Lenn", "Renn");
    Employee employee6 = new Employee(6,"Ben", "Ten");

    o1.addDepartmentToRegister(d1);
    o2.addDepartmentToRegister(d2);
    o1.addDepartmentToRegister(d3);
    o1.addDepartmentToRegister(d4);

    d1.addEmployeeToRegister(employee1);
    d2.addEmployeeToRegister(employee2);
    d3.addEmployeeToRegister(employee3);
    d4.addEmployeeToRegister(employee4);
    d1.addEmployeeToRegister(employee5);
    d2.addEmployeeToRegister(employee6);
    d1.addEmployeeToRegister(employee6);
    
    AusgabeFenster aus = new AusgabeFenster();
    aus.ausgeben(u1.getName());
    aus.ausgeben(o1.amountOfDepartments());
    aus.ausgeben(d1.amountOfEmployees());
    aus.ausgeben(d1.searchEmployeesRegister(1).toString());
    aus.ausgeben(d1.removeEmployeeFromRegister(6).toString());
    aus.ausgeben(d1.amountOfEmployees());
  }

}

