package pro.sky.course_work_2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.course_work_2.domain.Question;
import pro.sky.course_work_2.exception.QuestionAlreadyAddedException;
import pro.sky.course_work_2.exception.QuestionNotFoundException;

import javax.annotation.PostConstruct;
import java.util.*;


@Repository
public class JavaQuestionRepository implements QuestionRepository{

    public final Set<Question> storageJava;

    public JavaQuestionRepository() {
        this.storageJava = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        storageJava.add(new Question("Какие 3 класса не наследуются от Object?",
                "Все классы прямо или через предков наследуются от класса Object"));
        storageJava.add(new Question("Что такое инкапсуляция?",
                "Инкапсуляция — это сокрытие реализации при помощи модификаторов" +
                        " доступа, при помощи геттеров и сеттеров"));
        storageJava.add(new Question("Какой уровень доступа private?",
                "Уровень доступа — только класс, внутри которого он объявлен"));
        storageJava.add(new Question("Какой уровень доступа public?",
                "Полноценный доступ во всем приложении"));
        storageJava.add(new Question("Что такое Mutable?",
                "Mutable называются объекты, чьи состояния" +
                        " и переменные можно изменить после создания."));
    }

    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question,answer);
        if (storageJava.contains(quest)) {
            throw new QuestionAlreadyAddedException();
        }
        storageJava.add(quest);
        return quest;
    }

    @Override
    public Question add(Question question) {
        if (storageJava.contains(question)) {
            throw new QuestionAlreadyAddedException();
        }
        storageJava.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!storageJava.contains(question)) {
            throw new QuestionNotFoundException();
        }
        storageJava.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(storageJava);
    }
}
