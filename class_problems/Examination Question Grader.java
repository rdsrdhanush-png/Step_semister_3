import java.util.Scanner;

abstract class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String correct, String answer, double points) {
        super(correct, answer, points);
    }

    double grade() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }
}

class TF extends Question {
    TF(String correct, String answer, double points) {
        super(correct, answer, points);
    }

    double grade() {
        return correct.equalsIgnoreCase(answer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String correct, String answer, double points) {
        super(correct, answer, points);
    }

    double grade() {
        String[] words = correct.split(",");
        String ans = answer.toLowerCase();
        int count = 0;

        for (String word : words) {
            String key = word.trim().toLowerCase();

            if (!key.isEmpty() &&
                ans.matches("(?s).*\\b" + java.util.regex.Pattern.quote(key) + "\\b.*")) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            java.util.regex.Matcher m =
                java.util.regex.Pattern.compile("\"([^\"]*)\"|([^\\s]+)").matcher(line);

            java.util.ArrayList<String> a = new java.util.ArrayList<>();

            while (m.find()) {
                a.add(m.group(1) != null ? m.group(1) : m.group(2));
            }

            String type = a.get(0);
            String correct = a.get(2);
            String answer = a.get(3);
            double points = Double.parseDouble(a.get(4));

            Question q;

            if (type.equals("MCQ")) {
                q = new MCQ(correct, answer, points);
            } else if (type.equals("TF")) {
                q = new TF(correct, answer, points);
            } else {
                q = new Essay(correct, answer, points);
            }

            double score = q.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
