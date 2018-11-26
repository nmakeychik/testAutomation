package by.bsu.mark.runner;

import by.bsu.mark.action.Action;
import by.bsu.mark.entity.Group;
import by.bsu.mark.entity.Student;

public class Runner {
    /**
     * Hard-coded student marks:
     */
    private static final int[] s1Marks = new int[] { 10, 9, 8, 7 };
    private static final int[] s2Marks = new int[] { 9, 8, 7, 6 };

    public static void main(String[] args) {
        Group g = new Group();

        Student s1 = new Student();
        Student s2 = new Student();

        for (Integer mark : s1Marks) {
            s1.addMark(mark);
        }

        for (Integer mark : s2Marks) {
            s2.addMark(mark);
        }

        g.addStudent(s1);
        g.addStudent(s2);

        Action action = new Action();
        System.out.println(String.format("Student 1 avarage mark is %2.3f", action.getStudentAvg(s1)));
        System.out.println(String.format("Student 2 avarage mark is %2.3f", action.getStudentAvg(s2)));
        System.out.println(String.format("Group avarage mark is %2.3f", action.getGroupAvg(g)));
    }
}
