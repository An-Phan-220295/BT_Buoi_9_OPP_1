
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentInfo1 studentInfo = new StudentInfo1();
		studentInfo.testData();

		while(true)
		{
			studentInfo.menu();
			
			int num = studentInfo.inputIntegerNumber(0, 8, "Vui lòng lựa chọn chức năng:");
		
			switch (num) {
			case 1:
				System.out.println();
				studentInfo.inputInfo();
				break;
			case 2:
				System.out.println();
				studentInfo.listAverageScore();
				break;
			case 3:
				System.out.println();
				studentInfo.studentRank();
				break;
			case 4:
				System.out.println();
				studentInfo.highestaverageScore();
				break;
			case 5:
				System.out.println();
				studentInfo.under5ScoreStudent();
				break;
			case 6:
				System.out.println();
				studentInfo.findName();
				break;
			case 7:
				System.out.println();
				studentInfo.findId();
				break;
			case 8:
				System.out.println();
				studentInfo.removeStudent();
				break;
			case 0:
				System.exit(0);
				break;

			default:
				break;
			}
			System.out.println();
		}
	}
}
