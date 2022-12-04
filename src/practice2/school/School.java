package practice2.school;

import java.util.ArrayList;

public class School {
	private static School instance = new School(); // 학교 객체는 instance 하나만 생성할 수 있게 만들어주기! 
	
	private static String SCHOOL_NAME = "Good School"; // 학교 이름! 
	private ArrayList<Subject> subjectList = new ArrayList<Subject>(); // 학교 개설 과목 
	private ArrayList<Student> studentList = new ArrayList<Student>(); // 학교 등록 학생 
	
	private School() {} // 싱글톤은 생성자 private! 
	
	public static School getInstance() {
		if (instance == null) {
			instance = new School();
		}
		return instance;
	}
	
	// 학생 입학
	public void addStudent(Student student) {
		studentList.add(student);
	}
	// 학생 리스트 출력 
	public ArrayList<Student> getStudentList() {
		return studentList;
	} 
	
	// 과목 개설
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	// 과목 리스트 출력 
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
}
