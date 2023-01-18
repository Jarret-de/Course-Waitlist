public class Student {
    private int studentNumber;
    private String studentName;

    public Student(int number, String name) {
        studentNumber = number;
        studentName = name;
    }

    public int getNumber() {return studentNumber;}

    public String getName() {return studentName;}

    @Override
    public boolean equals(Object s) {
        if(!(s instanceof Student)) {return false;}
        Student temp = (Student)s;
        if (temp.getNumber() == studentNumber && temp.getName().equals(studentName)) {return true;}
        return false;
    }

    @Override
    public String toString() {
        return studentNumber + " : " + studentName + ", " + "Status: Waitlisted";
    }
}
