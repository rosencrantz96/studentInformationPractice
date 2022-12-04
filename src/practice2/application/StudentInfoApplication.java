package practice2.application;

import practice2.school.report.GenerateGradeReport;
import practice2.utils.Define;
import practice2.school.Score;
import practice2.school.School;
import practice2.school.Student;
import practice2.school.Subject;

public class StudentInfoApplication {
	School goodSchool = School.getInstance(); // 학교를 생성 
	Subject korean; // 국어 과목 
	Subject math; // 수학 과목 
	GenerateGradeReport gradeReport = new GenerateGradeReport(); // 성적 

	public static void main(String[] args) {
		StudentInfoApplication test = new StudentInfoApplication(); // 객체 생성
		
		test.createSubject(); // 과목을 생성한 후
		test.createStudent(); // 학생을 입학시킨다 
		
		String report = test.gradeReport.getReport(); // GenerateGradeReport에 접근해서 getReport메소드 실행 
		System.out.println(report);
		
	}

	private void createSubject() {
		korean = new Subject("국어", Define.KOREA); // 국어 과목 객체 생성
		math = new Subject("수학", Define.MATH); // 수학 과목 객체 생성
		
		// 학교에 과목을 넣어준다 
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
		
	}

	private void createStudent() {
		// 학생 객체 생성
		Student student1 = new Student(181213, "박지은", korean);
		Student student2 = new Student(181518, "차슬기", math);
		Student student3 = new Student(171230, "이현욱", korean);
		Student student4 = new Student(171255, "임지연", korean);
		Student student5 = new Student(171590, "김채현", math);
		
		//  학교에 등록
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
		goodSchool.addStudent(student3);
		goodSchool.addStudent(student4);
		goodSchool.addStudent(student5);
		
		// 수강 신청
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);
		
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);
		
		// 과목별 점수 추가 (addScoreForStudent메소드)
		addScoreForStudent(student1, korean, 95); // 학생 정보와 점수를 하나씩 넣어준다. 
		addScoreForStudent(student1, math, 56);
		
		addScoreForStudent(student2, korean, 95);
		addScoreForStudent(student2, math, 98);
		
		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math, 88);
		
		addScoreForStudent(student4, korean, 89);
		addScoreForStudent(student4, math, 95);
		
		addScoreForStudent(student5, korean, 83);
		addScoreForStudent(student5, math, 56);
	}

	private void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point); // score 객체 생성 (학생 학번을 불러오고, 과목과 포인트를 갖는다)
		student.addSubjectScore(score); // 점수를 하나씩 넣어준다. 
	}

}
