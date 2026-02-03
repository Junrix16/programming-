public class Student {
    //Attributes
    private String name;
    private int age;
    private String course;
    
    // Constructor to initialize the student object
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
    
    // Method to display the student information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println();
    }
    
    // Main method to create objects
    public static void main(String[] args) {
        // Creating two Student objects with different values
        Student student1 = new Student("Jhonrix Colipano", 18, "BSIT");
        Student student2 = new Student("Jeanessa Tabacon", 18, "BSBA");
        
        // lastly is to Display the student information
        System.out.println("Student Information");
        student1.displayInfo();
        
        System.out.println("Student Information");
        student2.displayInfo();
    }
}