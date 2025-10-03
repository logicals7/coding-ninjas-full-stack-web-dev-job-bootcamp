package com.Krishan.CodingNinjas.Coding.Ninjas.Application;

import org.springframework.stereotype.Component;

/**
 * Two beans of the same Instructor type exists - JavaInstructor & SpringInstructor.
 * Giving the bean name as id to @Component to qualify the right bean when autowired in PaidCourse.
 */
@Component("javaInstructor")
public class JavaInstructor implements Instructor {
    String name;
    String age;

    public void init(){
        System.out.println("Java Instructor bean has been created");
    }

    public void destroy(){
        System.out.println("Java Instructor bean has been destroyed");
    }


    @Override
    public void setInstructorDetails(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String takeClass() {
        return "Hi my name is " + this.name + " and I will be your Java instructor";
    }
}
