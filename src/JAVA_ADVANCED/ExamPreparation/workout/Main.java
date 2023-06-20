package ExamPreparation.workout;

public class Main {

    public static void main(String[] args) {
        Workout workout = new Workout("strength", 3);

        Exercise exercise = new Exercise("Bench Press", "chest", 30);

        System.out.println(exercise);

        workout.addExercise(exercise);

        System.out.println(workout.removeExercise("Bench Press", "arms"));
        System.out.println(workout.removeExercise("Bench Press", "chest"));

        System.out.println(workout.getExercise("Bench Press", "chest"));

        Exercise e2 = new Exercise("Deadlift", "back", 50);
        Exercise e3 = new Exercise("Barbell Curl", "biceps", 25);
        Exercise e4 = new Exercise("Squats", "legs", 60);
        Exercise e5 = new Exercise("Deadlift", "legs", 55);

        workout.addExercise(e2);
        workout.addExercise(e3);
        workout.addExercise(e4);
        workout.addExercise(e5);

        Exercise most = workout.getMostBurnedCaloriesExercise();
        System.out.println(most);

        Exercise e = workout.getExercise("Deadlift", "back");
        System.out.println(e);

        System.out.println(workout.getExerciseCount());
        System.out.println(workout.removeExercise("Barbell Curl", "biceps"));

        System.out.println(workout.getStatistics());

    }

}
