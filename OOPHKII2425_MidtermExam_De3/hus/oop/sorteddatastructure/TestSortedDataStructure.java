package hus.oop.sorteddatastructure;

import java.util.Random;

public class TestSortedDataStructure {
    public static void main(String[] args) {
        testSortedArrayList();
        testSortedLinkedList();
        /* TODO
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test theo format:
              Tên test:
              Kết quả chạy chương trình.

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_SortedDataStructure>.txt (Ví dụ, NguyenVanA_123456_SortedDataStructure.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_SortedDataStructure>.zip (Ví dụ, NguyenVanA_123456_SortedDataStructure.zip),
          nộp lên classroom.
         */
    }

    public static void testSortedArrayList() {
        System.out.println("Test SortedArrayList:");
        MySortedList list = new MySortedArrayList();
        Random rand = new Random();
        int n = rand.nextInt(11) + 20;
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(91) + 10;
            list.add(value);
            System.out.println(list);
        }

        int testValue = rand.nextInt(91) + 10;
        System.out.println("Contains " + testValue + "? " + list.contains(testValue));
        if (list.contains(testValue)) {
            System.out.println("Index: " + list.binarySearch(testValue));
        }
        /* TODO
         - Sinh ngẫu nhiên ra 1 số tự nhiên nằm trong đoạn [20, 30], lưu giá trị và biến n.
         - Sinh ngẫu nhiên ra n số tự nhiên nằm trong đoạn [10, 100], cho vào SortedArrayList.
             - In ra danh sách các số tự nhiên theo định dạng [a1, a2, ... an] trên 1 dòng.
               Mỗi lần thêm phần tử vào in ra danh sách các phần tử trên 1 dòng.
             - Sinh ngẫu nhiên ra các số tự nhiên, test kiểm tra xem giá trị đó có nằm trong list hay không,
               nếu có chỉ số của nó trong danh sách là gì.
         */
    }

    public static void testSortedLinkedList() {
        System.out.println("Test SortedLinkedList:");
        MySortedList list = new MySortedLinkedList();
        Random rand = new Random();
        int n = rand.nextInt(11) + 20;
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(91) + 10;
            list.add(value);
            System.out.println(list);
        }

        int testValue = rand.nextInt(91) + 10;
        System.out.println("Contains " + testValue + "? " + list.contains(testValue));
        if (list.contains(testValue)) {
            System.out.println("Index: " + list.binarySearch(testValue));
        }
        /* TODO
         - Sinh ngẫu nhiên ra 1 số tự nhiên nằm trong đoạn [20, 30], lưu giá trị và biến n.
         - Sinh ngẫu nhiên ra n số tự nhiên nằm trong đoạn [10, 100], cho vào SortedLinkedList.
             - In ra danh sách các số tự nhiên theo định dạng [a1, a2, ... an] trên 1 dòng.
               Mỗi lần thêm phần tử vào in ra danh sách các phần tử trên 1 dòng.
             - Sinh ngẫu nhiên ra các số tự nhiên, test kiểm tra xem giá trị đó có nằm trong list hay không,
               nếu có chỉ số của nó trong danh sách là gì.
         */
    }
}
