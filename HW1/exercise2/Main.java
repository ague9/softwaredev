public class Main {
    public static void main(String[] args) {
        // Create instances for all class types
        Professor professor = new Professor("John Smith", 5000);
        PhD phd = new PhD("Jane Doe", "Computer Science");
        Tutor tutor = new Tutor("Alice Johnson", "Mathematics");

        // Print their methods to the console
        System.out.println("Professor: " + professor.getName() + ", Salary: " + professor.getSalary());
        System.out.println("PhD: " + phd.getName() + ", Subject: " + phd.getSubject());
        System.out.println("Tutor: " + tutor.getName() + ", Subject: " + tutor.getSubject());
    }
}