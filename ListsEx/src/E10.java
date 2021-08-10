import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> scheduleOfLessons = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));
        String input = scanner.nextLine();
        while (!input.equals("course start")){
            String[] changesForCourse = input.split(":");
            switch (changesForCourse[0]){
                case "Add":
                    addLesson(scheduleOfLessons, changesForCourse[1]);
                    break;
                case "Insert":
                    insertLesson(scheduleOfLessons,changesForCourse[1], Integer.parseInt(changesForCourse[2]));
                    break;
                case "Remove":
                    removeLesson(scheduleOfLessons, changesForCourse[1]);
                    if (scheduleOfLessons.contains(changesForCourse[1] + "-Exercise")) {
                        removeLesson(scheduleOfLessons,changesForCourse[1] + "-Exercise");
                    }
                    break;
                case "Swap":
                    String firstExercise = changesForCourse[1] + "-Exercise";
                    String secondExercise = changesForCourse[2] + "-Exercise";
                    if (scheduleOfLessons.contains(changesForCourse[1]) && scheduleOfLessons.contains(changesForCourse[2])) {
                        swapLessons(scheduleOfLessons, changesForCourse[1], changesForCourse[2]);

                        if (scheduleOfLessons.contains(firstExercise)){
                            scheduleOfLessons.remove(scheduleOfLessons.indexOf(firstExercise));
                            scheduleOfLessons.add(scheduleOfLessons.indexOf(changesForCourse[1]) + 1, firstExercise);
                        }
                        if (scheduleOfLessons.contains(secondExercise)){
                            scheduleOfLessons.remove(scheduleOfLessons.indexOf(secondExercise));
                            scheduleOfLessons.add(scheduleOfLessons.indexOf(changesForCourse[2]) + 1, secondExercise);
                        }
                    }
                    // 0 1   2 3   4
                    // 1 2   3 3.1 4
                    // 3 2   1 3.1 4
                    // 3 3.1 1 2   4
                    break;
                case "Exercise":
                    addExercise(scheduleOfLessons,changesForCourse[1]);
                    break;
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < scheduleOfLessons.size() ; i++) {
            System.out.println((i + 1) + "." + scheduleOfLessons.get(i));
        }

    }
    public static void addLesson (List<String> scheduleOfLessons, String lessonTitle){
        int counter = notExists(scheduleOfLessons, lessonTitle);
        if (counter == scheduleOfLessons.size()){
            scheduleOfLessons.add(lessonTitle);
        }
    }

    private static int notExists(List<String> scheduleOfLessons, String lessonTitle) {
        int counter = 0;
        for (int i = 0; i < scheduleOfLessons.size() ; i++) {
            if (!lessonTitle.equals(scheduleOfLessons.get(i))){
                counter++;
            }
        }
        return counter;
    }

    public static void insertLesson (List<String> scheduleOfLessons, String lessonTitle, int index){
        int counter = notExists(scheduleOfLessons, lessonTitle);
        if (counter == scheduleOfLessons.size()){
            if (index >=0 && index < scheduleOfLessons.size()) {
                scheduleOfLessons.add(index, lessonTitle);
            }
        }

    }
    public static void removeLesson (List<String> scheduleOfLessons, String lessonTitle){
        int counter = notExists(scheduleOfLessons, lessonTitle);
        if (counter != scheduleOfLessons.size()){
            scheduleOfLessons.remove(lessonTitle);
        }
    }
    public static void swapLessons (List<String> scheduleOfLessons, String firstLessonTitle, String secondLessonTitle){
        int firstLessonCounter = notExists(scheduleOfLessons, firstLessonTitle);
        int secondLessonCounter = notExists(scheduleOfLessons, secondLessonTitle);
        if (firstLessonCounter != scheduleOfLessons.size() && secondLessonCounter != scheduleOfLessons.size()){
            int firstIndex = scheduleOfLessons.indexOf(firstLessonTitle);
            int secondIndex = scheduleOfLessons.indexOf(secondLessonTitle);
            scheduleOfLessons.set(firstIndex, secondLessonTitle);
            scheduleOfLessons.set(secondIndex, firstLessonTitle);
        }
    }
    public static void addExercise (List<String> scheduleOfLessons, String lessonTitle){
        int counter = notExists(scheduleOfLessons, lessonTitle);
        if (counter != scheduleOfLessons.size()){
            if (scheduleOfLessons.contains(lessonTitle+"-Exercise")){
                return;
            }
            int index = scheduleOfLessons.indexOf(lessonTitle);
            scheduleOfLessons.add(index + 1, lessonTitle + "-Exercise");
        } else {
            scheduleOfLessons.add(lessonTitle);
            scheduleOfLessons.add(lessonTitle + "-Exercise");
        }
    }
}
