package extra_exercise.service.impl;

import extra_exercise.exception.DuplicateIDException;
import extra_exercise.model.Student;
import extra_exercise.service.IStudentService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        studentList.add(new Student(1, "Thanh", "1993", "man", "c05", 5));
        studentList.add(new Student(2, "Huan", "1995", "man", "c05", 6));
        studentList.add(new Student(3, "Ty", "2000", "man", "c05", 7));
        studentList.add(new Student(4, "Nam", "2001", "man", "c05", 8));
    }

    /**
     * creater :Nguyễn Văn phúc
     * thêm học sinh mới vào danh sách
     */
    @Override
    public void addStudent() {
        Student student = infoStudent();
        studentList.add(student);
        System.out.println("them moi thanh cong! ");
    }

    /**
     * xóa học sinh khỏi danh sách
     */
    @Override
    public void removeStudent() {
        System.out.print("moi ban nhap id can xoa: ");
        int idRemove = 0;
        while (true) {
            try {
                idRemove = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phai nhap so");
            }
        }
        boolean isFlag = false;
        for (Student student : studentList) {
            if (student.getId() == idRemove) {
                System.out.println(" Ban muon xoa hay khong?\n" +
                        "1. co\n" +
                        "2. khong");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());
                if (chooseYesNo == 1) {
                    studentList.remove(student);
                    System.out.println("da xoa thanh cong!");
                }
                isFlag = true;
                break;
            }
        }
        if (!isFlag) {
            System.out.println("khong tim thay!");
        }
    }

    /**
     * hiển thị danh sách học sinh
     */
    @Override
    public void disPlayAllStudent() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    /**
     * tìm kiếm học sinh trong danh sách theo id
     */

    @Override
    public void findStudentById() {
        System.out.print("nhap id muon tim: ");
        int idFind = 0;
        while (true) {
            try {
                idFind = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phai nhap so");
            }
        }
        boolean isFlag = false;
        for (Student student : studentList) {
            if (student.getId() == idFind) {
                System.out.println(student);
                isFlag = true;
                break;
            }
        }
        if (!isFlag) {
            System.out.println("=====Khong tim thay=====");
        }
    }

    /**
     * tìm kiếm học sinh theo tên
     */
    @Override
    public void findStudentByName() {
        boolean isExist = false;
        System.out.print("Moi nhap ten can tim: : ");
        String nameFind = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getName().contains(nameFind)) {
                System.out.println(student);
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println("=====Khong tim thay=====");
        }
    }

    @Override
    public void bubbleSortName() {
        boolean isSwap = true;
        for (int i = 0; i < studentList.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < studentList.size() - 1 - i; j++) {
                if ((studentList.get(j).getName().compareTo(studentList.get(j + 1).getName())) > 0) {
                    Collections.swap(studentList, j, j + 1);
                    isSwap = true;
                }
            }
        }
        // System.out.println(studentList);
    }

    public static Student infoStudent() {
        System.out.print("nhap id moi:");
        int newId;
        while (true) {
            try {
                newId = Integer.parseInt(scanner.nextLine());
                for (Student student : studentList) {
                    if (student.getId() == newId) {
                        throw new DuplicateIDException("id da co, vui long nhap lai!!");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phai nhap so");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("nhap name:");
        String name = scanner.nextLine();
        System.out.print("nhap ngay sinh:");
        String dateOfBirth = scanner.nextLine();
        System.out.print("nhap gioi tinh:");
        String gender = scanner.nextLine();
        System.out.print("nhap lop:");
        String classes = scanner.nextLine();
        System.out.print("nhap diem:");
        double point;
        while (true) {

            try {
                point = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phai nhap so");
            }
        }
        return new Student(newId, name, dateOfBirth, gender, classes, point);
    }
}
