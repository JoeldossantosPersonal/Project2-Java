/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;


/**
 *
 * @author s545242
 */
public class OnlineStudent extends studentFees{
    private int noOfMonths;
    private final double MONTHLY_FEE=1245.25;
   
public OnlineStudent(String studentName,  int studentID, boolean isEnrolled, int noOfMonths){
    super(studentName,studentID,isEnrolled);
    this.noOfMonths=noOfMonths;
}

 /**
 * @return the PayableAmount
 */
    @Override
  public double getPayableAmount(){
     return MONTHLY_FEE*noOfMonths;
    }
  
    @Override
  public String toString(){
        return super.toString()+ "\nNo of months: " + this.noOfMonths + "\nPayable amount: " + getPayableAmount();
    }
}
