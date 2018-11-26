package by.bsu.mark.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
	/**
	 * Maximal allowed grade.
	 */
    private static final int MAX_MARK = 10;
	/**
	 * Minimal allowed grade.
	 */
    private static final int MIN_MARK = 1;

    private List<Integer> marks;

    public Student() {
        this.marks = new ArrayList<Integer>();
    }

	/**
	 * Returns set of grades for this student.
	 */
    public void addMark(Integer mark) {
        if (mark > MAX_MARK || mark < MIN_MARK) {
            throw new RuntimeException("Wrong mark value provided");
        }
        marks.add(mark);
    }

    public List<Integer> getMarks() {
        return this.marks;
    }
}
