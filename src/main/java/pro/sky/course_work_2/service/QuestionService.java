package pro.sky.course_work_2.service;

import pro.sky.course_work_2.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
    int getSize();

    Question findQuestion(Question question);
}
