/**
 * Automated Payroll System
 * Written by: Sly Kint A. Bacalso
 * CS-228 
 * 
 * This program is a payroll system applied with Data Structures
 * and Algorithm that will automate the process of model.
 * 
 * openjdk version "11.0.14" 2022-01-18
 * OpenJDK Runtime Environment (build 11.0.14+9-post-Debian-1)
 * penJDK 64-Bit Server VM (build 11.0.14+9-post-Debian-1, mixed mode, sharing)
 * 
 * Usage: 
 *  $ javac Main.java && java Main
 * 
 * Machine OS used: Linux 
 */

import Payroll.*;
import Payroll.EmployeeGenerator.DataFaker;

import java.security.SecureRandom;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // init objects
        BacalsoEmployeeRoster roster = new BacalsoEmployeeRoster();
        DataFaker faker = new DataFaker();
        Timer timer = new Timer();
        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        // configuration of data
        String companyName;
        double wagePerItem, commissionPerItem, dailyRate, regularSalary;
        System.out.println("To start the system");
        System.out.println("Please Complete the configuration: ");
        System.out.print(">> Enter company name: ");
        companyName = sc.nextLine();
        System.out.println("\nFor Piece Worker");
        System.out.print(">> Enter wage per item: ");
        wagePerItem = sc.nextDouble();
        System.out.println("\nFor Commission Worker");
        System.out.print(">> Enter commission per item: ");
        commissionPerItem = sc.nextDouble();
        System.out.print(">> Enter regular salary: ");
        regularSalary = sc.nextDouble();
        System.out.println("\nFor Hourly Worker");
        System.out.print(">> Enter daily rate: ");
        dailyRate = sc.nextDouble();
        System.out.println();

        System.out.println("\n All Set!\n");

        System.out.println("=========================================");
        System.out.println("=  Welcome to Automated Payroll System  =");
        System.out.println("=========================================");
        System.out.println("    Written by: Sly Kint A. Bacalso\n");
        System.out.println("Description:");
        System.out.println("This program will generate a monthly payroll");
        System.out.println("for your company. You don't need to  stress");
        System.out.println("yourself, let the program do the work");
        System.out.println("for you.\n");

        // All test cases are passed removing assert after testing
        long time = 5000L;
        for(int i = 1; i <= 8; i++){
            switch(i){
                case 1: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("HR is now adding randomly employees to your company...");
                            System.out.println("Please wait for a second...\n");
                        }
                    }, time);
                    time += 3000L;
                    for(int j = 1; j <= 20; j++){
                        timer.schedule(new TimerTask(){
                            @Override
                            public void run(){
                                int randNumber = random.nextInt(4 - 1) + 1;
                                if(randNumber == 1){
                                    roster.add(new BacalsoCommissionEmployee(faker.lastname(), faker.age(), companyName, faker.gender(), faker.address()));
                                }
                                else if(randNumber == 2) {
                                    roster.add(new BacalsoHourlyEmployee(faker.lastname(), faker.age(), companyName, faker.gender(), faker.address()));
                                }
                                else { 
                                    roster.add(new BacalsoPieceWorker(faker.lastname(), faker.age(), companyName, faker.gender(), faker.address()));
                                }
                                roster.setCommissionPerItemForAllCE(commissionPerItem);
                                roster.setWageForAllPE(wagePerItem);
                                roster.setDailyRateForAllHE(dailyRate);
                                roster.setRegularSalaryForAllCE(regularSalary);
                            }
                        }, time += 50L);
                    }
                }
                break;
                case 2: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("=========================================");
                            System.out.println("\nDisplaying all employee basic data...\n");
                            System.out.println("=========================================");
                        }
                    }, time += 2000L);

                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            roster.display();
                        }
                    }, time += 4000L);
                }
                break;
                case 3: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("=========================================");
                            System.out.println("\nDisplaying data by Commission Employees...\n");
                            System.out.println("=========================================");
                        }
                    }, time += 1000L);

                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            roster.displayCE();
                        }
                    }, time += 2000L);
                }
                break;
                case 4: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("=========================================");
                            System.out.println("\nDisplaying data by Hourly Employees...\n");
                            System.out.println("=========================================");
                        }
                    }, time += 1000L);

                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            roster.displayHE();
                        }
                    }, time += 2000L);
                }
                break;
                case 5: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("=========================================");
                            System.out.println("\nDisplaying data by Piece Workers...\n");
                            System.out.println("=========================================");
                        }
                    }, time += 1000L);

                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            roster.displayPE();
                        }
                    }, time += 2000L);
                }
                break;
                case 6: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("\nTotal Comission Employee added: "+ roster.countCE());
                            System.out.println("Total Hourly Employee added: "+ roster.countHE());
                            System.out.println("Total Piece Worker added: "+ roster.countPE());
                            System.out.println("Total Employee Added: " + roster.count());
                        }
                    }, time += 100L);
                }
                break;
                case 7: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("=========================================");
                            System.out.println("\nEmployee starting to work...\n");
                            System.out.println("=========================================");
                        }
                    }, time += 2000L);
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("Week 1...\n");
                            roster.work();

                            //chance to fire or leave and remove employee
                            if(random.nextInt(3 - 1) + 1 == 1){
                                System.out.println("Some employee is getting fired...");
                                roster.remove(random.nextInt(roster.count()+1 - 1) + 1);
                            }

                            if(random.nextInt(3 - 1) + 1 == 1){
                                System.out.println("Some employee is leaving without prior notice...");
                                roster.remove(random.nextInt(roster.count()+1 - 1) + 1);
                            }
                        }
                    }, time += 2000L);
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("Week 2...\n");
                            roster.work();
                        }
                    }, time += 2000L);
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("Week 3...\n");
                            roster.work();
                        }
                    }, time += 2000L);

                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("Week 4...\n");
                            roster.work();
                        }
                    }, time += 2000L);
                }
                break;
                case 8: {
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("End of the month...");
                        }
                    }, time += 2000L);

                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.out.println("=========================================");
                            System.out.println("\nCalculating payroll please wait...\n");
                            System.out.println("=========================================");
                        }
                    }, time += 2000L);
                    timer.schedule(new TimerTask(){
                        @Override
                        public void run(){
                            roster.payroll();

                            // end the timer task
                            timer.cancel();
                        }
                    }, time += 4000L);
                    
                }
            }
        }
        sc.close();
    }      
}