package pro.sky.course_work_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.course_work_2.domain.Question;
import pro.sky.course_work_2.exception.BadRequestException;
import pro.sky.course_work_2.exception.NullQuestionException;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaService,
                               @Qualifier("mathQuestionService") QuestionService mathService) {
        questionService = new ArrayList<>();
        questionService.add(javaService);
        questionService.add(mathService);
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) {
        validateQuestion(amount);
        Random random = new Random();
        Set<Question> set = new HashSet<>();
        while (set.size() != amount) {
            set.add(questionService.get(random.nextInt(2)).getRandomQuestion());
        }
        return set;
    }

    private void validateQuestion(Integer amount) {
        if (amount == null) {
            throw new NullQuestionException();
        }
        if (amount < 1 || amount > questionService.stream()
                .map(QuestionService::getSize)
                .flatMapToInt(IntStream::of).sum()) {
            throw new BadRequestException();
        }
    }
}
