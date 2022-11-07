package pro.sky.course_work_2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work_2.domain.Question;
import pro.sky.course_work_2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    private final QuestionService mathService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/add")
    Question addQuestion(@RequestParam(value = "question", required = false) String question,
                         @RequestParam(value = "answer", required = false) String answer) {
        return mathService.addQuestion(question, answer);
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return mathService.getAll();
    }

    @GetMapping("/remove")
    Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                            @RequestParam(value = "answer", required = false) String answer) {

        return mathService.removeQuestion(new Question(question, answer));
    }

    @GetMapping("/find")
    Question findQuestion(@RequestParam(value = "question", required = false) String question,
                          @RequestParam(value = "answer", required = false) String answer) {

        return mathService.findQuestion(new Question(question, answer));
    }
}
