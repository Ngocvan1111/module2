package ss10_dsa_list.extra_excercise_1.service.impl;

import ss10_dsa_list.extra_excercise_1.model.Teacher;
import ss10_dsa_list.extra_excercise_1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    public void addNew() {
        Teacher teacher = this.getInfoStudent();
        teacherList.add(teacher);
        System.out.println("Thêm mới ok!!!");

    }

    public void display() {
        if (teacherList.size() > 0) {
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        } else {
//            System.out.println("Danh sách trống: ");
            throw new IllegalArgumentException("Danh sách Trống +++ size = 0");
        }
    }

    public void remove() {
        if (teacherList.size() > 0) {
            System.out.println("Nhập mã Giẩng viên cần xóa: ");
            String codeRemove = scanner.nextLine();
            for (int i = 0; i < teacherList.size(); i++) {
                if (teacherList.get(i).getCode().equals(codeRemove)) {
                    teacherList.remove(i);
                }
            }
        } else {
            System.out.println("Danh sách trống: ");
            throw new IllegalArgumentException("Danh sách Trống +++ size = 0");
        }


    }

    @Override
    public void research() {
        System.out.println("Nhập tên giảng viên bạn muốn tìm ");
        String teacherName = scanner.nextLine();
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().contains(teacherName)) {
                System.out.println("Đây có phải là tên bạn muốn tìm ?");
                System.out.println(teacherList.get(i));
                break;
            }

        }


    }

    public Teacher getInfoStudent() {
        System.out.println("Nhập mã Giảng viên: ");
        String code = scanner.nextLine();
        System.out.println("Nhập tên Giảng viên: ");
        String teacherName = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String birthday = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String tempGender = scanner.nextLine();
        String gender;
        if (tempGender.equals("Nam") || tempGender.equals("nam")) {
            gender = "Nam";
        } else if (tempGender.equals("Nữ") || tempGender.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "Thứ 3";
        }
        System.out.println("Nhập chuyên môn: ");
        String major = scanner.nextLine();
        Teacher teacher = new Teacher(code, teacherName, birthday, gender, major);
        return teacher;
    }

    public void addData() {
        teacherList.add(new Teacher("id221", "Nguyễn Thị Ánh", "06/12/1995", "Nữ", "Math"));
        teacherList.add(new Teacher("id211", "Nguyễn Thị Huyền", "06/12/1995", "Nữ", "Music"));
        teacherList.add(new Teacher("id233", "Nguyễn Thị Quỳnh", "06/12/1995", "Nữ", "Art"));
        teacherList.add(new Teacher("id234", "Nguyễn Thị Tâm", "06/12/1995", "Nữ", "English"));
    }
}
