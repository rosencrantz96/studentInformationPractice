package practice2.school;

import java.util.ArrayList;

public class Student {
	// 필드 
	private int studentId; // 학번
	private String studentName; // 학생 이름
	private Subject majorSubject; // 필수 과목 
	private ArrayList<Score> scoreList = new ArrayList<Score>(); // 점수 배열 
	
	// 생성자 
	public Student(int studentId, String studenName, Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studenName;
		this.majorSubject = majorSubject;
	}
	
	// 메소드
	public void addSubjectScore(Score score) {
		scoreList.add(score); // 배열 리스트에 점수를 넣어준다 
	}

	// getter, setter 
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	
}
