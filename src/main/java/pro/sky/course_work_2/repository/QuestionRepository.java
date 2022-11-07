package pro.sky.course_work_2.repository;

import pro.sky.course_work_2.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
