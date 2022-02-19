package Payroll;

import java.security.SecureRandom;
import java.util.Arrays;

public class BacalsoEmployeeRoster {
    private int size;
    private int index;
    SecureRandom random;
    BacalsoEmployee[] EmployeeList;

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
        BacalsoEmployee[] newEmployee = Arrays.copyOf(EmployeeList, newSize);
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
        BacalsoEmployee[] newEmployee = Arrays.copyOf(EmployeeList, newSize);
        EmployeeList = newEmployee;
        size = newSize;
    }

    public BacalsoEmployeeRoster() {
        size = 5; // default size of EmployeeList
        index = 0;
        EmployeeList = new BacalsoEmployee[size];
        random = new SecureRandom();
    }

    public void add(BacalsoEmployee employee) {
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
                    +" has been removed.\n"); 
                break;
            }
        }
    }

    public void work(){
        for (int i = 0; i < index; i++) {
            if(isCE(EmployeeList[i])){
                int itemsSoldThisWeek = random.nextInt(20 - 10) + 10;
                ((BacalsoCommissionEmployee) EmployeeList[i]).setNumberOfItemSold(itemsSoldThisWeek);
            }

            if(isHE(EmployeeList[i])){
                int hoursWorkedThisWeek = random.nextInt(50 - 30) + 30;
                ((BacalsoHourlyEmployee) EmployeeList[i]).setNumberOfHoursWorked(hoursWorkedThisWeek);
            }

            if(isPE(EmployeeList[i])){
                int itemsCompletedThisWeek = random.nextInt(10 - 5) + 5;
                ((BacalsoPieceWorker) EmployeeList[i]).setNumberOfItemCompleted(itemsCompletedThisWeek);
            }
        }
    }

    public void payroll() {
        System.out.println(">>> Payroll Result <<<\n");
        System.out.println("========[ Commision Employees Payroll ]========\n");
        for (int i = 0; i < index; i++) {
            if(isCE(EmployeeList[i])){
                ((BacalsoCommissionEmployee) EmployeeList[i]).computeCommission();
                EmployeeList[i].computeSalary();
                System.out.println(EmployeeList[i].payrollToString());
            }
        }

        System.out.println("\n========[ Hourly Employees Payroll ]========\n");
        for (int i = 0; i < index; i++) {
            if(isHE(EmployeeList[i])){
                EmployeeList[i].computeSalary();
                System.out.println(EmployeeList[i].payrollToString());
            }
        }

        System.out.println("\n========[ Piece Wokers Payroll ]========\n");
        for (int i = 0; i < index; i++) {
            if(isPE(EmployeeList[i])){
                EmployeeList[i].computeSalary();
                System.out.println(EmployeeList[i].payrollToString());
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
        return o instanceof BacalsoCommissionEmployee;
    }

    private boolean isHE(Object o){
        return o instanceof BacalsoHourlyEmployee;
    }


    private boolean isPE(Object o){
        return o instanceof BacalsoPieceWorker;
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
                // cast the super object with subclass object to access the subclass
                ((BacalsoPieceWorker) EmployeeList[i]).setWagePerItem(wage);
            }
        }
    }

    public void setDailyRateForAllHE(double dailyRate){
        for (int i = 0; i < index; i++) {
            if (isHE(EmployeeList[i])) {
                // cast the super object with subclass object to access the subclass method
                ((BacalsoHourlyEmployee) EmployeeList[i]).setDailyRate(dailyRate);
            }
        }
    }

    public void setCommissionPerItemForAllCE(double commissionPerItem){
        for (int i = 0; i < index; i++) {
            if (isCE(EmployeeList[i])) {
                // cast the super object with subclass object to access the subclass method
                ((BacalsoCommissionEmployee) EmployeeList[i]).setCommissionPerItem(commissionPerItem);
            }
        }
    }

    public void setRegularSalaryForAllCE(double regularSalary){
        for (int i = 0; i < index; i++) {
            if (isCE(EmployeeList[i])) {
                // cast the super object with subclass object to access the subclass method
                ((BacalsoCommissionEmployee) EmployeeList[i]).setRegularSalary(regularSalary);
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
}