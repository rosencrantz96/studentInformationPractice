package practice2.school;

public class Score {
	// 필드
	private int studentId; // 학번
	private Subject subject; // 과목
	private int point; // 성적 
	
	// 생성자 
	public Score(int studentId, Subject subject, int point) {
		this.studentId = studentId;
		this.subject = subject;
		this.point = point;
	}
	
	
	@Override
	public String toString() {
		return "학번: " + this.studentId + ", " + subject.getSubjectName() + ":" + point;
	}

	// getter, setter 
	public int getStudentId() {
		return studentId;
	}

	
	// getter, setter 
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public Subject getSubject() {
		return subject;
	}



	public void setSubject(Subject subject) {
		this.subject = subject;
	}



	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}



	
	
}
