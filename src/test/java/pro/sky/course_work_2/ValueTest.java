package pro.sky.course_work_2;

import pro.sky.course_work_2.domain.Question;

import java.util.Collection;
import java.util.HashSet;

public class ValueTest {
    public static Question QUESTION1 = new Question("Что это tmp++",
            "постфиксный инкременет tmp");
    public static Question QUESTION2 = new Question("Что это ++tmp",
            "префиксный инкременет tmp");
    public static Question QUESTION_NULL = new Question(null,
            "префиксный инкременет tmp");
    public static Collection<Question> SET = new HashSet<>();
    static {
            SET.add(QUESTION1);
            SET.add(QUESTION2);
    }
}
