package edu.EskisehirOsmangaziUniversityAPI.controller;

import edu.EskisehirOsmangaziUniversityAPI.entity.Lesson;
import edu.EskisehirOsmangaziUniversityAPI.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping()
    public List<Lesson> getLessonList(){
        return lessonService.getLessonList();
    }

    @PostMapping("/create")
    public Lesson createLesson(@RequestBody Lesson lesson){
        return lessonService.createLesson(lesson.getName(), lesson.getDescription(), lesson.getProfessor());
    }

    @DeleteMapping("/delete")
    public void deleteLesson(@RequestBody String name){
        lessonService.deleteLesson(name);
    }
}

