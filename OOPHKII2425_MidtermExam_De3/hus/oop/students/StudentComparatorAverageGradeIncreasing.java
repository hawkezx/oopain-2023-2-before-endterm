package hus.oop.students;

public class StudentComparatorAverageGradeIncreasing implements StudentComparator {
    @Override
    public int compare(Student left, Student right) {
        return Double.compare(left.getAverageGrade(), right.getAverageGrade());
    }
}
