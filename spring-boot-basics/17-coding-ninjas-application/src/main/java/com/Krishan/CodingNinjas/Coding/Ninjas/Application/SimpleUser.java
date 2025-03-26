package com.Krishan.CodingNinjas.Coding.Ninjas.Application;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SimpleUser implements User{
    String name;
    String age;
    String location;
    String collegeName;

    @Override
    public void setUserDetails(String name, String age, String location, String collegeName) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.collegeName = collegeName;
    }

    @Override
    public String getUserDetails() {
        return this.name + " age: " + this.age;
    }
}
