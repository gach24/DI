package examples.unit08.services;

import examples.unit08.models.Exam;

import java.util.Optional;

public interface IExamService {
     Optional<Exam> findByName(String name);
     Exam findByNameWithQuestions(String name);
}
