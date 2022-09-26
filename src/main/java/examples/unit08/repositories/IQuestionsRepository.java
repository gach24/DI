package examples.unit08.repositories;

import java.util.List;

public interface IQuestionsRepository {
    List<String> findByExamId(Long id);
}
