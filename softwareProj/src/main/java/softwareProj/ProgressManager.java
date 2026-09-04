package softwareProj;

import java.util.ArrayList;
import java.util.List;

public class ProgressManager {
    private List<Progress> progressList;
    private List<fitness_programs> fitnessProgramsList;

    public ProgressManager() {
        this.progressList = new ArrayList<>();
        this.fitnessProgramsList = new ArrayList<>();
    }

    
    public void addFitnessProgram(fitness_programs program) {
        if (program == null) {
            throw new IllegalArgumentException("Fitness program cannot be null.");
        }
        fitnessProgramsList.add(program);
    }

    
    public List<fitness_programs> getAllFitnessPrograms() {
        return new ArrayList<>(fitnessProgramsList);
    }

   
    public fitness_programs getFitnessProgramByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        for (fitness_programs program : fitnessProgramsList) {
            if (program.getTitle().equalsIgnoreCase(title)) {
                return program;
            }
        }
        return null;
    }

    
    public void addProgress(Progress progress) {
        if (progress == null) {
            throw new IllegalArgumentException("Progress cannot be null.");
        }
        progressList.add(progress);
    }

    
    public List<Progress> getAllProgress() {
        return new ArrayList<>(progressList);
    }

   
    public Progress getProgressByProgramTitle(String programTitle) {
        if (programTitle == null || programTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Program title cannot be null or empty.");
        }
        for (Progress progress : progressList) {
            if (progress.getProgramTitle().equalsIgnoreCase(programTitle)) {
                return progress;
            }
        }
        return null;
    }

    
    public void enrollClientInProgram(String programTitle, User user, String role, int age) {
        fitness_programs program = getFitnessProgramByTitle(programTitle);
        if (program == null) {
            throw new IllegalArgumentException("Program with title " + programTitle + " not found.");
        }
        program.enrollClient(user, role, age);
    }

   
    public void listClientsInProgram(String programTitle) {
        fitness_programs program = getFitnessProgramByTitle(programTitle);
        if (program == null) {
            throw new IllegalArgumentException("Program with title " + programTitle + " not found.");
        }
        program.listEnrolledClients();
    }
}

