package examples.unit08.services;

import examples.unit08.models.Exam;
import examples.unit08.repositories.IExamRepository;

import java.util.Optional;

public class ExamService implements IExamService {
    private IExamRepository examRepository;

    public ExamService(IExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam findByName(String name) {
        Optional<Exam> exam =  examRepository.getAll()
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
        return exam.orElseThrow();
    }
}
