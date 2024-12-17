package com.t01g02.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {
    private Timer timer;

    @BeforeEach
    public void setUp() {
        timer = new Timer(1, 30);
    }

    @Test
    public void testConstructor() {
        assertEquals(90*1000, timer.getRemainingSeconds()*1000); // (90 seconds)
        assertFalse(timer.isTimeUp());
    }

    @Test
    public void testUpdateWithoutReachingTimeUp() {
        timer.update(1000);
        assertEquals(89, timer.getRemainingSeconds());
        assertFalse(timer.isTimeUp());
    }

    @Test
    public void testUpdateWithTimeUp() {
        timer.update(90 * 1000); // (90 seconds)
        assertEquals(0, timer.getRemainingSeconds()); // time is up
        assertTrue(timer.isTimeUp());
    }

    @Test
    public void testGetFormattedTime() {
        assertEquals("01:30", timer.getFormattedTime());

        timer.update(30 * 1000); // (30 seconds)
        assertEquals("01:00", timer.getFormattedTime());

        timer.update(60 * 1000); // + (60 seconds)
        assertEquals("00:00", timer.getFormattedTime()); // 30 + 60 = 90 seconds
    }

    @Test
    public void testResetTimer() {
        timer.update(60 * 1000); // (60 seconds)
        assertEquals("00:30", timer.getFormattedTime());

        timer.resetTimer(2, 0);
        assertEquals("02:00", timer.getFormattedTime());
        assertFalse(timer.isTimeUp());
    }
}
