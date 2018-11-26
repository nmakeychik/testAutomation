package by.bsu.mark.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity represents group of students.
 */
public class Group {
    private List<Student> students;

    public Group() {
        this.students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new RuntimeException("Null student provided");
        }
        this.students.add(student);
    }

    public List<Student> getStudentList() {
        return students;
    }
}
