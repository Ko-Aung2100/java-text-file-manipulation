public class Student {
    private String id;
    private String fullName;
    private double gpa;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public Student(){

    }
    public Student(String s){
        String[] arr = s.split(" ");
        this.id = arr[1];
        this.fullName= arr[2];
        this.gpa = Double.parseDouble(arr[0]);
    }
    public Student(String id, String fullName, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
    }
    @Override
    public String toString() {
        return " " + id + " " + fullName + " " + gpa;
    }
    
}
