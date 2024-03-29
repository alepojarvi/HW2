package hw2;
import static hw2.ConstantValues.*;

public class Course {
	
	private String name;
	private String courseCode;
	private char courseBase;
	private int courseType;
	private int period;
	private double credits;
	private boolean numericGrade;
	
	//konstruktorit
	public Course(){		
	}
	
	public Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade) {
		setName(name);
		setCourseCode(code, courseBase);
		setCourseType(type);
		setPeriod(period);
		setCredits(credits);
	}
			
	public Course(Course course) {
		this.name = course.getName();
		this.courseCode = course.getCourseCode();
		this.courseBase = course.getCourseBase();
		this.courseType = course.getCourseType();
		this.period = course.getPeriod();
		this.credits = course.getCredits();
		this.numericGrade = course.isNumericGrade();
	}
	//metodit
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		if (!name.isEmpty() && name != null) {
			this.name = name;
		}
	}
	public String getCourseTypeString() {
		if (courseType == 0) {
			return "Optional";
		}
		else;
			return "Mandatory";
		}
	public int getCourseType() {
		return courseType;		
	}
	public void setCourseType(final int type) {
		if (type == 0 || type == 1) {
			this.courseType = type;
		}
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(final int courseCode, char courseBase) {
		if (courseCode > 0 && courseCode < 1000000) {
			String base = String.valueOf(courseBase).toUpperCase();
			if (base.equals("A") || base.equals("P") ||base.equals("S")) {
				this.courseCode= String.valueOf(courseCode) + base;
			}
		}
	}
	public char getCourseBase() {
		return courseBase;
	}
	public int getPeriod() {
		return period;
	}	
	public void setPeriod(final int period) {
		if (period >= MIN_PERIOD && period <= MAX_PERIOD) {
			this.period = period;
		}
	}
	public double getCredits() {
		return credits;
	}
	private void setCredits(final double credits) {
		if (credits >= MIN_CREDITS && credits <= MAX_CREDITS) {
			this.credits = credits;
		}
	}
	public boolean isNumericGrade() {
		return numericGrade;
	}
	public void setNumericGrade(boolean numericGrade) {
		this.numericGrade = numericGrade;
	}
	@Override
	public String toString() {
		return "[" + courseCode + " (" + credits + " cr), \"" + name + "\". " + getCourseTypeString() + ", period: " + period + ".]";
	}


}
