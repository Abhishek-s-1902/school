package com.demo.edu.school.model;

public class Registration {

	String studentId;
	String courseId;
	
	public Registration() {		
	}
	
	public Registration(String student, String course) {
		this.studentId = student;
		this.courseId = course;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}	
	
	
    public final boolean equals(Object o) {
		if (o == this)
	        return true;
	    if (!(o instanceof Registration))
	        return false;
	    Registration other = (Registration)o;
	    boolean studentEquals = (this.studentId == null && other.studentId == null)
	            || (this.studentId != null && this.studentId.equals(other.studentId));
	    boolean courseEquals = (this.courseId == null && other.courseId == null)
        || (this.courseId != null && this.courseId.equals(other.courseId));
	    
	    return studentEquals && courseEquals;
	}
	
	@Override
	public final int hashCode() {
	    int result = 17;
	    if (studentId != null) {
	        result = 31 * result + studentId.hashCode();
	    }
	    if (courseId != null) {
	        result = 31 * result + courseId.hashCode();
	    }
	    return result;
	}
}
