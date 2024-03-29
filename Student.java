package hw2;
import static hw2.ConstantValues.*;

import java.time.Year;
import java.util.Random;

public class Student {

	private String firstName = NO_NAME;
	private String lastName = NO_NAME;
	private int id;
	private int startYear = Year.now().getValue();
	private int graduationYear;
	private Degree degree;
	private String birthDate = NO_BIRTHDATE;
	
	public Student() {	
		this.id = getRandomId();
		this.degree = new Degree();
	}
	public Student(String lname, String fname) {
		setLastName(lname);
		setFirstName(fname);
		this.id = getRandomId();
		this.degree = new Degree();
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if (lastName != null) {
			this.lastName = lastName;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(final int id) {
		if (id > 0 && id <= 100)
			this.id = id;
	}
	public int getstartYear() {
		return startYear;
	}
	public void setstartYear(final int startYear) {
		if (startYear > 2000 && startYear <= Year.now().getValue()) {
			this.startYear = startYear;
		}
	}
	public int getGraduationYear() {
		return graduationYear;
	}
	public String setGraduationYear(final int graduationYear) {
		if (!canGraduate()) {
			return "Check amount of required credits";			
		}
		else {
			if (graduationYear < startYear ||  graduationYear > 2024)
				return "Check graduation year";
			else {
				this.graduationYear = graduationYear;
				return "Ok";
			}
		}
	}
	public void setDegreeTitle(String dName) {

		if (this.degree != null && dName != null) {
			this.degree.setDegreeTitle(dName);
		}
	}
	public boolean addCourse(StudentCourse course) {
		if (course != null) {
			this.degree.addStudentCourse(course);
			return true;
		}
		else return false;
	}
	public int addCourses(StudentCourse[] courses) {
		if (courses == null) {
            return 0;
        }
        int addedCourses = 0;
        for (StudentCourse course : courses) {
            if (course != null) {
                this.degree.addStudentCourse(course);
                addedCourses++;
            }
        }
        return addedCourses;
	}
	public void printCourses() {
		 degree.printCourses();
	}
	public void printDegree() {
		System.out.println(degree.toString());
		//System.out.println(degree.getCredits());
	}
	public void setTitleOfThesis(String title) {
		this.degree.setTitleOfThesis(title);
	}
	public String getBirthDate() {
		return birthDate;
	}
	public String setBirthDate(String personId) {
		if (personId == null) {
			return "No change";
		}
		else {
			PersonID personID = new PersonID();
			String vastaus = personID.setPersonID(personId);
			if ("Ok".equals(vastaus)) {
				this.birthDate = personID.getBirthDate();
			}
		}
		return birthDate;
	}
	public boolean hasGraduated() {
		if (graduationYear >= startYear && graduationYear <= 2024) {
			return true;
		}
		else return false;
	}
	private boolean canGraduate() {
		if (degree.getCredits() >= BACHELOR_CREDITS) {
			if (degree.getDegreeTitle() != NO_TITLE) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	public int getStudyYears() {
		if (hasGraduated())
			return (graduationYear - startYear);
		else
			return (Year.now().getValue() - startYear);
	}
	private int getRandomId() {
		Random rgen = new Random();
		return (rgen.nextInt(MAX_ID)+1);
	}
	@Override
	public String toString() {
		if (hasGraduated()) {
			return "Student id: " + id +"\n\tFirstName: " + firstName + ", LastName: " + lastName
				+ "\n\tDate of birth: " + birthDate
				+ "\n\tStatus: The student has graduated in " + graduationYear 
				+ "\n\tStartYear: " + startYear + " (studies lasted for " + getStudyYears() + " years)" 
				+ "\n\tCredits: " + degree.getCredits()
				+ "\n\t\tTotal credits completed (" + degree.getCredits() + "/180.0)"
				+ "\n\t\tTitle of Thesis: \"" + degree.getTitleOfThesis() + "\""
				+ "\n";
		}
		else {
			return "Student id: " + id +"\n\tFirstName: " + firstName + ", LastName: " + lastName
					+ "\n\tDate of birth: " + birthDate
					+ "\n\tStatus: The student has not graduated, yet" 
					+ "\n\tStartYear: " + startYear + " (studies lasted for " + getStudyYears() + " years)" 
					+ "\n\tCredits: " + degree.getCredits()
					+ "\n\t\tTotal credits completed (" + degree.getCredits() + "/180.0)"
					+ "\n\t\tTitle of Thesis: \"" + degree.getTitleOfThesis() + "\""
					+ "\n";
		}
	}
}
