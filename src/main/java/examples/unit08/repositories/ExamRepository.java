package examples.unit08.repositories;

import examples.unit08.models.Exam;

import java.util.List;

public interface ExamRepository {
    List<Exam> getAll();
}
