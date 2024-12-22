package pack1;

public class UserInfoBackend {
    private String name;
    private String surname;
    private int age;
    private String email;

    public void enterUserName(String name) {
        this.name = name;
    }

    public void enterSurname(String surname) {
        this.surname = surname;
    }

    public void enterAge(int age) {
        this.age = age;
    }

    public void enterEmail(String email) {
        this.email = email;
    }

    public String cancelOperation() {
        this.name = null;
        this.surname = null;
        this.age = 0;
        this.email = null;
        return "System Close";
    }

    public String getUserDetails() {
        return "Name: " + name + ", Surname: " + surname + ", Age: " + age + ", Email: " + email;
    }
}
