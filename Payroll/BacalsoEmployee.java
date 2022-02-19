package Payroll;

import Payroll.Enums.Gender;

interface LastNameInterface {
    public void setIdNumber(int idNumber);
    public void setName(String name);
    public void setAge(int age);
    public void setCompany(String company);
    public void setGender(Gender gender);
    public void setAddress(String address);
    
    public int getIdNumber();
    public String getName();
    public int getAge();
    public String getCompany();
    public Gender getGender();
    public String getAddress();
}

public abstract class BacalsoEmployee implements LastNameInterface {
    private int idNumber;
    private String name;
    private int age;
    private String company;
    private Gender gender;
    private String address;

    public BacalsoEmployee() {}
    
    public BacalsoEmployee(String name, int age, String company, Gender gender, String address){
        this.name = name;
        this.age = age;
        this.company = company;
        this.gender = gender;
        this.address = address;
    }

    @Override public String toString(){
        return getIdNumber()
            +" " + getName()
            +" " + getAge()
            +" " + getGender().name().toLowerCase()
            +" (" + getAddress()
            +") " + getCompany();
    }

    public String basicData(){
        return toString();
    }

    /**
     * In C# this setters and getters should only be
     * attribue { get; set; }
     */

    public void setIdNumber(int idNumber){
        this.idNumber = idNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getIdNumber(){
        return idNumber;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getCompany(){
        return company;
    }

    public Gender getGender(){
        return gender;
    }

    public String getAddress(){
        return address;
    }

    public abstract String basicToString();
    public abstract void computeSalary();
    public abstract String payrollToString();
}