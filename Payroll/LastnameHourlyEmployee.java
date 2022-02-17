package Payroll;

import Payroll.Enums.Gender;

public class LastnameHourlyEmployee extends LastnameEmployee{
    private double salary;
    private int workedHours;
    private double dailyRate;

    private final int REGULAR_WORKING_HOURS = 40;
    private final float OT_PAY_RATE = 1.25f;

    public LastnameHourlyEmployee(){
        super();
    }

    public LastnameHourlyEmployee(String name, int age, String company, Gender gender, String address){
        super(name, age, company, gender, address);
        this.dailyRate = 0;
        this.workedHours = 0;
        this.salary = 0;
    }

    public LastnameHourlyEmployee(String name, int age, String company, Gender gender, String address, int workedHours, double dailyRate){
        super(name, age, company, gender, address);
        this.workedHours = workedHours;
        this.dailyRate = dailyRate;
    }

    public void computeSalary(){
        float hourlyRate = (float) (this.getDailyRate() / REGULAR_WORKING_HOURS);
        if(workedHours > 40){
            int OTHours = this.getWorkedHours() - REGULAR_WORKING_HOURS;
            float OTPay = OTHours * (hourlyRate * OT_PAY_RATE);
            this.salary = (REGULAR_WORKING_HOURS * hourlyRate) + OTPay;
        }else{
            this.salary = workedHours * hourlyRate;
        }
    }

    public String basicToString(){
        return "Type: HE " + super.toString();
    }

    public String toString(){
        return super.toString()
            +"\nDaily rate: " + this.getDailyRate()
            +"\nWorked hours: " + this.getWorkedHours()
            +"\n";
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

    public void setDailyRate(double dailyRate){
        this.dailyRate = dailyRate;
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

    public int getRegularWorkingHours(){
        return REGULAR_WORKING_HOURS;
    }

    public int getWorkedHours(){
        return workedHours;
    }

    public double getDailyRate(){
        return dailyRate;
    }

    public double getSalary(){
        return salary;
    }
}
