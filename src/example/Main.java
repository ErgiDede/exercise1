package example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("John", "Doe", "johndoe@example.com", "+1 555 123 4567"));
        candidates.add(new Candidate("Jane", "Doe", "janedoe@example.com", "+1 555 765 4321"));
        candidates.add(new Candidate("Bob", "Smith", "bobsmith@example.com", "+1 555 987 6543"));

        List<String> possibleAnswers = Arrays.asList("Agree", "Slightly Agree", "Slightly Disagree", "Disagree");

        Survey survey = new Survey("Sample Survey", "Java Programming", "A sample survey for Java programmers");

        // add questions
        survey.addQuestion(new Question("How familiar are you with Java?", possibleAnswers));
        survey.addQuestion(new Question("How often do you use Java?", possibleAnswers));
        survey.addQuestion(new Question("How important is Java in your job?", possibleAnswers));
        survey.addQuestion(new Question("How confident are you in your Java skills?", possibleAnswers));
        survey.addQuestion(new Question("How confident are you in your Java skills?", possibleAnswers));
        survey.addQuestion(new Question("test?", possibleAnswers));
        survey.addQuestion(new Question("test1?", possibleAnswers));
        survey.addQuestion(new Question("test2?", possibleAnswers));
        survey.addQuestion(new Question("test3?", possibleAnswers));
        survey.addQuestion(new Question("test4?", possibleAnswers));
        survey.addQuestion(new Question("test5?", possibleAnswers));
        survey.addQuestion(new Question("test6?", possibleAnswers));

        // add answers
        if (survey.validate()) {
            for (Candidate candidate : candidates) {
                for (Question question : survey.getQuestions()) {
                    int answerIndex = new Random().nextInt(question.getPossibleAnswers().size() + 1);
                    String selectedAnswer = answerIndex < question.getPossibleAnswers().size() ? question.getPossibleAnswers().get(answerIndex) : null;
                    Answer answer = new Answer(candidate, selectedAnswer, question);
                    question.addAnswer(answer);
                    candidate.addAnswer(answer);
                }
            }

            Map<String, Map<String, Integer>> surveyResult = survey.getSurveyResult();
            for (Map.Entry<String, Map<String, Integer>> questionResult : surveyResult.entrySet()) {
                System.out.println(questionResult.getKey() + ":");
                for (Map.Entry<String, Integer> answerResult : questionResult.getValue().entrySet()) {
                    System.out.println(answerResult.getKey() + ": " + answerResult.getValue());
                }
                System.out.println();
            }

            // print most given answer
            Map<String, String> mostGivenAnswer = survey.findMostGivenAnswer();
            for (Map.Entry<String, String> entry : mostGivenAnswer.entrySet()) {
                System.out.println("Most given answer for \"" + entry.getKey() + "\": " + entry.getValue());
            }
            System.out.println();

            // print candidate answers
            Candidate candidate = candidates.get(0);
            List<Answer> candidateAnswers = survey.getCandidateAnswers(candidate);

            System.out.println("Answers for candidate \"" + candidate.getFullName() + "\":");
            for (Answer answer : candidateAnswers) {
                System.out.println(answer.getQuestion().getText() + ": " + answer.getSelectedAnswer());
            }
            System.out.println();

            // print candidate who has taken the most surveys
            Candidate mostActiveCandidate = survey.getMostActiveCandidate();
            System.out.println("The most active candidate is \"" + mostActiveCandidate.getFullName() + "\"");
            System.out.println();

            // add/remove question to/from existing survey
            Question newQuestion = new Question("How often do you work with databases?", possibleAnswers);
            survey.addQuestion(newQuestion);
            survey.removeQuestion(newQuestion);
        } else {
            System.out.println("\"Survey must have between 10 and 40 questions\"");
        }

    }
}

