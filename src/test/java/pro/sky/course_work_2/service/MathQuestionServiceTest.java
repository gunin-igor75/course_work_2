package pro.sky.course_work_2.service;

import org.junit.jupiter.api.Test;
import pro.sky.course_work_2.exception.MethodNotAllowedException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.course_work_2.ValueTest.*;
import static org.assertj.core.api.Assertions.*;

class MathQuestionServiceTest {
    private final MathQuestionService mathService = new MathQuestionService();


    @Test
    void mateServiceTest() {
        assertAll(() -> assertThrows(MethodNotAllowedException.class,
                        () -> mathService.addQuestion(QUESTION1)),
                () -> assertThrows(MethodNotAllowedException.class,
                        () -> mathService.addQuestion("Что это ++tmp",
                                "префиксный инкременет tmp")),
                () -> assertThrows(MethodNotAllowedException.class,
                        () -> mathService.removeQuestion(QUESTION1)),
                () -> assertThrows(MethodNotAllowedException.class,
                        mathService::getAll),
                () -> assertThrows(MethodNotAllowedException.class,
                        () -> mathService.findQuestion(QUESTION1)));
    }

    @Test
    void getRandomQuestionTest() {
        mathService.init();
        assertThat(4).isEqualTo(mathService.getSize());
        assertEquals("Question", mathService.getRandomQuestion().getClass().getSimpleName());
    }
}