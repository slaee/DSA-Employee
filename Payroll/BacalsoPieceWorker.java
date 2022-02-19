package Payroll;

import Payroll.Enums.Gender;

public class BacalsoPieceWorker extends BacalsoEmployee{
    private double salary;
    private double wagePerItem;
    private int numberOfItemCompleted;

    public BacalsoPieceWorker() {
        super();
    }

    public BacalsoPieceWorker(String name, int age, String company,
    Gender gender, String address){
        super(name, age, company, gender, address);
        wagePerItem = 0;
    }

    public BacalsoPieceWorker(String name, int age, String company, Gender gender, String address, double wagePerItem, int numberOfItemCompleted){
        super(name, age, company, gender, address);
        this.wagePerItem = wagePerItem;
        this.numberOfItemCompleted = numberOfItemCompleted;
    }

    public void computeSalary(){
        this.salary = this.getWagePerItem() * this.getNumberOfItemCompleted();
    }

    public String payrollToString(){
        return super.toString()
            +"\nWage per item: PHP " + String.format("%.2f", this.getWagePerItem())
            +"\nNumber of items completed: " + this.getNumberOfItemCompleted()
            +"\nSalary: PHP " + String.format("%.2f", this.getSalary())
            +"\n";
    }

    /**
     * Override setters and getters
     */

    public String basicToString(){
        return "Type: PE "+ super.toString();
    }

    public String toString(){
        return super.toString()
            +"\nWage per item: PHP " + String.format("%.2f", this.getWagePerItem())
            +"\nItem completed: " + getNumberOfItemCompleted()
            +"\n";
    }

    public void setName(String name){
        super.setName(name);
    }

    public void setAge(int age){
        super.setAge(age);
    }

    public void setCompany(String company){
        super.setCompany(company);
    }

    public void setGender(Gender gender){
        super.setGender(gender);
    }

    public void setAddress(String address){
        super.setAddress(address);
    }

    public void setNumberOfItemCompleted(int numberOfItemCompleted){
        this.numberOfItemCompleted += numberOfItemCompleted;
    }

    public void setWagePerItem(double wagePerItem){
        this.wagePerItem = wagePerItem;
    }

    public String getName(){
        return super.getName();
    }

    public int getAge(){
        return super.getAge();
    }

    public String getCompany(){
        return super.getCompany();
    }

    public Gender getGender(){
        return super.getGender();
    }

    public String getAddress(){
        return super.getAddress();
    }

    public int getNumberOfItemCompleted(){
        return numberOfItemCompleted;
    }

    public double getWagePerItem(){
        return wagePerItem;
    }

    public double getSalary(){
        return salary;
    }
}
