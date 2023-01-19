package edu.EskisehirOsmangaziUniversityAPI.service;

import edu.EskisehirOsmangaziUniversityAPI.entity.Lesson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LessonServiceTest {

    @InjectMocks
    private LessonService lessonService;

    @Test
    void testReturnLessonList() {

        //Given
        Lesson lesson1 = new Lesson("Veritabani", "Veritabani uygulamalari", "TTaninDB");
        Lesson lesson2 = new Lesson("Mobil", "Mobil uygulamalar", "Omerbeko");
        Lesson lesson3 = new Lesson("Java", "Java uygulamalari", "Rasim");

        lessonService.createLesson(lesson1.getName(), lesson1.getDescription(), lesson1.getProfessor());
        lessonService.createLesson(lesson2.getName(), lesson2.getDescription(), lesson2.getProfessor());
        lessonService.createLesson(lesson3.getName(), lesson3.getDescription(), lesson3.getProfessor());

        //When
        List<Lesson> lessonList = lessonService.getLessonList();

        //Then
        assertThat(lessonList.size()).isGreaterThanOrEqualTo(1);

    }

    @Test
    void testCreateLessonAndReturnSameLesson() {

        //Given


        //When
        Lesson lesson = lessonService.createLesson("Java", "Java uygulamalari", "Rasim");

        //Then
        assertThat(lesson.getName()=="Java");
    }

    @Test
    void testCreateLessonAndCheckList() {

        //Given
        boolean flag = false;

        //When
        Lesson lesson = lessonService.createLesson("Java", "Java uygulamalari", "Rasim");
        List<Lesson> list = lessonService.getLessonList();
        for (Lesson les:list){
            if (les.getName().equals("Java")){
                flag = true;
            } else {
                flag = false;
            }
        }
        //Then
        assertThat(lessonService.getLessonList().size()>1);
        Assertions.assertTrue(flag);

    }

    @Test()
    void testDeleteLesson(){

        //Given
        lessonService.createLesson("Java", "Java uygulamalari", "Rasim");

        //When
        lessonService.deleteLesson("Java");
        List<Lesson> list = lessonService.getLessonList();

        //Then
        assertThat(list.isEmpty());
    }

    @Test
    void testThrowRuntimeException() {

        //Given
        RuntimeException exception1 = null;
        //When
        try {
            lessonService.deleteLesson("Java123");
        } catch (RuntimeException exception){
            exception1 = exception;
        }

        //Then
        Assertions.assertNotNull(exception1);
        assertThat(exception1.getMessage()=="Bu isimde ders bulunamadı... Java123");
    }
}