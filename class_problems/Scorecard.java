class Scorecard {

    // Private array - cannot be accessed outside
    private boolean[] results;

    // Number of answers recorded
    private int answerCount;

    // Constructor
    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    // Record the next answer
    public void recordAnswer(boolean correct) {

        // Check if all questions are already answered
        if (answerCount >= results.length) {
            System.out.println("No more answers can be recorded");
            return;
        }

        results[answerCount] = correct;
        answerCount++;
    }

    // Return only the total score
    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i] == true) {
                score++;
            }
        }

        return score;
    }
}

public class Main {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
