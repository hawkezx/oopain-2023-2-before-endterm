package hus.oop.students;

public class StudentComparatorAverageGradeDecreasing implements StudentComparator {
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(right.getAverageGrade(), left.getAverageGrade());
    }
}
