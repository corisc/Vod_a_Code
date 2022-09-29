package bwl.oo.paket10;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Office class is a class that represents an office of a company
 */
public class Office {

    private String name;
    private String address;
    private ArrayList<Department> departmentRegister = new ArrayList<>();
    private Company company;

    private static final Logger logger = Logger.getLogger(String.valueOf(Office.class));

    public Office(String name, String address, Company company) {
        this.name = name;
        this.address = address;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * This function adds a department to the department register.
     *
     * @param department The department to be added to the register.
     */
    public void addDepartmentToRegister(Department department){
        departmentRegister.add(department);
    }

    /**
     * This function returns the amount of departments in the department register.
     *
     * @return The amount of departments in the department register.
     */
    public int amountOfDepartments(){
        return departmentRegister.size();
    }

    /**
     * The function takes a string as input and removes the department with the same name from the department register
     *
     * @param name1 The name of the department to be removed
     * @return The method returns a Department object.
     */
    public Department removeDepartmentFromRegister(String name1){
        for(Department department : departmentRegister){
            if(department.getName().equals(name1)){
                departmentRegister.remove(department);
                logger.log(Level.FINE, "Department {} was removed", name1);
            }
        }
        logger.log(Level.FINE, "Department {} not found", name1);
        return null;
    }

}
