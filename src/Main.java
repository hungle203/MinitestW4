import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final StudentManager studentManager = new StudentManager();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Student student = studentManager.createStudent(scanner);
                    studentManager.addStudent(student);
                    break;
                case 2:
                    System.out.println("Nhập vào mã sinh viên muốn sửa");
                    int idEdit = scanner.nextInt();
                    System.out.println(studentManager.editStudent(idEdit));
                    break;
                case 3:
                    System.out.println("Nhập vào mã sinh viêm muốn tìm");
                    int idSearch = scanner.nextInt();
                    ArrayList<Student> students = studentManager.searchById(idSearch);
                    System.out.println(students);
                    break;
                case 4:
                    System.out.println("Nhập vào mã sinh viên muốn xóa");
                    int idDelete = scanner.nextInt();
                    ArrayList<Student> studentsDelete = studentManager.deleteStudentById(idDelete);
                    System.out.println(studentsDelete);
                    break;
                case 5:
                    studentManager.sortAvg();
                    break;
                case 6:
                    studentManager.findMaxAvgPoint();
                    break;
                case 7:
                    studentManager.writeFile(studentManager.getStudent(),StudentManager.PATH_NAME);
                    break;
                case 8:
                    ArrayList<Student> students = studentManger.readFile(StudentManger.PATH_NAME);
                    students.forEach(System.out::println);
                    break;

            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("----- Menu ------");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Sửa sinh viên theo mã");
        System.out.println("3. Tìm kiếm sinh viên theo mã");
        System.out.println("4. Xóa sinh viên theo mã");
        System.out.println("5. In ra danh sách được sắp sếp theo điểm trung bình");
        System.out.println("6. Sinh viên có điểm cao nhất");
        System.out.println("7. Ghi file");
        System.out.println("8. Đọc file");
        System.out.println("0. Exit");
        System.out.println("Nhập lựa chọn");
    }

}
