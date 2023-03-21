package example;

public class Answer {
    private Candidate candidate;
    private String selectedAnswer;

    private Question question;

    public Answer(Candidate candidate, String selectedAnswer, Question question) {
        this.candidate = candidate;
        this.selectedAnswer = selectedAnswer;
        this.question = question;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public Question getQuestion() {
        return question;
    }
}
