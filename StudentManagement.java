import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            switch(choice){

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id,name,marks));

                    System.out.println("Student Added Successfully");
                    break;


                case 2:
                    if(students.isEmpty()){
                        System.out.println("No Records Found");
                    }
                    else{
                        for(Student s: students){
                            s.display();
                        }
                    }
                    break;


                case 3:
                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();

                    for(Student s: students){

                        if(s.getId()==updateId){

                            System.out.print("Enter New Name: ");
                            s.setName(sc.next());

                            System.out.print("Enter New Marks: ");
                            s.setMarks(sc.nextDouble());

                            System.out.println("Updated Successfully");
                        }
                    }
                    break;


                case 4:
                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();


                    students.removeIf(
                        s -> s.getId()==deleteId
                    );

                    System.out.println("Deleted Successfully");
                    break;


                case 5:
                    System.out.println("Thank You");
                    System.exit(0);


                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}