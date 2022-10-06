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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class ExamServiceTest {

    private static final List<Exam> EXAMS = Arrays.asList(
            new Exam(1L, "Matemáticas"),
            new Exam(2L, "Lengua"),
            new Exam(2L, "Historia"));

    private static final List<String> QUESTIONS = Arrays.asList(
            "aritmética",
            "integrales",
            "derivadas",
            "trigonometría");

    private IExamRepository examRepository;
    private IQuestionsRepository questionsRepository;
    private IExamService examService;
    /*

    */

    @BeforeEach
    void setUp() {
        examRepository      = mock(IExamRepository.class);
        questionsRepository = mock(IQuestionsRepository.class);
        examService         = new ExamService(examRepository, questionsRepository);
    }

    @Test
    void testFindExamByName() {
        // When call the method return data
        when(examRepository.getAll()).thenReturn(EXAMS);

        Optional<Exam> exam = examService.findByName("Matemáticas");

        assertTrue(exam.isPresent());
        assertEquals(1L, exam.get().getId());
        assertEquals("Matemáticas", exam.get().getName());
    }

    @Test
    void testFindExamByNameWhenListEmpty() {
        when(examRepository.getAll()).thenReturn(Collections.emptyList());

        Optional<Exam> exam = examService.findByName("Matemáticas");

        assertFalse(exam.isPresent());
    }

    @Test
    void testQuestionsByExam() {
        when(examRepository.getAll()).thenReturn(EXAMS);
        when(questionsRepository.findByExamId(anyLong())).thenReturn(QUESTIONS);

        Exam exam = examService.findByNameWithQuestions("Matemáticas");

        verify(examRepository).getAll();
        verify(questionsRepository).findByExamId(anyLong());
        assertTrue(exam != null);
        assertEquals(4, exam.getQuestions().size());
        assertTrue(exam.getQuestions().contains("aritmética"));


    }





}