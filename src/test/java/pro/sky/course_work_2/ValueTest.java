package pro.sky.course_work_2;

import pro.sky.course_work_2.domain.Question;

import java.util.Collection;
import java.util.HashSet;

public class ValueTest {
    public static Question QUESTION1 = new Question("��� ��� tmp++",
            "����������� ���������� tmp");
    public static Question QUESTION2 = new Question("��� ��� ++tmp",
            "���������� ���������� tmp");
    public static Question QUESTION_NULL = new Question(null,
            "���������� ���������� tmp");
    public static Collection<Question> SET = new HashSet<>();
    static {
            SET.add(QUESTION1);
            SET.add(QUESTION2);
    }
}
