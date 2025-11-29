package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list cannot be null or empty");
        }
        
        
        double sum = 0;
        for (Integer bpm : bpms) {
            if (bpm == null) {
                throw new IllegalArgumentException("BPM values cannot be null");
            }
            sum += bpm;
        }
        double averageBpm = sum / bpms.size();
        
        
        if (averageBpm >= 140) {
            return "HIGH";
        } else if (averageBpm >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        
        if (title == null) {
            return false;
        }
        
        
        if (title.length() < 1 || title.length() > 30) {
            return false;
        }
        
        
        for (char c : title.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        
        if (volumeDb < 0) {
            return 0;
        } else if (volumeDb > 100) {
            return 100;
        } else {
            return volumeDb;
        }
    }
}