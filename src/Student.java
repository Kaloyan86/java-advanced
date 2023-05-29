public class Student {

    private long id;
    private String firstName;
    private String lastName;
    private String phone;


    public Student() {
    }

    public Student(long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Student(long id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (!lastName.equals("")) {
            this.lastName = lastName;
        } else {
            System.out.println("Last name can't be empty!");
        }
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    void printFirstName() {
        System.out.println(firstName);
    }

   static String concatTwoStrings(String text1, String text2) {
        return text1 + text2;
    }
}
