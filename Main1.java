import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
            String id = "";
            String name = " ";
            double gpa = 0;
            reader1 = new BufferedReader(new FileReader("out.txt"));
            Student[] students = new Student[count];
            int i = 0;
            String line1 = reader1.readLine(); // Move this line outside the loop
            while (line1 != null) {

                String[] arr = line1.split(" ");
                id = arr[0];
                name = arr[1];
                gpa = Double.parseDouble(arr[2]);
                students[i] = new Student(id, name, gpa);
                i++;
                line1 = reader1.readLine();
            }
            final double  AGpa = 3.50;
            final double  BGpa = 2.50;
            final double  CGpa = 2.00;
            int countA = 0;
            int countB = 0;
            int countC = 0;
            int countf = 0;
            for (Student student : students) {
                if (student.getGpa() >= AGpa) {
                    countA++;
                }
                if (AGpa > student.getGpa() && student.getGpa() >= BGpa) {
                    countB++;
                }
                if (BGpa > student.getGpa() && student.getGpa() >= CGpa) {
                    countC++;
                }
                if (student.getGpa() < CGpa) {
                    countf++;
                }
            }
            reader1.close();
            Student[] studentsA = new Student[countA];
            Student[] studentsB = new Student[countB];
            Student[] studentsC = new Student[countC];
            Student[] failedStudents = new Student[countf];
            int a = 0; int b = 0; int c = 0; int f = 0;
            for (Student student : students) {
                if (student.getGpa() >= AGpa) {
                    studentsA[a] = new Student(student.getId(),student.getFullName(),student.getGpa());
                    a++;
                }
                if (AGpa > student.getGpa() && student.getGpa() >= BGpa) {
                    studentsB[b] = new Student(student.getId(),student.getFullName(),student.getGpa());
                    b++;
                }
                if (BGpa > student.getGpa() && student.getGpa() >= CGpa) {
                    studentsC[c] = new Student(student.getId(),student.getFullName(),student.getGpa());
                    c++;
                }
                if (student.getGpa() < CGpa) {
                    failedStudents[f] = new Student(student.getId(),student.getFullName(),student.getGpa());
                    f++;
                }
            }
            writeToFile(studentsA, "classA.txt");
            writeToFile(studentsB, "classB.txt");
            writeToFile(studentsC, "classC.txt");
            writeToFile(failedStudents, "faileStudents.txt");

        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }
    public static void writeToFile(Student[] students,String fileName){
        try {
            FileWriter writer= new FileWriter(fileName);
            for(int i = 0; i < students.length ; i++){
                writer.write(students[i].toString());
                writer.write("\n");
            }
            writer.close();
            System.out.println("sucessfully wrote to " + fileName);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
