# Project2-Java
Project #2 - Computer Programming II

Create a program that will calculate and display the fee amount to be paid by students at the university. You will calculate the average fee paid by UG students, Graduate students and Online students. You will also print out the count of UG students who received a scholarship and Graduate students who received an assistantship.

Your Task:
You need to write a program that adheres to the following inheritance diagram. UML diagrams are given for each class along with additional information regarding methods.

# # StudentFees Class:
As you can see StudentFees, is an abstract class (italicized) with one abstract method, getPayableAmount(). The getPayableAmount() method should return the total payable amount.

UGStudent class:

# # UGStudent members
-hasScholarship – true if he received a scholarship
-scholarshipAmount – total amount the student received as a scholarship for one term
-coursesEnrolled – number of courses student is enrolled for that term
-getPayableAmount() – Total fee amount student has to pay, this is the sum of the tuition fee and the additional fee. Deduct the scholarship amount from the total fee if there is any.

Tuition fee amount is calculated by following the below steps:

Firstly, find the number of courses students are enrolled in.
Calculate the total no of credits the user is enrolled in by multiplying it with the given CREDITS_PER_COURSE constant.
Finally, multiply the total no of credits calculated in the above step with the PER_CREDIT_FEE constant.

# # GraduateStudent members
-coursesEnrolled - number of courses student enrolled for that term
-isGraduateAssistant - true, if he is a graduate assistant
-graduateAssistantType – graduate assistant type (full or half)
-getPayableAmount () – Total fee amount student has to pay. This is the sum of the tuition fee and the additional fee. Graduate assistantship amount is deducted from the total fee if there is any.

Tuition fee is calculated similarly as UGStudent class.

Graduate assistantship amount is calculated based on the assistantship type, if it is a full assistantship then the full tuition fee is waived and if it is half assistantship then half of the tuition fee is waived.

# # OnlineStudent class:

OnlineStudent members
noOfMonths – number of months student is enrolled for.
-getPayableAmount(): The total fee amount student has to pay. This is calculated by multiplying the MONTHLY_FEE constant by the number of months the student is enrolled for.



Main Program:
Your main method should demonstrate the use of polymorphism.

Instantiate an array of StudentFees objects to hold data read from an input file
You will need only one array of StudentFees objects. For example, suppose there were 12 total students consisting of 6 UG students, 4 graduate students, and 2 Online students. You should not use three separate arrays.
-Example: 
StudentFees [] students = new StudenFees[12];
Array students would hold all 12 To add a new UG student to the student array:
students[index] = new UGStudent (param1, ..., param6);
Likewise, to add a new graduate student to the students array:
students[index] = new GraduateStudent (param1, ... , param6);
-Open the input file and read in the student data, saving the data into the array of StudentFees objects
-Close the input file
-Use a loop to display the list of student’s data saved in the array.
-Calculate and display average of UG students fee, number of students who got scholarship, total no of courses enrolled by all UG students.
-Calculate and display average of graduate student’s fee, number of students who got graduate assistantship, total number of courses enrolled by graduate students.
-Calculate and display average of online student’s fee.
Input Data: 

The file input.csv provided in the repo contains information about Undergraduate students, graduate students, and online students. You may assume that the data will always be in the order Undergraduate students, graduate students, and online students.  Each record for the following student is in the following format:

undergraduate student: id, name, enrolled, courses enrolled, scholarship, scholarship amount
graduate student: id, name, enrolled, courses enrolled, graduate assistantship, graduate assistantship type.
online student: id, name, enrolled, courses enrolled, number of months enrolled.
Ask the user to enter the following information: number of undergraduate students (5), number of graduate staff (4) and number of online students (3)

Note: Students not enrolled will have zero payable amount and not be included in the details (average, number of courses, etc).
