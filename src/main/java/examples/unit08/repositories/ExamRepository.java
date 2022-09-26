package examples.unit08.repositories;

import examples.unit08.models.Exam;

import java.util.Arrays;
import java.util.List;

public class ExamRepository implements IExamRepository{

    public List<Exam> getAll() {
        return Arrays.asList(
                new Exam(1L, "Matemáticas"),
                new Exam(2L, "Lengua"),
                new Exam(2L, "Historia")
        );
    }
}
