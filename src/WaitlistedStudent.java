public class WaitlistedStudent extends Student{
    private enum status {Waitlisted, PermittedToRegister};
    private status regStatus;
    private int daysLeftToReg;

    public WaitlistedStudent(int number, String name) {
        super(number, name);
        regStatus = status.Waitlisted;
        daysLeftToReg = 0;
    }

    public WaitlistedStudent(int number, String name, int days) {
        super(number, name);
        regStatus = status.Waitlisted;
        daysLeftToReg = days;
    }

    public String getStatus() {
        if (regStatus == status.PermittedToRegister) {return "PermittedToRegister";}
        return "Waitlisted";
    }

    public int getDays() {
        return daysLeftToReg;
    }

    public void setStatus() {
        if (regStatus == status.Waitlisted) {regStatus = status.PermittedToRegister;}
        else {regStatus = status.Waitlisted;}
    }

    public void setDays(int days) {
        daysLeftToReg = days;
    }

    @Override
    public String toString() {
        String str  = getNumber() + " : " + getName() + ", " + "Status: " + regStatus;
        str = (this.getDays() == 0) ? str : str + " Days left: " + daysLeftToReg; 
        return str;
    }
}
