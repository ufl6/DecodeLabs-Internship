
import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {
        HashMap<String, String[]> courses = new HashMap<>();

        courses.put("Java OOP Course", new String[]{"java", "programming", "oop"});
        courses.put("Web Development Course", new String[]{"html", "css", "web"});
        courses.put("AI Basics Course", new String[]{"ai", "logic", "data"});
        courses.put("Cybersecurity Course", new String[]{"security", "network", "hacking"});
        courses.put("Game Development Course", new String[]{"games", "java", "design"});
        courses.put("Mobile App Development Course", new String[]{"mobile", "apps", "java"});
        courses.put("Data Science Course", new String[]{"data", "statistics", "ai"});

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the AI Recommendation System!");
        System.out.println("Enter at least 3 interests separated by commas.");
        System.out.println("Example: java, ai, data");
        System.out.print("Your interests: ");

        String input = scanner.nextLine().toLowerCase();

        String[] userInterestsArray = input.split(",");
        HashSet<String> userInterests = new HashSet<>();

        for (String interest : userInterestsArray) {
            userInterests.add(interest.trim());
        }

        HashMap<String, Integer> courseScores = new HashMap<>();

        for (String course : courses.keySet()) {
            String[] courseTags = courses.get(course);
            int score = 0;

            for (String tag : courseTags) {
                if (userInterests.contains(tag)) {
                    score++;
                }
                courseScores.put(course, score);
            }
        }

        List<Map.Entry<String, Integer>> sortedCourses = new ArrayList<>(courseScores.entrySet());

        sortedCourses.sort((a, b) -> b.getValue() - a.getValue()); // highest comes first

        System.out.println("\nRecommended Courses:");

        int count = 0;

        for (Map.Entry<String, Integer> entry : sortedCourses) {
            if (entry.getValue() > 0 && count < 3) { // only top 3
                System.out.println(entry.getKey() + " (Score: " + entry.getValue() + ")");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No courses match your interests. Please try again with different interests.");
        }

        scanner.close();
    }
}
