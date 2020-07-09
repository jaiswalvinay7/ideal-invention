package com.javacodegeeks.example;

public class Person {

    private String personId;
    private String name;
    private int age;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public String toString() {
        return String.format("Person{personId='%s', name='%s',age='%s'}", personId, name, age);
    }
}
