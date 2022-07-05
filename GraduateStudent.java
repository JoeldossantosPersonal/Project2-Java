
package studentdriver;

public class GraduateStudent extends studentFees{
    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private double ADDITIONAL_FEES=654.45;
    
public GraduateStudent(String studentName,  int studentID, boolean isEnrolled, boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled){
    super(studentName,studentID,isEnrolled);
    this.isGraduateAssistant=isGraduateAssistant;
    this.graduateAssistantType=graduateAssistantType;
    this.coursesEnrolled=coursesEnrolled;
}
public GraduateStudent(String studentName,  int studentID, boolean isEnrolled, boolean isGraduateAssistant, int coursesEnrolled){
    super(studentName,studentID,isEnrolled);
    this.isGraduateAssistant=isGraduateAssistant;
    this.coursesEnrolled=coursesEnrolled;
}
    
    /**
     * @return the 
     */
    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }
    
    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }
    
     /**
     * @return the PayableAmount
     */
    
    @Override
    public double getPayableAmount(){
        if(this.isGraduateAssistant==true){
            double t=this.getCREDITS_PER_COURSE(); 
            double credTaken=t*coursesEnrolled;
            double f = this.getPER_CREDIT_FEE();
            double tf = f*credTaken;
            tf=tf+ADDITIONAL_FEES;
                if(graduateAssistantType.equals("full")) {
                    return ADDITIONAL_FEES;
                }
                else if (graduateAssistantType.equals("half")){ 
                    tf=f*credTaken;
                    tf=tf/2;
                    tf=tf+ADDITIONAL_FEES;
                    return tf;
                    
                }
                else{
                    return tf;
                }
        }
        else {
            double t=this.getCREDITS_PER_COURSE(); 
            double credTaken=t*coursesEnrolled;
            double f = this.getPER_CREDIT_FEE();
            double tf = f*credTaken;
            tf=tf+ADDITIONAL_FEES;
            this.graduateAssistantType="";
            return tf;
        } 
    }
        
    
     
    @Override
    public String toString(){
        return super.toString() + "\nGraduate assistant: " + this.isGraduateAssistant + "\nGraduate assistant type: " + this.graduateAssistantType + "\nCourses enrolled: "+ this.coursesEnrolled + "\nPayable amount: " + getPayableAmount();
    }
       
        

    
}



