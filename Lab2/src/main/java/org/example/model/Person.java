package org.example.model;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Overview general pentru persoane, teachers si students
 */

public class Person {
    protected String firstName;
    /**
     * Am folosit protected pentru ca: voi accesa campul asta doar in subclase care mostenesc Person.
     */
    protected String lastName;
    protected LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
/*    public String toString() {
        return getFullName() + " (Birth Date: " + dateOfBirth + ")";
    }*/
    public String toString(){
        return getFullName();
    }
}
