import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students : ");
        int count = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[count];
        String name = ""; String id = ""; double gpa =0;
        for(int i = 0; i < students.length; i++){
            System.out.println("Enter student " + i + " name");
            name = sc.nextLine();
          
            System.out.println("Enter student " + i + " id");
            id = sc.nextLine();
            
            System.out.println("Enter student " + i + " gpa");
            gpa = sc.nextDouble();
            students[i] = new Student(id,name,gpa);
            sc.nextLine();
        }
        try {
            FileWriter writer= new FileWriter("out.txt", true);
            for(int i = 0; i < count ; i++){
                writer.write(students[i].toString());
                writer.write("\n");
            }
            writer.close();
            System.out.println("sucessfully wrote");
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("error");
            e.printStackTrace();
        }
        sc.close();
    }
}