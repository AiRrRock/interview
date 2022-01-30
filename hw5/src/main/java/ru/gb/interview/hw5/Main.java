package ru.gb.interview.hw5;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        System.out.println(dao.findById(1L));
        for(int i =0; i < 1000; i++){
            Student newSt = new Student();
            newSt.setMark(4.0);
            newSt.setName("Student_"+i);
            dao.save(newSt);
        }
        List<Student> studentList = dao.findAll();
        dao.delete(dao.findById(1L));

    }
}
