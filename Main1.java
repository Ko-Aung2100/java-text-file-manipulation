import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        BufferedReader reader, reader1;
        try {
            reader = new BufferedReader(new FileReader("out.txt"));
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                count++;
                line = reader.readLine();
            }
            reader.close();
            String id = ""; String name = " "; double gpa = 0;
            reader1 = new BufferedReader(new FileReader("out.txt"));
            Student[] students = new Student[count];
            int i = 0;
            String line1 = reader1.readLine(); // Move this line outside the loop
            while (line1 != null) {
              
               String[] arr = line1.split(" ");
               id = arr[0];
               name = arr[1];
               gpa = Double.parseDouble(arr[2]);
                students[i] = new Student(id,name,gpa);
                i++;
                line1 = reader1.readLine();
            }
            double AGpa = 3.50;
            double BGpa = 2.50;
            double CGpa = 2.00;
           for (Student student : students) {
               if( student.getGpa() >= AGpa) {
                    System.out.println("class A students : " + student.getFullName());
               }
               if(AGpa > student.getGpa() && student.getGpa() >= BGpa){
                    System.out.println("class B students : " + student.getFullName());
               }
               if(BGpa > student.getGpa() && student.getGpa() >= CGpa){
                System.out.println("class C students : " + student.getFullName());
               }
               if(student.getGpa() < CGpa){
                 System.out.println("failed students : " + student.getFullName());
               }
           }
            reader1.close();
          

        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }
}
