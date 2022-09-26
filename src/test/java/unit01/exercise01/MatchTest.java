package unit01.exercise01;

import examples.unit01.exercise01.Match;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    @Test
    void testDateMatch() {
        Match m = new Match();

        assertEquals("23-09-2022", m.getDate());
    }
}
