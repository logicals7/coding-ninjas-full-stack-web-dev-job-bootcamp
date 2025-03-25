package com.Krishan.CodingNinjas.Coding.Ninjas.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
    @Autowired @Qualifier("javaInstructor")
    Instructor courseInstructor;


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
}
