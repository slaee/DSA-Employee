package Payroll;

import java.util.Arrays;

public class LastnameEmployeeRoster {
    private int size;
    private int index;
    LastnameEmployee[] EmployeeList;

    /**
     * Java Dynamic Array Data Structure
     * type {add}
     * 
     * This method will dynamically reallocate the array
     * with the new size by data growth of L*2,
     * 
     * Process:
     * copy the main array of object to the new one
     * and reassign to the main array of object with the new size
     * 
     * @return void
     */
    void dynamic_add(){
        int newSize = size * 2;
        LastnameEmployee[] newEmployee = Arrays.copyOf(EmployeeList, newSize);
        EmployeeList = newEmployee;
        size = newSize;
    }

    /**
     * Java Dynamic Array Data Structure
     * type {reduce}
     * 
     * This method will dynamically reallocate the array
     * with the new size of reduced length of L/2,
     * 
     * Process:
     * copy the main array of object to the new one
     * and reassign to the main array of object with the new size
     * 
     * @return void
     */
    void dynamic_reduce(){
        int newSize = size / 2;
        LastnameEmployee[] newEmployee = Arrays.copyOf(EmployeeList, newSize);
        EmployeeList = newEmployee;
        size = newSize;
    }

    public LastnameEmployeeRoster() {
        size = 5; // default size of EmployeeList
        index = 0;
        EmployeeList = new LastnameEmployee[size];
    }

    public void add(LastnameEmployee employee) {
        if(index == getSize()) {
            dynamic_add();
        }
        EmployeeList[index] = employee;
        EmployeeList[index].setIdNumber(index+1);
        index++;

        System.out.println("Employee " 
            +"ID: "+ index
            +" Name: "+employee.getName() 
            +" has been added.");
    }

    public void remove(int idNumber) {
        for (int i = 0; i < index; i++) {
            if (EmployeeList[i].getIdNumber() == idNumber) {
                // delete the object and let the java garbage collector do the work
                EmployeeList[i] = null;

                // then shift the array elements
                for (int j = i; j < index - 1; j++) {
                    EmployeeList[j] = EmployeeList[j + 1];
                }
                index--;
                if(size != 5) {
                    dynamic_reduce();
                }
                System.out.println("Employee " + EmployeeList[i].getName() 
                    +" ID: "+ idNumber 
                    +" has been removed."); 
                break;
            }
        }
    }

    public int count() {
        return getSize();
    }

    private int getSize(){
        return index;
    }

    private boolean isEmpty(){
        return index == 0;
    }

    private boolean isCE(Object o){
        return o instanceof LastnameCommissionEmployee;
    }

    private boolean isHE(Object o){
        return o instanceof LastnameHourlyEmployee;
    }


    private boolean isPE(Object o){
        return o instanceof LastnamePieceWorker;
    }

    public int countCE() {
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (isCE(EmployeeList[i])) {
                count++;
            }
        }
        return count;
    }

    public int countHE() {
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (isHE(EmployeeList[i])) {
                count++;
            }
        }
        return count;
    }

    public int countPE() {
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (isPE(EmployeeList[i])) {
                count++;
            }
        }
        return count;
    }
    
    public void setWageForAllPE(double wage){
        for (int i = 0; i < index; i++) {
            if (isPE(EmployeeList[i])) {
                // cast the super object to the subclass object to access the subclass
                ((LastnamePieceWorker) EmployeeList[i]).setWagePerItem(wage);
            }
        }
    }

    public void setDailyRateForAllHE(double dailyRate){
        for (int i = 0; i < index; i++) {
            if (isHE(EmployeeList[i])) {
                // cast the super object to the subclass object to access the subclass method
                ((LastnameHourlyEmployee) EmployeeList[i]).setDailyRate(dailyRate);
            }
        }
    }

    public void setCommissionPerItemForAllCE(double commissionPerItem){
        for (int i = 0; i < index; i++) {
            if (isCE(EmployeeList[i])) {
                // cast the super object to the subclass object to access the subclass method
                ((LastnameCommissionEmployee) EmployeeList[i]).setCommissionPerItem(commissionPerItem);
            }
        }
    }

    public void setRegularSalaryForAllCE(double regularSalary){
        for (int i = 0; i < index; i++) {
            if (isCE(EmployeeList[i])) {
                // cast the super object to the subclass object to access the subclass method
                ((LastnameCommissionEmployee) EmployeeList[i]).setRegularSalary(regularSalary);
            }
        }
    }

    public void display() {
        for (int i = 0; i < index; i++) {
            System.out.println(EmployeeList[i].basicToString());
        }
    }

    public void displayCE() {
        for (int i = 0; i < index; i++) {
            if (isCE(EmployeeList[i])) {
                System.out.println(EmployeeList[i].toString());
            }
        }
    }

    public void displayHE() {
        for (int i = 0; i < index; i++) {
            if (isHE(EmployeeList[i])) {
                System.out.println(EmployeeList[i].toString());
            }
        }
    }

    public void displayPE() {
        for (int i = 0; i < index; i++) {
            if (isPE(EmployeeList[i])) {
                System.out.println(EmployeeList[i].toString());
            }
        }
    }

    public void payroll() {
        for (int i = 0; i < index; i++) {
            EmployeeList[i].computeSalary();
            System.out.println(EmployeeList[i].toString());
        }
    }
}