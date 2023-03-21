package example;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;
    private List<String> possibleAnswers;
    private List<Answer> answers;

    public Question(String text, List<String> possibleAnswers) {
        this.text = text;
        this.possibleAnswers = possibleAnswers;
        this.answers = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

}
