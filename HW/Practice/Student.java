public class Student {

    public String firstName;
    public String lastName;
    public int osis;
    public int age;
    public double gpa;

    public Student(String first, String last, int ID, int year){

        firstName = first;
        lastName = last;
        osis = ID;
        age = year;
        
    }

    public void printStudent(){
        System.out.println("Hello, my name is " + firstName + " " + lastName + " and I'm " + age + " years old. My student ID is " + osis + " not sure why you want to know that though.");
    }

    public void lowerGPA(int gpa){
        System.out.println(firstName + ", your original GPA is " + gpa + " and I'm gonna lower it to " + (gpa - 3) + " because you failed your last test.");
    }

    public void raiseGPA(int gpa){
        System.out.println(firstName + ", you're doing wonderfully in class this month! Therefore I'm going to raise your gpa from " + gpa + " to " + (gpa + 4) + ".");
    }



    public static  void main(String[]args){

        Student student1;
        
        student1 = new Student("Jack", "Zheng", 206174740, 17);

        student1.printStudent();
        student1.lowerGPA(92);
        student1.raiseGPA(87);
    }
}
