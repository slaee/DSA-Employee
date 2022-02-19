package Payroll;

import Payroll.Enums.Gender;

public class BacalsoCommissionEmployee extends BacalsoEmployee{
    private double commission;
    private double commissionPerItem;
    private int numberOfItemsSold;
    private double regularSalary;
    private double salary;

    public BacalsoCommissionEmployee() {
        super();
    }

    public BacalsoCommissionEmployee(String name, int age, String company, Gender gender, String address){
        super(name, age, company, gender, address);
        commissionPerItem = 0;
        regularSalary = 0;
    }

    public BacalsoCommissionEmployee(String name, int age, String company, Gender gender, String address, double commissionPerItem, int numberOfItemsSold, double regularSalary){
        super(name, age, company, gender, address);
        this.commissionPerItem = commissionPerItem;
        this.numberOfItemsSold = numberOfItemsSold;
        this.regularSalary = regularSalary;
    }

    public String basicToString(){
        return "Type: CE " + super.toString();
    }

    public String toString(){
        return super.toString()
            +"\nCommission per item: PHP " + String.format("%.2f", this.getCommissionPerItem())
            +"\nNumber of items sold: " + this.getNumberOfItemSold()
            +"\nRegular salary: PHP " + String.format("%.2f", this.getRegularySalary())
            +"\n";
    }

    public String payrollToString(){
        return super.toString()
            +"\nCommission per item: PHP " + String.format("%.2f", this.getCommissionPerItem())
            +"\nNumber of items sold: " + this.getNumberOfItemSold()
            +"\nRegular salary: PHP " + String.format("%.2f", this.getRegularySalary())
            +"\nSalary: PHP " + String.format("%.2f", this.getSalary())
            +"\n";
    }

    public void computeCommission(){
        this.commission = this.getNumberOfItemSold() * this.getCommissionPerItem();
    }

    public void computeSalary(){
        this.salary = this.getRegularySalary() + this.getCommission();
    }

    /**
     * Override setters and getters
     */

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

    public void setCommissionPerItem(double commissionPerItem){
        this.commissionPerItem = commissionPerItem;
    }

    public void setRegularSalary(double regularSalary){
        this.regularSalary = regularSalary;
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

    public void setNumberOfItemSold(int numberOfItemsSold){
        this.numberOfItemsSold += numberOfItemsSold;
    }

    public int getNumberOfItemSold(){
        return numberOfItemsSold;
    }

    public double getCommissionPerItem(){
        return commissionPerItem;
    }
    
    public double getCommission(){
        return commission;
    }

    public double getRegularySalary(){
        return regularSalary;
    }

    public double getSalary(){
        return salary;
    }
}