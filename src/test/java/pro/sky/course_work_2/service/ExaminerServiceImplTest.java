package pro.sky.course_work_2.service;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import pro.sky.course_work_2.exception.BadRequestException;
import pro.sky.course_work_2.exception.NullQuestionException;
import pro.sky.course_work_2.repository.JavaQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ExaminerServiceImplTest {

    @Spy
    private JavaQuestionRepository repository = new JavaQuestionRepository();
    @Spy
    private QuestionService javaService = new JavaQuestionService(repository);
    @Spy
    MathQuestionService mathService = new MathQuestionService();
    private final ExaminerService examinerService = new ExaminerServiceImpl(
            javaService, mathService);

    @Test
    void getQuestionsTest() {
        repository.init();
        mathService.init();
        assertAll(() -> assertThat(3).
                        isEqualTo(examinerService.getQuestions(3).size()),
                () -> assertThat(5).
                        isEqualTo(examinerService.getQuestions(5).size()),
                () -> assertThrows(NullQuestionException.class,
                        () -> examinerService.getQuestions(null)),
                () -> assertThrows(BadRequestException.class,
                        () -> examinerService.getQuestions(10)));
    }

}