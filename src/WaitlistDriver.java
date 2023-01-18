public class WaitlistDriver {  
    public static void main(String[] args) {
        CourseWaitlist waitlist = new CourseWaitlist();
        waitlist.addStudent(111111, "Jeff");
        waitlist.addStudent(222222, "Mary");
        waitlist.addStudent(333333, "Tim");
        waitlist.addStudent(444444, "Ollie");
        System.out.println("ACS-2947 Waitlist");
        waitlist.runCourse();
    }
}

