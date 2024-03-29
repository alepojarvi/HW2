package hw2;
import static hw2.ConstantValues.*;

import java.time.LocalDate;

public class StudentCourse extends Course{
	
	private Course course;
	private int gradeNum;
	private int yearCompleted;
	
	public StudentCourse() {
		
	}
	public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
		setCourse(course);
		setGrade(gradeNum);
		setYear(yearCompleted);
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = new Course(course);
	}
	public int getGradeNum() {
		return gradeNum;
	}
	protected void setGrade(int gradeNum) {
		if (checkGradeValidity(gradeNum)) {
			this.gradeNum = gradeNum;
			if (yearCompleted == 0) {
				this.yearCompleted = LocalDate.now().getYear();
			}
		}
	}
	private boolean checkGradeValidity(final int gradeNum) {
		return (gradeNum <= MAX_GRADE && gradeNum >= MIN_GRADE ) || gradeNum == GRADE_FAILED || gradeNum == GRADE_ACCEPTED;			
	}
	public boolean isPassed() {
		return (gradeNum != MIN_GRADE && gradeNum != GRADE_FAILED);			
	}
	public int getYear() {
		return yearCompleted;
	}
	public void setYear(final int year) {
		int currentYear = LocalDate.now().getYear();
		
		if (year > 2000 && year <= currentYear) {
			this.yearCompleted = year;
		}
	}	
	@Override
	public String toString() {
		if (gradeNum == 0) {			
			return course.toString() + " Year: " + yearCompleted + ", Grade: \"Not graded\".]";
		}
		else {return course.toString() + " Year: " + yearCompleted + ", Grade: " + gradeNum + ".]";
		}
		}
	}

