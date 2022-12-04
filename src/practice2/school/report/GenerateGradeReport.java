package practice2.school.report;

import java.util.ArrayList;

import practice2.grade.*;
import practice2.school.*;
import practice2.utils.Define;

public class GenerateGradeReport {
	// 필드 
	School school = School.getInstance(); // school 싱글톤 객체 생성
	
	public static final String TITLE = "수강생 학점 \t\n";
	public static final String HEADER = "이름 | 학번 | 필수과목 | 점수 | \n";
	public static final String LINE = "-----------------------------\n";
	private StringBuffer buffer = new StringBuffer();
	
	// 메소드 
	public String getReport() { // 성적 산출 결과의 헤더, 바디, 푸터를 합쳐준다. 
		ArrayList<Subject> subjectList = school.getSubjectList(); // 만들어둔 과목 리스트를 불러온다. (국어, 수학) 
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		
		return buffer.toString();
		
	}

	private void makeHeader(Subject subject) {
		buffer.append(LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(TITLE);
		buffer.append(HEADER);
		buffer.append(LINE);
	}

	private void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList(); // 만들어둔 학생 리스트를 getStudentList로 받아온다 
		
		for(int i=0; i<studentList.size(); i++) { // for문으로 학생리스트를 불러오고 
			Student student = studentList.get(i); // student에 배열에서 하나씩 학생을 꺼내온다 
			buffer.append(student.getStudentName()); // 학생 이름을 찍고
			buffer.append("|"); // 구분선 찍어주기
			buffer.append(student.getStudentId());
			buffer.append("|"); // 구분선 찍어주기
			buffer.append(student.getMajorSubject().getSubjectName()); // 필수 과목을 찍고 
			buffer.append("|"); // 구분선 찍고 
			// 학생의 점수와 학점을 찍어줘야 함! 메소드 하나 새로 만들기
			getScoreGrade(student, subject.getSubjectId());
			buffer.append("\n"); // 줄바꿈
			buffer.append(LINE); // 라인을 찍어주며 몸통 마무리 
		
		}
	}
	// 학생의 수강과목 점수와 학점을 얻기
	private void getScoreGrade(Student student, int subjectId) {
		ArrayList<Score> scoreList = student.getScoreList(); // 학생 수강 과목의 점수 리스트를 불러오기 
		
		int majorId = student.getMajorSubject().getSubjectId(); // 해당 학생의 필수 과목 코드 
		
		// 성적 산출 타입을 알려줄 배열을 생성
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};
		for (int i=0; i<scoreList.size(); i++) {
			Score score = scoreList.get(i); // score에 해당 과목의 점수를 하나씩 넣어준다. 
			
			if (score.getSubject().getSubjectId() == subjectId) { // 우선 과목 코드가 같은지 확인하고 
				String grade; // 학점을 넣어줄 변수를 하나 선언한 뒤 
				if (score.getSubject().getSubjectId() == majorId) { // 필수 과목 코드와 같을 때 SAB 타입으로 점수 산출
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
				} else { // 일반 과목일 때 
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				}
				
				buffer.append(score.getPoint()); // 점수를 찍고
				buffer.append(":"); // 콜론을 찍고
				buffer.append(grade); // 학점을 찍고
				buffer.append("|"); // 구분선을 찍어준다. 
			}
		}
	}

	private void makeFooter() {
		buffer.append("\n"); // 줄바꿈으로 푸터 마무리~ 
	}
	
}
