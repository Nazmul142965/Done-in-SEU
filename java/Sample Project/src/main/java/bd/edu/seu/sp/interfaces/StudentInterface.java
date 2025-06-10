package bd.edu.seu.sp.interfaces;

import bd.edu.seu.sp.model.Student;

import java.util.List;

public interface StudentInterface {
    void insert(Student student);
    void update(Student student);
    void delete(Student student);
    List<Student> getAll();
}
