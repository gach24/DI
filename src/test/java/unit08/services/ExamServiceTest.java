package unit08.services;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import examples.unit08.models.Exam;
import examples.unit08.repositories.IExamRepository;
import examples.unit08.repositories.IQuestionsRepository;
import examples.unit08.services.ExamService;
import examples.unit08.services.IExamService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class ExamServiceTest {
    private IExamRepository examRepository;
    private IQuestionsRepository questionsRepository;
    private IExamService service;

    @BeforeEach
    void setUp() {
        examRepository = mock(IExamRepository.class);
        questionsRepository = mock(IQuestionsRepository.class);
        service = new ExamService(examRepository, questionsRepository);
    }

    @Test
    void testFindExamByName() {
        // Data
        List<Exam> exams = Arrays.asList(
                new Exam(1L, "Matemáticas"),
                new Exam(2L, "Lengua"),
                new Exam(2L, "Historia"));

        // When call the method return data
        when(examRepository.getAll()).thenReturn(exams);

        Optional<Exam> exam = service.findByName("Matemáticas");
        assertTrue(exam.isPresent());
        assertEquals(1L, exam.orElseThrow().getId());
        assertEquals("Matemáticas", exam.orElseThrow().getName());
    }

    @Test
    void testFindExamByNameWhenListEmpty() {
        // Data
        List<Exam> exams = Collections.emptyList();

        // When call the method return data
        when(examRepository.getAll()).thenReturn(exams);

        Optional<Exam> exam = service.findByName("Matemáticas");
        assertFalse(exam.isPresent());
    }

}