class Professor extends EmployeeImpl {
    private String name;
    private float salary;

    public Professor(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }
}
