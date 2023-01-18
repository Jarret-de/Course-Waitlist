import java.util.Random;
import java.util.Scanner;

public class CourseWaitlist {
    CircularDoublyLinkedList<WaitlistedStudent> waitlist = new CircularDoublyLinkedList<>();
    Scanner scanner = new Scanner(System.in);

    /*
     * Runs the waitlist through a specified course 20 times or until the waitlist is empty
     * Choosing one of four options with each run of the course
     */
    public void runCourse() {
        int courseRuns = 0, num;
        String name = "";
        Random rnd = new Random();
        while(!(waitlist.isEmpty()) && courseRuns < 21) {
            int random = rnd.nextInt(4);
            switch(random) {
                case 0:
                    System.out.println("System chose option 1: No addition to waitlist (status/days left may change) ");
                    progressCourse();
                    break;
                case 1:
                    System.out.println("System chose option 2: A new student joins the waitlist \nEnter student name and number: ");
                    name = userNameInput();
                    num = userNumInput();
                    addStudent(num, name);
                    progressCourse();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    System.out.println("System chose option 4: Checks if a student is waitlisted \nEnter student name and number: ");
                    name = userNameInput();
                    num = userNumInput();
                    WaitlistedStudent temp  = new WaitlistedStudent(num, name);
                    if (waitlist.contains(temp)) {
                        System.out.println("\nStudent Found\n");
                    }
                    else {System.out.println("\nStudent not found\n");}
                    progressCourse();
                    break;
            }
            courseRuns++;
        }
        System.out.println("Final Waitlist: ");
        System.out.println(toString());
    }

    //Removes first student from waitlist and sets the next student as permitted to register
    public void registerStudent() {
        WaitlistedStudent temp = ((WaitlistedStudent)waitlist.first());
        System.out.println("System chose option 3: " + temp.getName() + " registers");
        waitlist.removeFirst();
        ((WaitlistedStudent)waitlist.first()).setDays(2);
        ((WaitlistedStudent)waitlist.first()).setStatus();  
        System.out.println(toString());
    }

    //Checks if first student is put to the end of the waitlist and updates list accordingly
    public void progressCourse() {
        WaitlistedStudent temp = ((WaitlistedStudent)waitlist.first());
        if (temp == null) {return;}
        if (temp.getDays() == 1) {
            temp.setDays(0);
            temp.setStatus();
            waitlist.addLast(waitlist.first());
            waitlist.removeFirst();  
            ((WaitlistedStudent)waitlist.first()).setDays(2);
            ((WaitlistedStudent)waitlist.first()).setStatus();         
        }
        else {
            temp.setDays(temp.getDays() - 1);
        }
        System.out.println(toString());
    }

    //Adds a student to the list updating their details if necessary
    public void addStudent(int number, String name) {
        if (waitlist.isEmpty()) {
            WaitlistedStudent newWaitStudent = new WaitlistedStudent(number, name);
            waitlist.addLast(newWaitStudent);
            newWaitStudent.setStatus(); 
            newWaitStudent.setDays(2);
        }
        else {
            WaitlistedStudent newWaitStudent = new WaitlistedStudent(number, name);
            waitlist.addLast(newWaitStudent);
        }
    }

    //Catches non-String input
    public String userNameInput() {
        String name = "";
        name = scanner.next();
        if (name.equals(null) || name.isEmpty() || !(name instanceof String)) {
            System.out.println("Invalid Name: Try again");
            userNameInput();
        }
        return name;
    }

    //Catches non-int input
    public int userNumInput() {
        try {
            return scanner.nextInt();
        } catch (Exception e){
            System.out.println("Invalid Number: Try again");
            scanner = new Scanner(System.in);
            return userNumInput();
        }
    }

    @Override
    public String toString() {
        return waitlist.toString();
    }

}

