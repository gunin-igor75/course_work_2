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
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService javaService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.javaService = service;
    }

    @GetMapping("/add")
    Question addQuestion(@RequestParam(value = "question", required = false) String question,
                         @RequestParam(value = "answer", required = false) String answer) {
        return javaService.addQuestion(question, answer);
    }

    @GetMapping
    Collection<Question> getQuestions() {
        return javaService.getAll();
    }

    @GetMapping("/remove")
    Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                            @RequestParam(value = "answer", required = false) String answer) {

        return javaService.removeQuestion(new Question(question, answer));
    }

    @GetMapping("/find")
    Question findQuestion(@RequestParam(value = "question", required = false) String question,
                          @RequestParam(value = "answer", required = false) String answer) {

        return javaService.findQuestion(new Question(question, answer));
    }
}