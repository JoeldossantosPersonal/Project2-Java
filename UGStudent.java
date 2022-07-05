/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

public class UGStudent extends studentFees{
    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE=820.70;
    
public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled){
    super(studentName, studentID, isEnrolled);
    this.hasScholarship=hasScholarship;
    this.scholarshipAmount=scholarshipAmount;
    this.coursesEnrolled=coursesEnrolled;
    
}    
      /**
     * @return the hasScholarship
     */
    public boolean isHasScholarship() {
        return this.hasScholarship;
    }
    
    /**
     * @return the scholarshipAmount
     */
    public double getScholarshipAmount() {
        return this.scholarshipAmount;
    }

    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return this.coursesEnrolled;
    }
     /**
     * @return the PayableAmount
     */
    @Override
    public double getPayableAmount(){
        if(this.isIsEnrolled()==true){
        int tuitonFee=this.getCREDITS_PER_COURSE()*getCoursesEnrolled();  
        double noCredits = tuitonFee * getPER_CREDIT_FEE();
        return (noCredits + this.ADDITIONAL_FEE) - this.scholarshipAmount;
    }
        else{
            return 0;
        }
    }
    
    @Override
     public String toString(){
        return super.toString() + "\nScholarship: " + this.hasScholarship + "\nScholarship amount: " + getScholarshipAmount() + "\nCourses Enrolled: " + getCoursesEnrolled() + "\nPayable amount: " + getPayableAmount();
    }
}
