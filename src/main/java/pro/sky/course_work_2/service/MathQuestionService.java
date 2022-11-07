package pro.sky.course_work_2.service;

;
import org.springframework.stereotype.Service;
import pro.sky.course_work_2.domain.Question;
import pro.sky.course_work_2.exception.MethodNotAllowedException;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class MathQuestionService implements QuestionService{

    private final List<Question> storageMath;

    public MathQuestionService() {
        this.storageMath = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        storageMath.add(new Question("Что такое можество?",
                "Совокупность определенных объектов по определенному признаку"));
        storageMath.add(new Question("Как понять: Б является подмножеством А",
                "Все эдементы множества Б входят в множество А"));
        storageMath.add(new Question("Что такое четные числа?",
                "Числа, которые делятся на 2 без остатка"));
        storageMath.add(new Question("Что такое нечетные числа?",
                "Числа у которых после деления на 2 остаток не равен 0"));
    }


    @Override
    public Question addQuestion(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question addQuestion(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question removeQuestion(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {;
        Random random = new Random();
        int index = random.nextInt(storageMath.size());
        return storageMath.get(index);
    }

    @Override
    public int getSize() {
        return storageMath.size();
    }

    @Override
    public Question findQuestion(Question question) {
        throw new MethodNotAllowedException();
    }
}
