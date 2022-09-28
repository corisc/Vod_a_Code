package bwl.oo.paket10;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It's a class that represents a department in a company
 */
public class Department {
    private String name;
    private ArrayList<Employee> employeesRegister = new ArrayList<>();
    private Company company;

    Logger logger = Logger.getLogger(String.valueOf(Department.class));



    public Department(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }


    /**
     * This function adds an employee to the register.
     *
     * @param employee The employee to be added to the register.
     */
    public void addEmployeeToRegister(Employee employee) {
        employeesRegister.add(employee);
    }
    /**
     * This function returns the amount of employees in the register.
     *
     * @return The amount of employees in the register.
     */
    public int amountOfEmployees(){
        return employeesRegister.size();
    }

    /**
     * Search the employeesRegister list for an employee with the given id, and return that employee if found, otherwise
     * return null.
     *
     * @param id The id of the employee you want to search for.
     * @return The employee object with the matching ID.
     */
    public Employee searchEmployeesRegister(int id) {
        for(Employee emp : employeesRegister) {
            if(emp.getId() == id) {
                return emp;
            }
        }
        logger.log(Level.INFO,"ID: {0} not found", id);
        return null;
    }

    /**
     * It removes an employee from the register if the employee's ID matches the ID passed as a parameter
     *
     * @param id The id of the employee to be removed
     * @return The method returns the employee object that was removed from the register.
     */
    public Employee removeEmployeeFromRegister(int id) {
        for(Employee emp : employeesRegister) {
            if(emp.getId() == id) {
                employeesRegister.remove(emp);
                return emp;
            }
        }
        logger.log(Level.INFO,"ID: {0} not found", id);
        return null;
    }
}
