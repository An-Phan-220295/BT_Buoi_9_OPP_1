/*
 * Author: Phan Phúc An
 * Date: 22-05-2023
 * 
 * BT_Buổi 9_OPP:
 * Xây dựng chương trình cho phép người dùng nhập vào: Tên, Mã SV, điểm Toán, Lý Hóa. Thực hiện các nghiệp vụ dưới đây. 
	•Tính điểm trung bình từng sinh viên ( T + L + H)/3 
	•Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9<Giỏi<=8, 8<Khá<=7, <7<=6, <=5, còn lại Yếu.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentInfo1 {
	private String name;
	private String id;
	private double math;
	private double physics;
	private double chemistry;
	private List<StudentInfo1> list = new ArrayList<>();
	
	
	public StudentInfo1(String name, String id, double math, double physics, double chemistry) {
		this.name = name;
		this.id = id;
		this.math = math;
		this.physics = physics;
		this.chemistry = chemistry;
	}
	
	public void testData() {
		StudentInfo1 studentInfo1 = new StudentInfo1("Nguyễn Văn A", "13146002", 7.5, 3.5, 6.8);
		list.add(studentInfo1);
		StudentInfo1 studentInfo2 = new StudentInfo1("Nguyễn Văn B", "13146322", 9, 8.5, 10);
		list.add(studentInfo2);
		StudentInfo1 studentInfo3 = new StudentInfo1("Nguyễn Văn C", "13143522", 2, 4.5, 6.4);
		list.add(studentInfo3);
		StudentInfo1 studentInfo4 = new StudentInfo1("Phan Văn D", "12543522", 6, 4.5, 3.4);
		list.add(studentInfo4);
		StudentInfo1 studentInfo5 = new StudentInfo1("Trần Văn V", "12375522", 8.4, 5, 6);
		list.add(studentInfo5);
		StudentInfo1 studentInfo6 = new StudentInfo1("TRần Văn P", "12543492", 8, 3, 6.4);
		list.add(studentInfo6);
	}
	
	@Override
	public String toString() {
		return "StudentInfo1 [name=" + name + ", id=" + id + ", math=" + math + ", physics=" + physics + ", chemistry="
				+ chemistry + ", list=" + list + "]";
	}

	public StudentInfo1() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getPhysics() {
		return physics;
	}

	public void setPhysics(double physics) {
		this.physics = physics;
	}

	public double getChemistry() {
		return chemistry;
	}

	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}
	
	public double averageScore() {
		return (this.math+this.physics+this.chemistry)/3;
	}

	public void inputInfo() {
//		list = new ArrayList<>();
		int menu = 0;
		do {
			System.out.println("1. Thêm sinh viên.");
			System.out.println("2. Thoát.");
			menu = inputIntegerNumber(1, 2, "");
			
			switch (menu) {
			case 1:
				this.name = fillingRequesst("Vui lòng nhập tên sinh viên: ");
				this.id = fillingRequesst("Vui lòng nhập mã sinh viên: ");
				this.math = inputRealNumber(0, 10, "Vui lòng nhập điểm môn Toán: ");
				this.physics = inputRealNumber(0, 10, "Vui lòng nhập điểm môn Lý: ");
				this.chemistry = inputRealNumber(0, 10, "Vui lòng nhập điểm môn Hóa: ");
				System.out.println();
				
				StudentInfo1 studentInfo = new StudentInfo1(this.name, this.id, this.math, this.physics, this.chemistry);
				list.add(studentInfo);
				break;
			default:
				break;
			}
		} while (menu != 2);
	}
	
	public void listAverageScore() {
		for (StudentInfo1 studentInfo1 : list) {
			System.out.printf("Sinh viên: %-25s || MSSV: %-15s|| Điểm trung bình %s\n",studentInfo1.getName(),studentInfo1.getId(), studentInfo1.averageScore());
		}
	}
	
	public void studentRank() {
		for (StudentInfo1 studentInfo1 : list) {
			if (studentInfo1.averageScore() >= 9)
				System.out.printf("Sinh viên: %-25s || MSSV: %-15s || Xếp loại: Xuất Sắc \n",studentInfo1.getName(),studentInfo1.getId());
		
			if (studentInfo1.averageScore() < 9 && studentInfo1.averageScore() >= 8)
				System.out.printf("Sinh viên: %-25s || MSSV: %-15s || Xếp loại: Giỏi \n",studentInfo1.getName(),studentInfo1.getId());
				
			if (studentInfo1.averageScore() < 8 && studentInfo1.averageScore() >= 6)
				System.out.printf("Sinh viên: %-25s || MSSV: %-15s || Xếp loại: Khá \n",studentInfo1.getName(),studentInfo1.getId());
			
			if (studentInfo1.averageScore() < 6 && studentInfo1.averageScore() >=5)
				System.out.printf("Sinh viên: %-25s || MSSV: %-15s || Xếp loại: Trung bình \n",studentInfo1.getName(),studentInfo1.getId());
				
			if (studentInfo1.averageScore() <5)
				System.out.printf("Sinh viên: %-25s || MSSV: %-15s || Xếp loại: Yếu \n",studentInfo1.getName(),studentInfo1.getId());
		}
	}
	
	public void highestaverageScore() {
		double maxScore = list.get(1).averageScore(); 
		
		for (StudentInfo1 studentInfo : list) {
			if(studentInfo.averageScore() > maxScore)
				maxScore = studentInfo.averageScore();
		}
		System.out.println("Sinh viên có điểm trung bình cao nhất:");
		for (StudentInfo1 studentInfo : list) {
			if(studentInfo.averageScore() == maxScore)
				System.out.printf("Sinh viên: "+"%-25s || Điểm trung bình %s\n",studentInfo.getName(), studentInfo.averageScore());
		}	
	}
	
	public void under5ScoreStudent() {
		System.out.println("Danh sách sinh viên xếp loại yếu:");
		for (StudentInfo1 studentInfo : list) {
			if(studentInfo.averageScore() < 5)
				System.out.printf("Sinh viên: "+"%-25s || Điểm trung bình %s\n",studentInfo.getName(), studentInfo.averageScore());
		}	
	}
	
	public void findName() {
		int menu = 0;
		do {
			System.out.println("1. Tìm sinh viên.");
			System.out.println("2. Thoát.");
			menu = inputIntegerNumber(1, 2, "");
			
			switch (menu) {
			case 1:
				String name1 = fillingRequesst("Vui lòng nhập họ tên sinh viên cần tìm: ");
				int temp = 0;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getName().equals(name1)) {
						System.out.println(list.get(i).toString());
						temp++;
						}
				}
				if (temp == 0)
					System.out.print("Không tìm thấy sinh viên có tên "+ name1);
				break;

			default:
				break;
			}
		} while (menu != 2);
	}
	
	public void findId() {
		int menu = 0;
		do {
			System.out.println("1. Tìm sinh viên.");
			System.out.println("2. Thoát.");
			menu = inputIntegerNumber(1, 2, "");
			
			switch (menu) {
			case 1:
				String id = fillingRequesst("Vui lòng nhập mã số sinh viên cần tìm: ");
				int temp = 0;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getId().equals(id)) {
						System.out.println(list.get(i).toString());
						temp++;
						}
				}
				if (temp == 0)
					System.out.print("Không tìm thấy sinh viên có mã số "+ id);
				break;

			default:
				break;
			}
		} while (menu != 2);
	}
	
	public void removeStudent() {
		int menu = 0;
		do {
			System.out.println("1. Xóa sinh viên.");
			System.out.println("2. Thoát.");
			menu = inputIntegerNumber(1, 2, "");
			
			switch (menu) {
			case 1:
				String deleteId = fillingRequesst("Vui lòng nhập mã số của sinh viên cần xóa: ");
				int temp = 0;
				
				for (Iterator <StudentInfo1> iterator = list.iterator(); iterator.hasNext();) {
					StudentInfo1 studentInfo1 = (StudentInfo1) iterator.next();
					if (studentInfo1.getId().equals(deleteId)) {
						iterator.remove();
						System.out.println("Đã xóa.");
						temp++;
						}
				}
				
				if (temp == 0)
					System.out.print("Không tìm sinh viên có mã số này.");
				break;

			default:
				break;
			}
		} while (menu != 2);
	}
	
	public void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. Thêm sinh viên.");
		System.out.println("2. Tính điểm trung bình từng sinh viên.");
		System.out.println("3. Danh sách xếp loại sinh viên.");
		System.out.println("4. Sinh viên có điểm trung bình cao nhất.");
		System.out.println("5. Danh sách sinh viên yếu.");
		System.out.println("6. Tìm kiếm sinh viên theo tên.");
		System.out.println("7. Tìm kiếm sinh viên theo mã sinh viên.");
		System.out.println("8. Xóa sinh viên.");
		System.out.println("0. Thoát khỏi chương trình.");
	}
	
	public double inputRealNumber(double lowerLimit,double upperLimit, String Text) {
		Scanner scan = new Scanner(System.in);
		double number;
		while (true) {
			try {
				System.out.print(Text);
				number = scan.nextDouble();
				while (number < lowerLimit || number > upperLimit) {
					System.out.println("Vui lòng nhập một số trong khoản "+ lowerLimit+" đến "+upperLimit);
					number = scan.nextDouble();
				}
				break;
			} catch (InputMismatchException mme) {
				// TODO: handle exception
				System.out.println("Vui lòng nhập một số");
				scan.nextLine();
			}
		}
		return number;
	}
	
	public int inputIntegerNumber(int lowerLimit,int upperLimit, String Text) {
		Scanner scan = new Scanner(System.in);
		int number;
		while (true) {
			try {
				System.out.print(Text);
				number = scan.nextInt();
				while (number < lowerLimit || number > upperLimit) {
					System.out.println("Vui lòng nhập một số nguyên trong khoản "+ lowerLimit+" đến "+upperLimit);
					number = scan.nextInt();
				}
				break;
			} catch (InputMismatchException mme) {
				// TODO: handle exception
				System.out.println("Vui lòng nhập một số nguyên.");
				scan.nextLine();
			}
		}
		return number;
	}
	
	public String fillingRequesst(String announcement) {
		Scanner sc = new Scanner(System.in);
		System.out.print(announcement);
		String text = sc.nextLine();
		while(text.isEmpty()){
			System.out.println("Vui lòng không bỏ trống.");
			text = sc.nextLine();
		}
		return text;
	}
}
