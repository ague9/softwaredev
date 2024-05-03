class Tutor extends StudentImpl {
    private String name;
    private String subject;

    public Tutor(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
}
