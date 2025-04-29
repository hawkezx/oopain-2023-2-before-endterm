package hus.oop.students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private List<Student> studentList;

    private StudentManager() {
        studentList = new ArrayList<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void append(Student student) {
        studentList.add(student);
    }

    public void add(Student student, int index) {
        studentList.add(index, student);
    }

    public void remove(int index) {
        studentList.remove(index);
    }

    public Student studentAt(int index) {
        return studentList.get(index);
    }

    public int numberOfStudents() {
        return studentList.size();
    }

    public List<Student> sortStudentsByName() {
        List<Student> sorted = new ArrayList<>(studentList);
        sorted.sort((s1, s2) -> s1.compareTo(s2));  // dùng compareTo từ StudentComparable
        return sorted;
    }

    public List<Student> sortAverageGradeIncreasing() {
        List<Student> sorted = new ArrayList<>(studentList);
        sorted.sort(new StudentComparatorAverageGradeIncreasing()::compare);
        return sorted;
    }

    public List<Student> sortAverageGradeDecreasing() {
        List<Student> sorted = new ArrayList<>(studentList);
        sorted.sort(new StudentComparatorAverageGradeDecreasing()::compare);
        return sorted;
    }

    public List<Student> filterPassStudents() {
        return studentList.stream()
                .filter(s -> s.getMathsGrade() > 4.0 && s.getPhysicsGrade() > 4.0 &&
                        s.getChemistryGrade() > 4.0 && s.getAverageGrade() > 5.0)
                .collect(Collectors.toList());
    }

    public List<Student> filterFailureStudents(int howMany) {
        return studentList.stream()
                .filter(s -> s.getMathsGrade() < 4.0 || s.getPhysicsGrade() < 4.0 ||
                        s.getChemistryGrade() < 4.0 || s.getAverageGrade() < 5.0)
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student country : studentList) {
            idOfStudents.append(country.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
