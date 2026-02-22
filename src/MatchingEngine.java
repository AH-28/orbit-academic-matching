import java.util.*;

public class MatchingEngine {

    public Map<Mentor, Double> findTopMentors(Mentee mentee, List<Mentor> availableMentors) {
        Map<Mentor, Double> scoredMentors = new HashMap<>();

        for (Mentor mentor : availableMentors) {
            double score = calculateMatchScore(mentee, mentor);
            // Only suggest mentors if they meet a minimum threshold of compatibility
            if (score > 10.0) {
                scoredMentors.put(mentor, score);
            }
        }

        // Sort the map to return the highest scores first (simulating the "stack" of profiles)
        return sortByValueDescending(scoredMentors);
    }

    private double calculateMatchScore(Mentee mentee, Mentor mentor) {
        double score = 0.0;

        // 1. Identity & Background Alignment (Highest Weight)
        Set<String> sharedIdentities = new HashSet<>(mentee.getIdentityMarkers());
        sharedIdentities.retainAll(mentor.getIdentityMarkers());
        score += sharedIdentities.size() * 40.0; // Massive boost for shared lived experience

        // 2. Academic Interests (Medium Weight)
        Set<String> sharedInterests = new HashSet<>(mentee.getAcademicInterests());
        sharedInterests.retainAll(mentor.getAcademicInterests());
        score += sharedInterests.size() * 20.0;

        // 3. Logistical Preferences: Meeting Type
        if (mentee.getMeetingPreference() == mentor.getMeetingPreference() ||
                mentor.getMeetingPreference() == MeetingPreference.HYBRID) {
            score += 15.0;
        }

        // 4. Logistical Preferences: Location (Only applies if they want in-person)
        if (mentee.getMeetingPreference() != MeetingPreference.ONLINE &&
                mentee.getLocationCity().equalsIgnoreCase(mentor.getLocationCity())) {
            score += 25.0;
        }

        return score;
    }

    // Helper method to sort map by values (Scores)
    private Map<Mentor, Double> sortByValueDescending(Map<Mentor, Double> unsortMap) {
        List<Map.Entry<Mentor, Double>> list = new LinkedList<>(unsortMap.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        Map<Mentor, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Mentor, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}