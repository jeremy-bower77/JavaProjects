/*************************************
* Programmer: jeremy-bower
* classID: jbower7692
* Lab5: WMU GPA-O-Tron
* CIS 2600: Business Application Programming
* Fall 2017
* Due date: 12/8/2017
* Date completed: 12/8/12
**************************************
* Program Explanation
* 
* This program is called lab5. In this program we ask for user input such as WIN
* number, first name, last name and GPA. All of this data is within a try block
* so all of the users entry's goes through multiple forms of exception handling.
* Once the user enters all of the data correctly it comes down to a pair of if
* statements. These if statements are used to organized which text file to be 
* written to based on their GPA. If their GPA is over 2.0 then they are written
* to the StudentsGoodStanding.txt file. If their GPA is under (2) then they are
* written to the StudentsAcademicProbation.txt. After that record is written to
* a text file it goes to the next try block. In this try block we pull all of 
* the data that was entered in both text files displaying them one by one 
* through a BufferedReader. Starting with the students in the 
* StudentsGoodStanding.txt file. Then it displays the students in the 
* StudentsAcademicProbation.txt file. Once all of the students are displayed the
* program ends.
* 
* Good explanation.
**************************************/
//=============================Watch the line==================================>
//This is the package that netbeans gave it.
package lab5;

/**
 *
 * @author jbower7692
 * 
 */

/*import java.nio.file.*;
import java.io.*; import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner; imports an interface that enable the development of 
input methods that can be used with any Java runtime environment.*/
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.*;

//Lab5 is the name of the class
public class StudentLists {

/*This line is the method header. Public is the access specifier. Static means 
that a method is accessible and usable even though no objects of that class 
exist. Void indicates that the main() method does not return any value when it
is ran. Main() is the name of the method. String[] is a class, and the brakets 
mean the argument to this method is an array of strings. Args is the identifier 
of the array of strings that the argument to the method.*/
    public static void main(String[] args) 
    {
        
        //These are the variables
        String firstName = "";
        String lastName = "";
        String winNum = "";
        String delimiter = ",";
        String theStudent = "";
        String[] theStudents = new String[3]; //we need one more.
        int winNumber = 0;
        final int WIN_LENGTH = 9;
        final int QUIT = 999;
        double studentGpa = 0.0;
        double gpaDifference = 0.0;
        final double ACADEMIC_PROBATION_LEVEL = 2.0;//good.
        final double MIN_GPA = 0.0;
        final double MAX_GPA = 4.0;
        
        
        /*Scanner input declares an object of type scanner with the chosen name
        input. The new Scanner(System.in) creates a Scanner object that is 
        connected to the System.in property. Which connects it to the default 
        input device.*/
        Scanner userInput = new Scanner(System.in);
        
        /*This displays the address.*/
        wmuAddress(); //OK
        
        /*This lines of code assigns the path of the file that we are writing 
        to. And if I were to change that to be funny/stupid I will get a zero.*/
        Path smartPeople = Paths.get("StudentsGoodStanding.txt");
        Path dumbPeople = Paths.get("StudentsAcademicProbation.txt");//HA
        
    /*This is the first try block in this program. In this try block we use a 
    seris of commands to gather the users input for Win #, their first name, 
    their last name, and their gpa. Then we will write it to the designated 
    files based on their GPA.*/
    try
    {
            
         /*This line of code is an OutputStream for the file that we are writing
        to. This also contains methods for performing output. The name of this 
        OutputStream is called output. The CREATE part of this opens the file if
        it exists or creates a new file if it does not. The APPEND alows 
        new data to be entered at the end of the file.*/
        OutputStream smartOutput = new BufferedOutputStream
                          (Files.newOutputStream(smartPeople, CREATE, APPEND));
        
        /*This line of code is an BufferWriter for the file that we are writing
        to. The name of this is called writer. BufferWriter means it can write 
        text to a character-output stream, buffering characters to provide for 
        writing of characters, arrays, and lines.*/
        BufferedWriter smartWriter = new BufferedWriter
                                          (new OutputStreamWriter(smartOutput));
        
        
        
        /*This line of code is an OutputStream for the file that we are writing
        to. This also contains methods for performing output. The name of this 
        OutputStream is called output. The CREATE part of this opens the file if
        it exists or creates a new file if it does not. The APPEND alows 
        new data to be entered at the end of the file.*/
        OutputStream dumbOutput = new BufferedOutputStream
                            (Files.newOutputStream(dumbPeople, CREATE, APPEND));
        
        /*This line of code is an BufferWriter for the file that we are writing
        to. The name of this is called writer. BufferWriter means it can write 
        text to a character-output stream, buffering characters to provide for 
        writing of characters, arrays, and lines.*/
        BufferedWriter dumbWriter = new BufferedWriter
                                           (new OutputStreamWriter(dumbOutput));
        
        /*These lines of code ask the user to "Please enter the student WIN 
        number: ". Then taking that user input assigning it to winNumber. Then
        takeing that win number and setting it to a string called winNum.*/
        System.out.print("\nPlease enter the student WIN number: ");
        winNumber = userInput.nextInt();
        winNum = String.valueOf(winNumber);//OK
        
         /*This line of code is a while loop that test the winNumber to see
        if it equals QUIT which is (999). If it is the program will end. If the
        winNumber is not QUIT then the program will continue.*/
         while(winNumber != QUIT)
         {
             
            /*This line of code is a while loop that test to see if the 
            string winNum is equal to the length of WIN_LENGTH which is (9).
            If it does not match the length of (9) then it will tell the user
            to enter the correct amount of numbers. After that it will ask the 
            user to reenter the student win number. If the winNum does eqaul the
            length of (9) then the program will continue.*/
            while(winNum.length() != WIN_LENGTH)//good
            {

            /*This line of code tells the user that they did not enter the right
            number of numbers needed for the winNum.*/
            System.out.println("\nWhoops! You did not enter the right amount"
                    + " of numbers.");    

        /*These lines of code ask the user to "Please enter the student WIN 
        number: ". Then taking that user input assigning it to winNumber. Then
        takeing that win number and setting it to a string called winNum.*/
            System.out.print("\nPlease enter the student WIN number: ");
            winNumber = userInput.nextInt();
            winNum = String.valueOf(winNumber);

            }
        
        /*This line of code asks the user to "Please enter the student's first
        name: ". Then it takes that user input and assigns it to firstName.*/
        System.out.print("\nPlease enter the student's first name: ");
        userInput.nextLine();
        firstName = userInput.nextLine();
        
        /*This line of code asks the user to "Please enter the student's last
        name: ". Then it takes that user input and assigns it to lastName.*/
        System.out.print("\nPlease enter the student's last name: ");
        lastName = userInput.nextLine();
        
        /*This line of code asks the user to "Please enter the student's GPA: ".
        Then it takes that user input and assigns it to the double studentGpa.*/
        
        //perhaps check for range
        System.out.print("\nPlease enter the student's GPA: ");
        studentGpa = userInput.nextDouble();
            
            
        /*This line of code is where we take all of the user input we 
        obtained and place it in the order we want. Starting with 
        winNumber then a comma then firstName then a comma then the 
        lastName with another comma then last the studentGpa. This then 
        then is converted to a string by assigning it to theStudent.*/
        theStudent = winNumber + delimiter + firstName + delimiter + lastName +
                delimiter + studentGpa;
        
            /*This line of code is what is known as an if statment. Which test 
            to see if studentGpa >= ACADEMIC_PROBATION_LEVEL and to see if 
            studentGpa <= MAX_GPA. If this if statement is true then it writes
            theStudent string with the smartWriter to the 
            StudentsGoodStanding.txt. If it is not true the program will go to
            the else if statement that is next.*/
            
            //OK.
            if(studentGpa >= ACADEMIC_PROBATION_LEVEL && studentGpa <= MAX_GPA)
            {
                
        /*This writes the string theStudent to the file we have been 
        working with.*/
        smartWriter.write(theStudent, 0, theStudent.length());
        
        /*This line of code is here to make sure that when we enter 
        new input from the user that it writes on a new line. So that 
        its not all on one line.*/
        smartWriter.newLine();
        
            }
        
        /*This line of code is what is known as an if statment. Which test 
        to see if studentGpa >= MIN_GPA and to see if 
        studentGpa < ACADEMIC_PROBATION_LEVEL. If this if statement is true then
        it writes theStudent string with the  dumbWriter to the 
        StudentsAcademicProbation.txt.*/
        else //we would have handled this test if we checked input
            if(studentGpa >= MIN_GPA && studentGpa < ACADEMIC_PROBATION_LEVEL)
            {
        
        /*This writes the string customer to the file we have been 
        working with.*/
        dumbWriter.write(theStudent, 0, theStudent.length());
        
        /*This line of code is here to make sure that when we enter 
        new input from the user that it writes on a new line. So that 
        its not all on one line.*/
        dumbWriter.newLine();
            }
        
        /*These lines of code ask the user to "Please enter the another student 
        WIN number or 999 to quit: ". Then if the user enters in a WIN number it 
        will take that user input assigning it to winNumber. Then takeing that 
        win number and setting it to a string called winNum. If the user types 
        in (999) then the program quits.*/   
        System.out.print("\nPlease enter the another student WIN number or 999 "
                + "to quit: ");
        winNumber = userInput.nextInt();
        winNum = String.valueOf(winNumber);
        
            }
         
         /*This line of code is know as writer flush. This is important 
        because any user input that is in the buffer will never be writen
        without this.*/
        smartWriter.flush();

        /*This line of code is what is known as a writer close this closes
        the file that we are writing to. This is important to have 
        because with out this we will not be able to write to the file again
        until it is closed.*/
        smartWriter.close();
        
        /*This line of code is know as writer flush. This is important 
        because any user input that is in the buffer will never be writen
        without this.*/
        dumbWriter.flush();

        /*This line of code is what is known as a writer close this closes
        the file that we are writing to. This is important to have 
        because with out this we will not be able to write to the file again
        until it is closed.*/
        dumbWriter.close();
//good.
    }
        
        /*This line of code is what is known as a Catch Block. Which is an block 
        of code that can handle an IOException that might be thrown by the try 
        that precceds it. Mistake is the name of the exception. If this 
        exception is caught then. It displays "Whoops! Something went wrong."*/
        catch(IOException mistake)
        {
         
            /*This line of code displays "Whoops! Something went wrong." if the
            previous exception is caught.*/
            System.out.println("Whoops! \nSomething went wrong."); 
            
        }
        
        /*This line of code is what is known as a Catch Block. Which is an block 
        of code that can handle an InputMismatchException that might be thrown 
        by the try that precceds it. Mistake is the name of the exception. If 
        this exception is caught then. It displays "Whoops! Something went 
        wrong. Please enter the correct data type."*/
        catch(InputMismatchException mistake)
        {

            /*This line of code displays "Whoops! Something went wrong. Please 
            enter the correct data type." when the user enters in the wrong 
            data type.*/
            System.out.println("Whoops! \nSomething went wrong. \nPlease enter "
                    + "the correct data type.");
            
        }
        
        /*This line of code is what is known as a Catch Block. Which is an block 
        of code that can handle an exception that might be thrown by the try 
        that precceds it. mistake is the name of the exception. This is a 
        general exception.*/
        catch(Exception mistake)//good catches
        {
            
            /*This line of code displays the actual exception that was thrown 
            that the general exception caught.*/
            System.out.println(mistake);
            
        }
        
        
    /*This is the second try block in this program. In this try block we use a 
    seris of commands to read theStudent String that has the students Win #, 
    their first name, their last name, and their gpa. And this try block will 
    also display every student that is on these text files.*/
    try
    {
     
        /*This line of code is what is known as an InputStream. It is called 
        smartInput. InputStream is used for an abstract class that contains 
        methods for performing input.*/
        InputStream smartInput = new BufferedInputStream
                                            (Files.newInputStream(smartPeople));
         
        /*This line of code is what is known as an BufferedReader. It is called
        smartReader. BufferedReader reads text from a character-inut stream,
        buffering characters to provide for efficient reading of characters,
        arrays, and lines.*/
        BufferedReader smartReader = new BufferedReader
                                            (new InputStreamReader(smartInput));
        
        /*This line of code is what is known as an InputStream. It is called 
        dumbInput. InputStream is used for an abstract class that contains 
        methods for performing input.*/
        InputStream dumbInput = new BufferedInputStream
                                            (Files.newInputStream(dumbPeople));
         
        /*This line of code is what is known as an BufferedReader. It is called
        dumbReader. BufferedReader reads text from a character-inut stream,
        buffering characters to provide for efficient reading of characters,
        arrays, and lines.*/
        BufferedReader dumbReader = new BufferedReader
                                            (new InputStreamReader(dumbInput));
        

         /*This line makes the output easyier to read*/
         System.out.println();

        /*This displays the good standing design.*/
        goodStanding(); //OK
         
         /*This line of code grabs the first line of theStudent for the 
         smartReader.*/
         theStudent = smartReader.readLine();
         
         /*This line of code is what is known as a while loop. It will run as 
         long as theStudent has some sort of data stored to it.*/
         while(theStudent != null)
         {
            
            /*This line of code uses split(delimiter) to seperate the user entry
            that is seperated by the delimiter. Then it takes that data and 
            feeds it into the array called theStudents.*/
            theStudents = theStudent.split(delimiter);

            /*This line of code assigns the winNumber to the first element in 
            position 0 in the array theStudents.*/
            winNumber = Integer.parseInt(theStudents[0]);
            
            /*This line of code assigns the firstName to the second element in 
            position 1 in the array theStudents.*/
            firstName = theStudents[1];
            
            /*This line of code assigns the lastName to the third element in 
            position 2 in the array theStudents.*/
            lastName = theStudents[2];
            
            /*This line of code assigns the studentGpa to the forth element in 
            position 3 in the array theStudents.*/
            studentGpa = Double.parseDouble(theStudents[3]);

            /*This line of code assigns the gpaDifference equal to studentGpa 
            minus ACADEMIC_PROBATION_LEVEL.*/
            gpaDifference = studentGpa - ACADEMIC_PROBATION_LEVEL;//good
            
            /*This line of code displays the WIN #, first name, last name, gpa,
            and the difference of gpa from the ACADEMIC_PROBATION_LEVEL. All of
            this data was saved on the StudentsGoodStanding.txt file.*/
            System.out.println("WIN #: " + winNumber + " | " + "Name: " + 
                    firstName + " " + lastName +  " | " + "GPA: " + studentGpa 
                    + " | " + "Exceeds by: " + gpaDifference);//deimal format

            
            /*This line of code will grab the last line of the document to make
            sure it is not left in the buffer and left out of the display.*/
            theStudent = smartReader.readLine();
         }
         
         /*This displays the probationary standing design.*/
         probationaryStanding();
         
         /*This line of code grabs the first line of theStudent for the 
         smartReader.*/
         theStudent = dumbReader.readLine();
         
         /*This line of code is what is known as a while loop. It will run as 
         long as theStudent has some sort of data stored to it.*/
         while(theStudent != null)
         {
            
            /*This line of code uses split(delimiter) to seperate the user entry
            that is seperated by the delimiter. Then it takes that data and 
            feeds it into the array called theStudents.*/
            theStudents = theStudent.split(delimiter);

            /*This line of code assigns the winNumber to the first element in 
            position 0 in the array theStudents.*/
            winNumber = Integer.parseInt(theStudents[0]);
            
            /*This line of code assigns the firstName to the second element in 
            position 1 in the array theStudents.*/
            firstName = theStudents[1];
            
            /*This line of code assigns the lastName to the third element in 
            position 2 in the array theStudents.*/
            lastName = theStudents[2];
            
            /*This line of code assigns the studentGpa to the forth element in 
            position 3 in the array theStudents.*/
            studentGpa = Double.parseDouble(theStudents[3]);
            
            /*This line of code assigns the gpaDifference equal to 
            ACADEMIC_PROBATION_LEVEL minus studentGpa.*/
            gpaDifference = ACADEMIC_PROBATION_LEVEL - studentGpa;

            /*This line of code displays the WIN #, first name, last name, gpa,
            and the difference of gpa from the ACADEMIC_PROBATION_LEVEL. All of
            this data was saved on the StudentsAcademicProbation.txt file.*/
            System.out.println("WIN #: " + winNumber + " | " + "Name: " + 
                    firstName + " " + lastName +  " | " + "GPA: " + studentGpa 
                    + " | " + "Falls short by: " + gpaDifference);

            
            /*This line of code will grab the last line of the document to make
            sure it is not left in the buffer and left out of the display.*/
            theStudent = dumbReader.readLine();
         }

        /*This line of code closes the smartReader*/
        smartReader.close(); 
         
        /*This line of code closes the dumbReader*/
        dumbReader.close();
        
    }
    
        /*This line of code is what is known as a Catch Block. Which is an block 
        of code that can handle an IOException that might be thrown by the try 
        that precceds it. Mistake is the name of the exception. If this 
        exception is caught then. It displays "Whoops! Something went wrong."*/
        catch(IOException mistake)
        {
         
            /*This line of code displays "Whoops! Something went wrong." if the
            previous exception is caught.*/
            System.out.println("Whoops! \nSomething went wrong."); 
            
        }
        
        /*This line of code is what is known as a Catch Block. Which is an block 
        of code that can handle an exception that might be thrown by the try 
        that precceds it. mistake is the name of the exception. This is a 
        general exception.*/
        catch(Exception mistake)
        {
            
            /*This line of code displays the actual exception that was thrown 
            that the general exception caught.*/
            System.out.println(mistake);
            
        }
    }
    /*This method is used for displaying the Western Michigan University address
    */
    public static void wmuAddress()
    {
        System.out.println("###################################" +
                           "\n### Western Michigan University ###" +
                           "\n########### GPA Checker ###########" + 
                           "\n####### 1903 W Michigan Ave #######" +
                           "\n####### Kalamazoo, MI 49008 #######" +
                           "\n###################################");
    }
    
    /*This method is used for displaying the Good Standing design.*/
    public static void goodStanding()
    {
        System.out.println("\n###################################" +
                           "\n########## Good Standing ##########" +
                           "\n###################################\n");
    }
    
    /*This method is used for displaying the Good Standing design.*/
    public static void probationaryStanding()
    {
        System.out.println("\n###################################" +
                           "\n###### Probationary Standing ######" +
                           "\n###################################\n");
    }

}

        
       //Overall nice work on this one. Perhaps a bit more input validation.
    

