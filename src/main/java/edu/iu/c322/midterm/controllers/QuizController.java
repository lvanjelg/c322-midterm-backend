package edu.iu.c322.midterm.controllers;

import edu.iu.c322.midterm.model.Question;
import edu.iu.c322.midterm.model.Quiz;
import edu.iu.c322.midterm.repository.FileRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/quizzes")
public class QuizController {
    private FileRepository fileRepository;
    public QuizController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
    @PostMapping
    public int add(@RequestBody Quiz quiz) {
        try {
            return fileRepository.addQuiz(quiz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public List<Quiz> findAll() {
        try {
            return fileRepository.findAllQuizzes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{id}")
    public Quiz get(@PathVariable int id){
        try {
            return fileRepository.getQuiz(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
