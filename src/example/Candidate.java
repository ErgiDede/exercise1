package example;

import java.util.ArrayList;
import java.util.List;

public class Candidate {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Answer> answers;

    public Candidate(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.answers = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }



}
