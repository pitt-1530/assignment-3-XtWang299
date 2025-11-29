package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class PlaylistRecommenderTest {

    // ===== Tests for classifyEnergy() =====
    
    @Test
    public void testClassifyEnergyHigh() {
        // Test HIGH energy (BPM >= 140)
        List<Integer> highBpms = Arrays.asList(140, 150, 160);
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(highBpms));
    }
    
    @Test
    public void testClassifyEnergyMedium() {
        // Test MEDIUM energy (BPM 100-139)
        List<Integer> mediumBpms = Arrays.asList(100, 120, 139);
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(mediumBpms));
    }
    
    @Test
    public void testClassifyEnergyLow() {
        // Test LOW energy (BPM < 100)
        List<Integer> lowBpms = Arrays.asList(80, 90, 99);
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(lowBpms));
    }
    
    @Test
    public void testClassifyEnergyNullList() {
        // Test null list throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            PlaylistRecommender.classifyEnergy(null);
        });
    }
    
    @Test
    public void testClassifyEnergyEmptyList() {
        // Test empty list throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            PlaylistRecommender.classifyEnergy(Collections.emptyList());
        });
    }

    // ===== Tests for isValidTrackTitle() =====
    
    @Test
    public void testIsValidTrackTitleValid() {
        // Test valid titles
        assertTrue(PlaylistRecommender.isValidTrackTitle("Hello World"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("A")); // min length
    }
    
    @Test
    public void testIsValidTrackTitleInvalid() {
        // Test invalid titles
        assertFalse(PlaylistRecommender.isValidTrackTitle(null)); // null
        assertFalse(PlaylistRecommender.isValidTrackTitle("")); // empty string
        assertFalse(PlaylistRecommender.isValidTrackTitle("TitleWith123")); // numbers
    }

    // ===== Tests for normalizeVolume() =====
    
    @Test
    public void testNormalizeVolumeWithinRange() {
        // Test volumes within 0-100 range
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
        assertEquals(0, PlaylistRecommender.normalizeVolume(0));
        assertEquals(100, PlaylistRecommender.normalizeVolume(100));
    }
    
    @Test
    public void testNormalizeVolumeBelowRange() {
        // Test volumes below 0
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
    }
    
    @Test
    public void testNormalizeVolumeAboveRange() {
        // Test volumes above 100
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
    }
}