package Payroll;

import Payroll.Enums.Gender;

public class BacalsoHourlyEmployee extends BacalsoEmployee{
    private double salary;
    private int workedHours;
    private double dailyRate;

    private final int REGULAR_WORKING_HOURS = 40;
    private final float OT_PAY_RATE = 1.25f;

    public BacalsoHourlyEmployee(){
        super();
    }

    public BacalsoHourlyEmployee(String name, int age, String company, Gender gender, String address){
        super(name, age, company, gender, address);
        dailyRate = 0;
        workedHours = 0;
        salary = 0;
    }

    public BacalsoHourlyEmployee(String name, int age, String company, Gender gender, String address, int workedHours, double dailyRate){
        super(name, age, company, gender, address);
        this.workedHours = workedHours;
        this.dailyRate = dailyRate;
    }

    public void computeSalary(){
        //assume 5 days for 40 hours in a week will be 8 hours every day
        double hourlyRate = (this.getDailyRate() / (REGULAR_WORKING_HOURS/5));
        // total regulary working in a month is 40*4weeks = 160hours
        if(workedHours > 160){
            int OTHours = this.getHoursWorked() % REGULAR_WORKING_HOURS;
            int regularHoursWorked = 160;

            double OTPay = OTHours * (hourlyRate * OT_PAY_RATE);
            System.out.println("OTPay: " + OTPay);
            this.salary = (regularHoursWorked * hourlyRate) + OTPay;

        }else{
            this.salary = this.getHoursWorked() * hourlyRate;
        }
    }

    public String basicToString(){
        return "Type: HE " + super.toString();
    }

    public String payrollToString(){
        int OTHours;
        int regularHoursWorked;

        if (this.getHoursWorked() > 160){
            OTHours = this.getHoursWorked() % REGULAR_WORKING_HOURS;
            regularHoursWorked = 160;
        } else {
            OTHours = 0;
            regularHoursWorked = this.getHoursWorked();
        }
        return super.toString()
            +"\nDaily rate: PHP " + String.format("%.2f",this.getDailyRate())
            +"\nOver time Pay Rate: " + (OT_PAY_RATE * 100) + "%"
            +"\nRegular Hours worked: " + regularHoursWorked 
            +"\nOvertime Hours worked: " + OTHours
            +"\nTotal Hours worked: " + this.getHoursWorked()
            +"\nSalary: PHP" + String.format("%.2f", this.getSalary())
            +"\n";
    }

    public String toString(){
        return super.toString()
            +"\nDaily rate: PHP " + String.format("%.2f",this.getDailyRate())
            +"\nWorked hours: " + this.getHoursWorked()
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

    public void setNumberOfHoursWorked(int workedHours){
        this.workedHours += workedHours;
    }

    public int getHoursWorked(){
        return workedHours;
    }

    public double getDailyRate(){
        return dailyRate;
    }

    public double getSalary(){
        return salary;
    }
}
