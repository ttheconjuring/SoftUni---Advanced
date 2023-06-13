package ExamPreparation.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExerciseCounter() {
        return exerciseCount;
    }

    public void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Workout(String type, int exerciseCount) {
        setType(type);
        setExerciseCount(exerciseCount);
        setExercises(new ArrayList<>());
    }

    public void addExercise(Exercise exercise) {
        if (getExerciseCount() < getExerciseCounter()) {
            getExercises().add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        if (!getExercises().isEmpty()) {
            for (Exercise exercise : getExercises()) {
                if (exercise.getName().equals(name)) {
                    if (exercise.getMuscle().equals(muscle)) {
                        return getExercises().remove(exercise);
                    }
                }
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        if (!getExercises().isEmpty()) {
            for (Exercise exercise : getExercises()) {
                if (exercise.getName().equals(name)) {
                    if (exercise.getMuscle().equals(muscle)) {
                        return exercise;
                    }
                }
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (!getExercises().isEmpty()) {
            Exercise mostBurnedCaloriesExercise = getExercises().get(0);
            for (Exercise exercise : getExercises()) {
                if (exercise.getBurnedCalories() > mostBurnedCaloriesExercise.getBurnedCalories()) {
                    mostBurnedCaloriesExercise = exercise;
                }
            }
            return mostBurnedCaloriesExercise;
        }
        return null;
    }

    public int getExerciseCount() {
        return getExercises().size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", getType()));
        getExercises().forEach(exercise -> sb.append(String.format("%s%n", exercise)));
        return sb.toString();
    }

}
