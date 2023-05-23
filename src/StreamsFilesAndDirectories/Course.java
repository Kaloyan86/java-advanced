package StreamsFilesAndDirectories;

import java.io.Serializable;

public class Course implements Serializable {

    String name;
    int students;

    public Course(String name, int students) {
        this.name = name;
        this.students = students;
    }
}
