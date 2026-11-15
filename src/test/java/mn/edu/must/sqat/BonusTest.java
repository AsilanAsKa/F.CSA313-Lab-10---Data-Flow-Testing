package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {

    @Test
    void nullAttendanceThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> DataFlowTargets.bonus(null, 3));
    }

    @Test
    void negativeThresholdThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> DataFlowTargets.bonus(new int[]{1, 1}, -1));
    }

    @Test
    void attendanceWithFiveConsecutiveDays() {
        assertEquals(8,
                DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 5));
    }

    @Test
    void attendanceWithAbsence() {
        assertEquals(5,
                DataFlowTargets.bonus(new int[]{1, 0, 1}, 2));
    }

    @Test
    void attendanceBelowThreshold() {
        assertEquals(0,
                DataFlowTargets.bonus(new int[]{1}, 2));
    }

    @Test
    void absenceResetsConsecutiveStreak() {
        assertEquals(0,
                DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 0, 1}, 6));
    }

    @Test
    void fiveConsecutiveDaysBelowThreshold() {
        assertEquals(3,
                DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 6));
    }

    @Test
    void totalAttendanceIsNotLongestStreak() {
        assertEquals(0,
                DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1}, 6));
    }
}
