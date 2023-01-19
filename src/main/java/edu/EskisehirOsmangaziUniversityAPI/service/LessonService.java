package edu.EskisehirOsmangaziUniversityAPI.service;

import edu.EskisehirOsmangaziUniversityAPI.entity.Lesson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    private final List<Lesson> lessonList = new ArrayList<>();

    public  List<Lesson> getLessonList(){
        return lessonList;
    }

    public Lesson createLesson(String name, String description, String professor){
        Lesson lesson = new Lesson(name, description, professor);
        lessonList.add(lesson);
        return lesson;
    }

    public void deleteLesson(String name){
        boolean flag = false;
        if (!lessonList.isEmpty()){
            for (Lesson lesson:lessonList){
                if (lesson.getName().equals(name)){
                    lessonList.remove(lesson);
                    flag = true;
                    break;
                }
            }
        }

        if (!flag){
            throw new RuntimeException("Bu isimde ders bulunamadı... "+name);
        }
    }

}
