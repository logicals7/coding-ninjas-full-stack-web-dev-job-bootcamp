package com.Krishan.CodingNinjas.Coding.Ninjas.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * If you want something to change on runtime, the object type given to you should be different.
 * Suppose we want to finalize the bean on runtime, whether we need the java or spring instructor bean,
 * In that case we need to add the @Scope annotation to decide if it will be singleton or prototype.
 * In our case the PaidCourse bean should be Prototyped. For java & spring, we need objects separately.
 * To dynamically inject the bean at runtime, we need to create two beans here of Instructor type as javaInstructor & springInstructor.
 */
@Component
@Scope("prototype")
public class PaidCourse implements Course{
    String courseName;

    /**
     * as soon as spring sees any instance variable with @autowired, it checks for the type.
     * so, what type of userList is in our case?
     * it is of type UserList which is an interface we have created.
     * UserList interface has been implemented by one class - SimpleUserList.
     * So spring will automatically inject the valur of SimpleUserList into that instance variable.
     *
     * what @autowired does is -
     * it takes the interface of the class & will automatically injects into whatever class or interface you have given.
     *
     * if we don't use a @Qualifier for the Instructor. There exists two beans of same type - springInstructor & javaInstructor.
     * Now spring doesn't know which bean to qualify. So throws an error.
     */
    @Autowired
    UserList userList;
    Instructor courseInstructor;

    //creating two beans
    @Autowired @Qualifier("javaInstructor")
    Instructor javaInstructor;

    @Autowired @Qualifier("springInstructor")
    Instructor springInstructor;

    /**
     * //earlier we were doing DI using constructor.
     * //now we don't need it because there are better ways to do DI using @autowired
     * public PaidCourse(Instructor instructor, UserList userList) {
     *         this.courseInstructor = instructor;
     *         this.userList = userList;
     *     }
     */

    @Override
    public void setCourseDetail(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public UserList getUserList() {
        return this.userList;
    }

    @Override
    public Instructor getInstructor() {
        return this.courseInstructor;
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }

    //dynamically sets the instructor
    public void setInstructor(String instructorType){
        if(instructorType == "spring")
            this.courseInstructor = this.springInstructor;
        if (instructorType == "java")
            this.courseInstructor = this.javaInstructor;
    }
}
