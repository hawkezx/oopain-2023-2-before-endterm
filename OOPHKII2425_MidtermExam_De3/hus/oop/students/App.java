package hus.oop.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                // Parse dữ liệu từ chuỗi
                String id = dataList.get(0).trim();
                String lastName = dataList.get(1).trim();
                String firstName = dataList.get(2).trim();
                int yearOfBirth = Integer.parseInt(dataList.get(3).trim());
                double mathsGrade = Double.parseDouble(dataList.get(4).trim());
                double physicsGrade = Double.parseDouble(dataList.get(5).trim());
                double chemistryGrade = Double.parseDouble(dataList.get(6).trim());

                // Tạo đối tượng Student bằng Builder Pattern
                Student student = new Student.StudentBuilder(id)
                        .withLastname(lastName)
                        .withFirstname(firstName)
                        .withYearOfBirth(yearOfBirth)
                        .withMathsGrade(mathsGrade)
                        .withPhysicsGrade(physicsGrade)
                        .withChemistryGrade(chemistryGrade)
                        .build();

                // Thêm vào StudentManager (Singleton)
                StudentManager.getInstance().append(student);

                /*
                TODO

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.

                Chú ý:
                - Các đội tượng Student không thể được tạo trực tiếp ở đây do hàm dựng là private,
                  các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                  Student newStudent = new Student.StudentBuilder(id).
                    .withLastname(lastName)
                    .withFirstname(firstName)
                    ...
                    .build();

                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                  và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
                */
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortStudentsByName();
        testSortAverageGradeIncreasing();
        testSortAverageGradeDecreasing();
        testFilterPassStudents();
        testFilterFailureStudents();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "data\\students.csv";
        readListData(filePath);
    }

    /*
     * Test in ra danh sách các sinh viên theo thứ tự đọc vào ban đầu.
     * Mỗi sinh viên trên một dòng, theo format được định nghĩa trong hàm toString() của Student.
     */
    public static void testOriginalData() {
        System.out.println("Original Data:");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < StudentManager.getInstance().numberOfStudents(); i++) {
            students.add(StudentManager.getInstance().studentAt(i));
        }
        StudentManager.print(students);
    }

    public static void testSortStudentsByName() {
        System.out.println("Sorted by Name:");
        List<Student> students = StudentManager.getInstance().sortStudentsByName();
        StudentManager.print(students);
    }

    public static void testSortAverageGradeIncreasing() {
        System.out.println("Sorted by Average Grade Increasing:");
        List<Student> students = StudentManager.getInstance().sortAverageGradeIncreasing();
        StudentManager.print(students);
    }

    public static void testSortAverageGradeDecreasing() {
        System.out.println("Sorted by Average Grade Decreasing:");
        List<Student> students = StudentManager.getInstance().sortAverageGradeDecreasing();
        StudentManager.print(students);
    }

    public static void testFilterPassStudents() {
        System.out.println("Pass Students:");
        List<Student> students = StudentManager.getInstance().filterPassStudents();
        StudentManager.print(students);
    }

    public static void testFilterFailureStudents() {
        System.out.println("Failure Students:");
        List<Student> students = StudentManager.getInstance().filterFailureStudents(100); // or any large enough number
        StudentManager.print(students);
    }
}
