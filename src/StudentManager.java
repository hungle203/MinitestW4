import java.awt.geom.QuadCurve2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
    public static final String PATH_NAME = "src/Student.csv";

    ArrayList<Student> students;
    Scanner scanner = new Scanner(System.in);

    public StudentManager() {
        this.students = readFile(PATH_NAME);
    }
    public ArrayList<Student> getStudent() {
        return students;
    }

    public Student createStudent(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên");
        String name = scanner.nextLine();
        System.out.println("Nhập vào tuổi");
        int age = scanner.nextInt();
        System.out.println("Nhập vào điểm toán");
        double math = scanner.nextDouble();
        System.out.println("Nhập vào điểm lý");
        double rea = scanner.nextDouble();
        System.out.println("Nhập vào điểm hóa");
        double che = scanner.nextDouble();
        students.add(new Student(name, age, math, rea, che));
        writeFile(students,PATH_NAME);
        System.out.println("AddStudent have name = \" + name + \"Successfully");
        return null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student editStudent(int id) {
        Student studentUpdate = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentUpdate = student;
            }
        }
        if (studentUpdate != null) {
            int index = students.indexOf(studentUpdate);
            System.out.println("Nhập vào tên sinh viên mới");
            String name = scanner.nextLine();
            studentUpdate.setName(name);
            System.out.println("Nhập vào tuổi mới");
            int age = scanner.nextInt();
            studentUpdate.setAge(age);
            System.out.println("Nhập vào điểm toán mới");
            double math = scanner.nextDouble();
            studentUpdate.setMathScores(math);
            System.out.println("Nhập vào điểm lý mới");
            double rea = scanner.nextDouble();
            studentUpdate.setPointOfReason(rea);
            System.out.println("Nhập vào điểm hóa mới");
            double che = scanner.nextDouble();
            studentUpdate.setPointChemistry(che);
            scanner.nextLine();

            students.set(index, studentUpdate);
            writeFile(students,PATH_NAME);
            System.out.println("Update student have name = \" + name + \" successfully!");
            return studentUpdate;

        }
        return null;
    }

    public ArrayList<Student> searchById(int id) {
        ArrayList<Student> students1 = new ArrayList<>();
        for (Student s : students) {
            if (s.getId() == id) {
                students1.add(s);
            }
        }
        return students1;
    }

    public ArrayList<Student> deleteStudentById(int id) {
        ArrayList<Student> students2 = new ArrayList<>();
        for (Student student : students) {
            if (student.getId() == id) {
                students2.add(student);
                students.removeAll(students2);
            }
            if (students2 != null) {
                writeFile(students,PATH_NAME);
                System.out.println("Delete student have name = \" + name + \" successfully!");
            }
        }
        return students2;
    }

    public Student findMaxAvgPoint() {
        double maxAvg = 0;
        for (Student student : students) {
            if (maxAvg < student.avg()) {
                maxAvg = student.avg();
            }
        }
        for (Student student : students) {
            if (student.avg() == maxAvg) {
                System.err.println(student);
            }
        }
        return null;
    }

    public void sortAvg() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.avg() - o2.avg() > 0) {
                    return -1;
                } else if (o1.avg() - o2.avg() < 0) {
                    return 1;
                }
                return 0;
            }
        });
    }

    public void writeFile(ArrayList<Student> students, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Student student : students) {
                bufferedWriter.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getMathScores() + student.getPointOfReason() + "," + student.getPointChemistry() + "\n");

            }
            bufferedWriter.close();
            System.out.println("Ghi file thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> readFile(String path) {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(PATH_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                students.add(new Student(strings[0], Integer.parseInt(strings[1]), Double.parseDouble(strings[2]), Double.parseDouble(strings[3]), Double.parseDouble(strings[4])));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }


}
