package bwl.oo.paket10;

import bwl.oo.paket6.Kunde;
import bwl.oo.paket8.Konto;
import com.ml.views.AusgabeFenster;


public class StartMain {


    /**
     * The function creates a company, a bank account, 100 customers, 2 offices, 4 departments and 6 employees
     */
    public static void main(String[] args) {

        Company u1 = new Company("SAP");
        Konto k = new Konto(104, u1.getName(), 3000000);


        for (int i = 0; i < 100; i++) {
            String first = "hans" + i;
            String last = "bert" + i;
            Kunde kunde1 = new Kunde(first, last);
            u1.addCustomer(kunde1);
        }

        Office o1 = new Office("o1", "test", u1);
        Office o2 = new Office("o2", "test", u1);

        Department d1 = new Department("d1", u1);
        Department d2 = new Department("d2", u1);
        Department d3 = new Department("d3", u1);
        Department d4 = new Department("d4", u1);

        Employee employee1 = new Employee(1, "Hans", "Bert");
        Employee employee2 = new Employee(2, "Franz", "Gerd");
        Employee employee3 = new Employee(3, "Gerd", "Herd");
        Employee employee4 = new Employee(4, "Kann", "Mann");
        Employee employee5 = new Employee(5, "Lenn", "Renn");
        Employee employee6 = new Employee(6, "Ben", "Ten");

        u1.setKonto(k);

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
        aus.ausgeben("Name der Firma: " + u1.getName());
        aus.ausgeben("Konto der Firma: " + u1.getKonto());
        aus.ausgeben("Anzahl Kunden:  " + u1.amountOfCustomer());
        aus.ausgeben("Anzahl der Abteilungen: " + o1.amountOfDepartments());
        aus.ausgeben("Anzahl der Angestellten: " + d1.amountOfEmployees());
        aus.ausgeben("Finde Employee mit der ID 1: " + d1.searchEmployeesRegister(1).toString());
        aus.ausgeben("Künndige Employee mit der ID 6: " + d1.removeEmployeeFromRegister(6).toString());
        aus.ausgeben("Anzahl der Angestellten: " + d1.amountOfEmployees());
    }

}

