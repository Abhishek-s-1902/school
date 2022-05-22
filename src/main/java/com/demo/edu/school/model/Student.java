package com.demo.edu.school.model;

public class Student {
	String id;
	String name;
	
	public Student() {	
	}
	
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public final boolean equals(Object o) {
		if (o == this)
	        return true;
	    if (!(o instanceof Registration))
	        return false;
	    Student other = (Student)o;
	    boolean idEquals = (this.id == null && other.id == null)
	            || (this.id != null && this.id.equals(other.id));
	    boolean nameEquals = (this.name == null && other.name == null)
        || (this.name != null && this.name.equals(other.name));
	    
	    return idEquals && nameEquals;
	}
	
	@Override
	public final int hashCode() {
	    int result = 17;
	    if (id != null) {
	        result = 31 * result + id.hashCode();
	    }
	    if (name != null) {
	        result = 31 * result + name.hashCode();
	    }
	    return result;
	}
	
}
