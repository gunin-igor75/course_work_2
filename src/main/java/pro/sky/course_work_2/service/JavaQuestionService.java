package pro.sky.course_work_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.course_work_2.domain.Question;
import pro.sky.course_work_2.exception.NullQuestionException;
import pro.sky.course_work_2.exception.QuestionNotFoundException;
import pro.sky.course_work_2.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository javaRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository javaRepository) {
        this.javaRepository = javaRepository;
    }


    @Override
    public Question addQuestion(String question, String answer) {
        validateQuestion(question, answer);
        return javaRepository.add(question, answer);
    }

    @Override
    public Question addQuestion(Question question) {
        validateQuestion(question);
        return javaRepository.add(question);
    }

    @Override
    public Question removeQuestion(Question question) {
        validateQuestion(question);
        javaRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(javaRepository.getAll());
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    @Override
    public int getSize() {
        return getAll().size();
    }

    @Override
    public Question findQuestion(Question question) {
        validateQuestion(question);
        if (!javaRepository.getAll().contains(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @SafeVarargs
    private <T> void validateQuestion(T... questions) {
        for (T value : questions) {
            if (value == null) {
                throw new NullQuestionException();
            }
            if (value instanceof Question) {
                Question question = (Question) value;
                if (question.getAnswer() == null || question.getQuestion() == null) {
                    throw new NullQuestionException();
                }
            }
        }
    }
}
