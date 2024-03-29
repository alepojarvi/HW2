package hw2;
import static hw2.ConstantValues.*;

public class Degree {
	
	private static final int MAX_COURSES = 50;
	private int count;
	private String degreeTitle = NO_TITLE;
	private String titleOfThesis = NO_TITLE;
	private StudentCourse[] myCourses;
	
	public Degree() {
		this.myCourses = new StudentCourse[MAX_COURSES];
        this.count = 0;
	}
	
	public StudentCourse[] getCourses() {
		return myCourses;
	}
	public void addStudentCourses(StudentCourse[] courses) {
		if (courses != null) {
			for (StudentCourse course : courses) {
				addStudentCourse(course);
			}
		}
	}
	public boolean addStudentCourse(StudentCourse course) {
		if (course == null) {
			return false;
		}
		if (count >= MAX_COURSES) {
			return false;
		}
		this.myCourses[count] = course;
		this.count++;
            return true;
	}
	public String getDegreeTitle() {
		return degreeTitle;
	}
	public void setDegreeTitle(String degreeTitle) {
	    if (degreeTitle != null) {
	        this.degreeTitle = degreeTitle;
	    }
	}
	public String getTitleOfThesis() {
		return titleOfThesis;
	}
	public void setTitleOfThesis(String titleOfThesis) {
		if (titleOfThesis != null) {
	        this.titleOfThesis = titleOfThesis;
	    }
	}
	public double getCreditsByBase(char base) {
		double sumCredits = 0.0;
		for (StudentCourse course : myCourses) {
			if (isCourseCompleted(course)) {
				char courseBase = course.getCourseBase();
				if (course != null && courseBase == base) {
					sumCredits += course.getCredits();
				}
			}
		}
		return sumCredits;
	}
	public double getCreditsByType(final int courseType) {
		double sumCredits = 0.0;
		for (StudentCourse course : myCourses) {
			if (isCourseCompleted(course)) {
				int type = course.getCourseType();
				if (course != null && type == courseType) {
					sumCredits += course.getCredits();
				}
			}
		}
		return sumCredits;
	}
	public double getCredits() {
		double sumCredits = 0.0;
		for (StudentCourse course : myCourses) {
			if (course != null && isCourseCompleted(course)) {
				//System.out.println(course);
				sumCredits += course.getCredits();
			}
		}
		return sumCredits;
	}
	private boolean isCourseCompleted(StudentCourse c) {
		if (c != null) {
			return c.isPassed();			
		}
		else
			return false;
	}
	public void printCourses() {
		for (int i = 0; i< count; i++) {
			if (myCourses[i] != null) {
				System.out.println("\t" + (i+1) + ". " + myCourses[i]);
			}
		}
	}
	@Override
	public String toString() {	
		return "Degree [Title: \"" + degreeTitle + "\" (courses: " + count + ")\n\tThesis title: \""+ titleOfThesis + "\"";
	}
}
