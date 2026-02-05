
class Moderation {
    int moderate(int marks) {
        return marks;
    }
}

class AttendanceRule extends Moderation {
    int moderate(int marks) {
        System.out.println("Applying Attendance Rule (+5 marks)");
        return marks + 5;
    }
}

abstract class Evaluation {
    Moderation rule;

    void setModeration(Moderation r) {
        this.rule = r;
    }

    void evaluate() {
        int marks = collectMarks();

        if (rule != null) {
            marks = rule.moderate(marks);
        }

        showResult(marks);
    }

    abstract int collectMarks();

    abstract void showResult(int marks);
}

class BTech extends Evaluation {
    int collectMarks() {
        System.out.println("B.Tech: Collecting Theory & Lab Marks...");
        return 80;
    }

    void showResult(int marks) {
        System.out.println("B.Tech Result: " + marks + " (Grade A)");
    }
}

public class ExperimentTwo {
    public static void main(String[] args) {
        System.out.println("--- Prototype Evaluation System ---");
        Evaluation exam = new BTech();
        exam.setModeration(new AttendanceRule());
        exam.evaluate();
    }
}
