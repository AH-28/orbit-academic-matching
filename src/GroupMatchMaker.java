import java.util.*;

class SupportGroup {
    String groupTopic;
    List<Mentee> members = new ArrayList<>();

    public SupportGroup(String topic) { this.groupTopic = topic; }
    public void addMember(Mentee m) { members.add(m); }
}

public class GroupMatchMaker {

    // Groups mentees who share a specific identity marker but don't have a mentor yet
    public SupportGroup createPeerCircle(List<Mentee> unassignedMentees, String targetIdentity, int maxGroupSize) {
        SupportGroup circle = new SupportGroup(targetIdentity + " Support Circle");

        for (Mentee mentee : unassignedMentees) {
            if (mentee.getIdentityMarkers().contains(targetIdentity) && circle.members.size() < maxGroupSize) {
                circle.addMember(mentee);
            }
        }
        return circle;
    }
}