/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author s545242
 */
public abstract class studentFees {
    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    private final int CREDITS_PER_COURSE = 3;
    private final double PER_CREDIT_FEE = 543.50;

public studentFees(String studentName,  int studentID, boolean isEnrolled){
    this.studentName=studentName;
    this.studentID=studentID;
    this.isEnrolled=isEnrolled;
}
    /**
     * @return the getStudentName
     */
    public String getStudentName(){
        return this.studentName;
    }
     /**
     * @return the getStudentID
     */
    public int getStudentID(){
        return this.studentID;
    }
   
   /**
     * @return the isEnrolled
     */
    public boolean isIsEnrolled() {
        return isEnrolled;
    }
     /**
     * @return the CREDITS_PER_COURSE
     */
    public int getCREDITS_PER_COURSE() {
        return CREDITS_PER_COURSE;
    }
    /**
     * @return the PER_CREDIT_FEE
     */
    public double getPER_CREDIT_FEE() {
        return PER_CREDIT_FEE;
    }
    
    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    /**
     * @param isEnrolled the isEnrolled to set
     */
    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }
    
    public abstract double getPayableAmount();
    
    @Override
    public String toString(){
        return "Student Name: " + this.studentName + "\nStudent ID: " + this.studentID + "\nEnrolled: " + this.isEnrolled;
    }
}
