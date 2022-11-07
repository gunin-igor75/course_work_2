package pro.sky.course_work_2.repository;

import org.junit.jupiter.api.Test;
import pro.sky.course_work_2.exception.QuestionAlreadyAddedException;
import pro.sky.course_work_2.exception.QuestionNotFoundException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.course_work_2.ValueTest.*;


class JavaQuestionRepositoryTest {

    private JavaQuestionRepository repository = new JavaQuestionRepository();

    @Test
    void addTestOne() {
        assertAll(() -> assertEquals(0, repository.getAll().size()),
                () -> assertEquals(QUESTION1, repository.add("Что это tmp++",
                        "постфиксный инкременет tmp")),
                () -> assertEquals(1, repository.getAll().size()),
                () -> assertThrows(QuestionAlreadyAddedException.class,
                        () -> repository.add(QUESTION1)));
    }


    @Test
    void addTestTwo() {
        assertAll(() -> assertEquals(QUESTION1, repository.add(QUESTION1)),
                () -> assertEquals(1, repository.getAll().size()),
                () -> assertThrows(QuestionAlreadyAddedException.class,
                        () -> repository.add(QUESTION1)));
    }

    @Test
    void removeTest() {
        repository.add(QUESTION1);
        assertAll(() -> assertThrows(QuestionNotFoundException.class,
                        () -> repository.remove(QUESTION2)),
                () -> assertEquals(1, repository.getAll().size()),
                () -> assertEquals(QUESTION1, repository.remove(QUESTION1)),
                () -> assertEquals(0, repository.getAll().size()));
    }

    @Test
    void addAllTest() {
        repository.add(QUESTION1);
        repository.add(QUESTION2);
        assertThat(repository.getAll()).isEqualTo(SET);
    }

    @Test
    void t() {
        repository.init();
        System.out.println(repository.storageJava);
    }
}