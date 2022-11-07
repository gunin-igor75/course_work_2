package pro.sky.course_work_2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work_2.exception.NullQuestionException;
import pro.sky.course_work_2.exception.QuestionNotFoundException;
import pro.sky.course_work_2.repository.JavaQuestionRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.course_work_2.ValueTest.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository repositoryMock;
    @Spy
    private JavaQuestionRepository repositorySpy = new JavaQuestionRepository();
    private JavaQuestionService javaService;
    private JavaQuestionService javaServiceReal;

    @BeforeEach
    public void initService() {
        javaService = new JavaQuestionService(repositoryMock);
        javaServiceReal = new JavaQuestionService(repositorySpy);
    }

    @Test
    void addQuestionTest() {
        when(repositoryMock.add(QUESTION1)).thenReturn(QUESTION1);
        when(repositoryMock.add("Что это ++tmp",
                "префиксный инкременет tmp")).thenReturn(QUESTION2);
        assertThat(QUESTION1).isEqualTo(javaService.addQuestion(QUESTION1));
        assertThat(QUESTION2).isEqualTo(javaService.addQuestion("Что это ++tmp",
                "префиксный инкременет tmp"));
        assertThrows(NullQuestionException.class,
                () -> javaService.addQuestion(null));
        assertThrows(NullQuestionException.class,
                () -> javaService.addQuestion(QUESTION_NULL));
    }

    @Test
    void removeQuestionTest() {
        when(repositoryMock.remove(QUESTION1)).thenReturn(QUESTION1);
        assertThat(QUESTION1).isEqualTo(javaService.removeQuestion(QUESTION1));
        assertThrows(NullQuestionException.class,
                () -> javaService.removeQuestion(null));
        assertThrows(NullQuestionException.class,
                () -> javaService.removeQuestion(QUESTION_NULL));
    }

    @Test
    void getRandomQuestionTest() {
        javaServiceReal.addQuestion(QUESTION1);
        javaServiceReal.addQuestion(QUESTION2);
        assertThat(2).isEqualTo(javaServiceReal.getSize());
        JavaQuestionService service1 = new JavaQuestionService(repositorySpy);
        assertEquals("Question", service1.getRandomQuestion().getClass().getSimpleName());
    }

    @Test
    void findQuestion() {
        javaServiceReal.addQuestion(QUESTION1);
        assertThat(QUESTION1).isEqualTo(javaServiceReal.findQuestion(QUESTION1));
        assertThrows(NullQuestionException.class,
                () -> javaServiceReal.findQuestion(null));
        assertThrows(NullQuestionException.class,
                () -> javaServiceReal.findQuestion(QUESTION_NULL));
        assertThrows(QuestionNotFoundException.class,
                () -> javaServiceReal.findQuestion(QUESTION2));
    }
}