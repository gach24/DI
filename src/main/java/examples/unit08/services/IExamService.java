package examples.unit08.services;

import examples.unit08.models.Exam;

public interface IExamService {
    Exam findByName(String name);
}
