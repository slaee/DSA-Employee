/**
 * Written by: Sly Kint A. Bacalso
 * Date Created: Feb 14, 2022
 * 
 * I intentionally grab some similar methods from my own original DataFaker library
 * and use them to generate fake data for the employees.
 */

package Payroll.EmployeeGenerator;

import Payroll.Enums.Gender;
import java.util.*;
import java.io.*;
import java.security.SecureRandom;

public class DataFaker {
    private static final SecureRandom random = new SecureRandom();

    public String lastname(){
        String lastname = null;
        try {
            lastname = generateLastName();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lastname;
    }

    public int age(){
        int age = 0;
        int requiredAge = 18;
        int maxAge = 65;
        age = generateAge(requiredAge, maxAge);
        return age;
    }

    public String address(){
        String address = null;
        try {
            address = generateAddress();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return address;
    }

    public Gender gender(){
        Gender gender = null;
        try {
            gender = randomEnumGender(Gender.class);
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        return gender;
    }

    private static int generateAge(int min, int max){
        int result = 0;
        result = new SecureRandom().nextInt(max - min) + min;
        return result;
    }

    private static String generateLastName() throws FileNotFoundException {
        String lastName = selectPlainData(new File("Payroll/EmployeeGenerator/datalib/lastname.txt"));
        return lastName;
    }

    private static String generateAddress() throws FileNotFoundException {
        String address = selectPlainData(new File("Payroll/EmployeeGenerator/datalib/address.txt"));
        return address;
    }

    public static <G extends Enum<?>> G randomEnumGender(Class<G> cls) throws IllegalArgumentException{
        int x = random.nextInt(cls.getEnumConstants().length);
        return cls.getEnumConstants()[x];
    }

    private static String selectPlainData(File f) throws FileNotFoundException {
        String result = null;
        int n = 0;

        Scanner sc = new Scanner(f);
        for (;sc.hasNext();) {
            ++n;
            String line = sc.nextLine();
            if (random.nextInt(n) == 0){
                result = line;
            }
        }
        return result;
    }
}
