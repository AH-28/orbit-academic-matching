import java.util.*;

enum MeetingPreference { ONLINE, IN_PERSON, HYBRID }
//Commit 1
// Base class for all users
//mdhdhhdhdh
class AcademicUser {
    private String userId;
    private String name;
    private Set<String> identityMarkers; // e.g., "LGBTQ+", "First-Gen", "Working-Class"
    private Set<String> academicInterests; // e.g., "Computer Science", "Pre-Law"
    private MeetingPreference meetingPreference;
    private String locationCity;

    public AcademicUser(String id, String name, Set<String> identities, Set<String> interests, MeetingPreference pref, String location) {
        this.userId = id;
        this.name = name;
        this.identityMarkers = identities;
        this.academicInterests = interests;
        this.meetingPreference = pref;
        this.locationCity = location;
    }

    // Getters
    public Set<String> getIdentityMarkers() { return identityMarkers; }
    public Set<String> getAcademicInterests() { return academicInterests; }
    public MeetingPreference getMeetingPreference() { return meetingPreference; }
    public String getLocationCity() { return locationCity; }
    public String getName() { return name; }
}

class Mentor extends AcademicUser {
    private int maxMentees;

    public Mentor(String id, String name, Set<String> identities, Set<String> interests, MeetingPreference pref, String location, int maxMentees) {
        super(id, name, identities, interests, pref, location);
        this.maxMentees = maxMentees;
    }
    public int getMaxMentees() { return maxMentees; }
}

class Mentee extends AcademicUser {
    public Mentee(String id, String name, Set<String> identities, Set<String> interests, MeetingPreference pref, String location) {
        super(id, name, identities, interests, pref, location);
    }
}