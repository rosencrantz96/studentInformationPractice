package practice2.school;

import java.util.ArrayList;
import practice1.utils.Define;


public class Subject {
	// 필드
	private String subjectName; // 과목명
	private int subjectId; // 과목코드
	private int gradeType; // 성적 산출 타입 
	private ArrayList<Student> studentList = new ArrayList<Student>(); // 학생 리스트
	
	// 생성자 
	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		gradeType = Define.AB_TYPE; // 학점 산출 기본 방식은 AB타입! 
	}
	
	public void register(Student student) {
		studentList.add(student); // 수강신청한 학생을 등록한다! 
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
