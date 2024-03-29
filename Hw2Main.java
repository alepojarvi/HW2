package hw2;
//import java.time.Year;

public class Hw2Main {
	
	public static void main(String[] args) {

		Student student = new Student();
		
		Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies ", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);
		
        StudentCourse studentCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studentCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studentCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studentCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studentCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studentCourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse studentCourse10 = new StudentCourse(course10, 'A', 2021); 
        StudentCourse studentCourse11 = new StudentCourse(course11, 'f', 2022);
		
        StudentCourse[] studentCourses = {
                studentCourse1, studentCourse2, studentCourse3, studentCourse4, studentCourse5,
                studentCourse6, studentCourse7, studentCourse8, studentCourse9, studentCourse10,
                studentCourse11
        };
        
        System.out.println(course4.getCredits());
        System.out.println(studentCourse4.getCredits());
        System.out.println(studentCourses[3]);
        System.out.println(studentCourses[3].getCredits());
        student.setDegreeTitle("Bachelor of Science");
        student.setTitleOfThesis("Bachelor thesis title");       
        student.addCourses(studentCourses);
        student.setstartYear(2001);
        student.setFirstName("Donald");
		student.setLastName("Duck");
		
		System.out.println(student);
		student.printDegree();

		//System.out.println(student.addCourses(studentCourses));
		//for (StudentCourse course : studentCourses) {
		//	System.out.println(course);
		//}
		System.out.println();
		
		
	/*Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.00, true);
	System.out.println(course1);
	StudentCourse course11 = new StudentCourse(course1, 'F', 2019);
	System.out.println(course11);
	System.out.println();
	System.out.println(Year.now().getValue());
	PersonID birthDate = new PersonID();
	System.out.println(birthDate.setPersonID("112299-123K"));*/

	}
}
