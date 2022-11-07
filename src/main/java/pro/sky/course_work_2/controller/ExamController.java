package pro.sky.course_work_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work_2.domain.Question;
import pro.sky.course_work_2.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get")
    Collection<Question> getQuestions(@RequestParam(value = "amount", required = false) Integer amount) {
        return examinerService.getQuestions(amount);
    }
}
