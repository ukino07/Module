import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by u_kino07 on 2018. 6. 5..
 */
public class PredicateExam {
    public static List<Student> students = Arrays.asList(
            new Student("stu1", 80, 90, "M"),
            new Student("stu2", 80, 90, "M"),
            new Student("stu3", 80, 90, "M"),
            new Student("stu4", 80, 90, "W"),
            new Student("stu5", 80, 90, "W"),
            new Student("stu6", 80, 90, "W"),
            new Student("stu7", 80, 90, "W"),
            new Student("stu8", 80, 90, "M")
    );

    public static double[] average(Predicate<Student> predicates) {
        int count = 0;
        int englishSum = 0;
        int mathSum = 0;

        for (Student student : students) {
            if (predicates.test(student)) {
                count++;
                englishSum += student.getEnglishScore();
                mathSum += student.getMathScore();
            }
        }

        double average[] = {((double) englishSum / count), ((double) mathSum / count)};
        return average;
    }

    public static void main (String[] args) {
        double mailAverage[] = average(t -> t.getSex().equals("M"));
        System.out.println("남자 평균 점수 (영어, 수학)");

        for (double average : mailAverage) {
            System.out.println(average + " ");
        }
        System.out.println();

        double femailAverage[] = average(t -> t.getSex().equals("W"));
        System.out.println("여자 평균 점수 (영어, 수학)");

        for (double average : femailAverage) {
            System.out.println(average + " ");
        }
        System.out.println();
    }


    /**
     * 필요한 모델
     */
    public static class Student {
        private String name;
        private int englishScore;
        private int mathScore;
        private String sex;

        public Student(String name, int englishScore, int mathScore, String sex) {
            this.name = name;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(int englishScore) {
            this.englishScore = englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }

        public void setMathScore(int mathScore) {
            this.mathScore = mathScore;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
