package examples.unit08.services;

import examples.unit08.models.Exam;
import examples.unit08.repositories.IExamRepository;
import examples.unit08.repositories.IQuestionsRepository;

import java.util.List;
import java.util.Optional;

public class ExamService implements IExamService {
    private IExamRepository examRepository;
    private IQuestionsRepository questionsRepository;

    public ExamService(IExamRepository er, IQuestionsRepository qr) {
        this.examRepository = er;
        this.questionsRepository = qr;
    }

    public Optional<Exam> findByName(String name) {
        return examRepository.getAll()
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    public Exam findByNameWithQuestions(String name) {
        Optional<Exam> optionalExam = findByName(name);
        Exam exam = null;
        if (optionalExam.isPresent())
        {
            exam = optionalExam.get();
            List<String> questions = questionsRepository.findByExamId(exam.getId());
            exam.setQuestions(questions);
        }
        return exam;
    }

}
