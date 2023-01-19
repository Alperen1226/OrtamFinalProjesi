package edu.EskisehirOsmangaziUniversityAPI.entity;

public class Lesson {
    String name;
    String description;
    String professor;

    public Lesson(String name, String description, String professor) {
        this.name = name;
        this.description = description;
        this.professor = professor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
