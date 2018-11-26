package by.bsu.mark.action;

import java.util.OptionalDouble;

import by.bsu.mark.entity.Group;
import by.bsu.mark.entity.Student;

public class Action {
	/**
	 * Calculates avarage grade for passed student.
	 */
    public double getStudentAvg(Student student) {
        OptionalDouble average = student.getMarks().stream().mapToDouble(a -> a).average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }

    public double getGroupAvg(Group group) {
        double groupAvarage = 0;
        for (Student student : group.getStudentList()) {
            OptionalDouble studentAvarage = student.getMarks().stream().mapToDouble(a -> a).average();
            groupAvarage += studentAvarage.isPresent() ? (studentAvarage.getAsDouble() / group.getStudentList().size())
                    : 0;

        }
        return groupAvarage;
    }
}
