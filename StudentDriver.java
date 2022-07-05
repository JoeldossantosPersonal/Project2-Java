/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author dianar
 */
public class StudentDriver {

   
    public static void main(String[] args) throws FileNotFoundException {
        
        //initializing variables
        int totalCoursesG=0, scpU=0, courses=0, coursesCountU=0, deductionStu=0, gaCount=0;
        double totalFeeOnline=0, totalFeeG=0, totalFeeU=0;
        
        //Dynamic input for ammount of Employees in file
        Scanner chooseFile = new Scanner(System.in);
        System.out.print("Enter the number of UG students: ");
        int ug = chooseFile.nextInt();

        System.out.print("Enter the number of Graduate Students: ");
        int gs = chooseFile.nextInt();

        System.out.print("Enter the number of online students: ");
        int os = chooseFile.nextInt();

        //Dynamic array size based on user input
        int tot = ug + gs + os;
        studentFees[] students = new studentFees[12];

        //File input based on user input
        File file = new File("input.csv");
        Scanner inputFile = new Scanner(file);

        //Variables used to take in data from csv file
        int i = 0, count = 1, totalNoCourses = 0;
        String stuName;
        int stuId, coursesEnrolled;
        boolean enrolled, scholarship;
        double sa, payableAmount;
        String[] line = null;

        while (inputFile.hasNextLine()) {
            if (i < students.length) {
                //if statement to create only UndergraduateStudents objects
                if (i < ug + 1) {
                    //Split method with a delimiter of ","
                    line = inputFile.nextLine().split(",");

                    //Parsing out each data piece according to array 
                    stuName = line[1];
                    stuId = Integer.parseInt(line[0]);
                    enrolled = Boolean.parseBoolean(line[2]);
                    scholarship = Boolean.parseBoolean(line[4]);
                    sa = Double.parseDouble(line[5]);
                    coursesEnrolled = Integer.parseInt(line[3]);

                    //Setting new Object type based on input from parsed array
                    students[i] = new UGStudent(stuName, stuId, enrolled, scholarship, sa, coursesEnrolled);
                    payableAmount=students[i].getPayableAmount();
                    totalFeeU=totalFeeU+payableAmount;
                    i++;
                    
                    if(enrolled==false){
                        ug-=1;
                        deductionStu+=1;
                    }
                    if(scholarship==true){
                        scpU++;
                    }
                    if(coursesEnrolled>0){
                    coursesCountU+=coursesEnrolled;
                    }
                }
                 //if statement to create only GraduateStudents objects
                else if (i >= ug && i < (ug+os+1)) {
                    String[] line2 = inputFile.nextLine().split(",");
                    if (line2.length == 6) {
                        //Parsing out each data piece according to array 
                        stuName = line2[1];
                        stuId = Integer.parseInt(line2[0]);
                        boolean ga = Boolean.parseBoolean(line2[2]);
                        boolean gat = Boolean.parseBoolean(line2[4]);
                        coursesEnrolled = Integer.parseInt(line2[3]);
                        String type = line2[5];

                        //Setting new Object type based on input from parsed array
                        students[i] = new GraduateStudent(stuName, stuId, ga, gat, type, coursesEnrolled);
                        i++;
                    }
                    else{
                        //Parsing out each data piece according to array 
                        stuName = line2[1];
                        stuId = Integer.parseInt(line2[0]);
                        boolean ga = Boolean.parseBoolean(line2[2]);
                        boolean gat = Boolean.parseBoolean(line2[4]);
                        coursesEnrolled = Integer.parseInt(line2[3]);

                        //Setting new Object type based on input from parsed array
                        students[i] = new GraduateStudent(stuName, stuId, ga, gat, coursesEnrolled);
                        payableAmount=students[i].getPayableAmount();
                        totalFeeG+=payableAmount;
                        i++;
                        
                        if (ga==true) {
                            gaCount++;
                        }
                        totalCoursesG+=coursesEnrolled;
                    }
                    
                    
                    //else statement that creates OnlineStudents  objects
                } 
                else{
                    line = inputFile.nextLine().split(",");

                    //Parsing out each data piece according to array 
                    stuName = line[1];
                    stuId = Integer.parseInt(line[0]);
                    boolean isEnrolled = Boolean.parseBoolean(line[2]);
                    int noOfMonths = Integer.parseInt(line[3]);

                    //Setting new Object type based on input from parsed array
                    students[i] = new OnlineStudent(stuName, stuId, isEnrolled, noOfMonths);
                    payableAmount=students[i].getPayableAmount();
                    totalFeeOnline+=payableAmount;
                    i++;
                }
            }
        }
        inputFile.close();
        
        
        
        
        
        System.out.println("\n\n**********Undergraduate students list**********");
        for (int j = 0; j < ug; j++) {
            System.out.println(students[j]);
            System.out.println();
        }
        System.out.println("**********Graduate students list**********");
        for (int j = ug; j < ug+gs; j++) {
            System.out.println(students[j]);
            System.out.println();

        }
        System.out.println("**********Online students list**********"); 
        for (int j = gs+ug; j < ug+gs+os; j++) {
            System.out.println(students[j]);
            System.out.println();
        }
        
      

        System.out.println("\n\n**********Undergraduate Students details**********");
        System.out.printf("Average student fee: %.2f", totalFeeU/ug);
        System.out.println("\nScholarship count: " + scpU);
        System.out.println("Total number of courses: " + coursesCountU);
        System.out.println("\n\n**********Graduate Students details**********");
        System.out.printf("Average student fee: %.2f",totalFeeG/gs);
        System.out.println("\nGraduate Assistantship count: " + gs);
        System.out.println("Total number of courses: "+ totalCoursesG);
        System.out.println("\n\n**********Online Students details**********");
        System.out.printf("Average student fee: %.2f" , (totalFeeOnline/os));
        System.out.println();
    }
}
