package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Survey {
    private String title;
    private String topic;
    private String description;
    private List<Question> questions;

    private List<Candidate> candidates;

    public Survey(String title, String topic, String description) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        // Check if the question is unique
        for (Question q : questions) {
            if (q.getText().equals(question.getText())) {
                throw new IllegalArgumentException("Question already exists in survey");
                //System.out.println("Question already exists in survey");
            }
        }
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }


    public boolean validate() {
        if (questions.size() < 10 || questions.size() > 40) {
            return false;
        } else {
            return true;
        }
    }

    public Map<String, String> findMostGivenAnswer() {
        Map<String, Integer> answerCount = new HashMap<>();
        for (Question question : questions) {
            for (String answer : question.getPossibleAnswers()) {
                answerCount.put(answer, answerCount.getOrDefault(answer, 0) + 1);
            }
        }
        Map<String, String> result = new HashMap<>();
        for (Question question : questions) {
            String mostGivenAnswer = "";
            int maxCount = 0;
            for (String answer : question.getPossibleAnswers()) {
                if (answerCount.get(answer) > maxCount) {
                    mostGivenAnswer = answer;

                    maxCount = answerCount.get(answer);
                }
            }
            result.put(question.getText(), mostGivenAnswer);
        }
        return result;
    }

    public Map<String, Map<String, Integer>> getSurveyResult() {
        Map<String, Map<String, Integer>> surveyResult = new HashMap<>();
        for (Question question : questions) {
            Map<String, Integer> questionResult = new HashMap<>();
            for (String answer : question.getPossibleAnswers()) {
                questionResult.put(answer, 0);
            }
            for (Answer answer : question.getAnswers()) {
                if (answer.getSelectedAnswer() != null) {
                    questionResult.put(answer.getSelectedAnswer(), questionResult.get(answer.getSelectedAnswer()) + 1);
                }
            }
            surveyResult.put(question.getText(), questionResult);
        }
        return surveyResult;
    }

    public List<Answer> getCandidateAnswers(Candidate candidate) {
        List<Answer> candidateAnswers = new ArrayList<>();
        for (Question question : questions) {
            for (Answer answer : question.getAnswers()) {
                if (answer.getCandidate().equals(candidate)) {
                    candidateAnswers.add(answer);
                }
            }
        }
        return candidateAnswers;
    }

    public Candidate getMostActiveCandidate() {
        Map<Candidate, Integer> candidateCount = new HashMap<>();
        for (Question question : questions) {
            for (Answer answer : question.getAnswers()) {
                candidateCount.put(answer.getCandidate(), candidateCount.getOrDefault(answer.getCandidate(), 0) + 1);
            }
        }
        Candidate mostActiveCandidate = null;
        int maxCount = 0;
        for (Map.Entry<Candidate, Integer> entry : candidateCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostActiveCandidate = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostActiveCandidate;
    }
}