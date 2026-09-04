package softwareProj;

public class Progress {
    private String programTitle;
    private int attendedSessions;
    private int totalSessions;
    private boolean isCompleted;
    private double weightLossGoal;
    private double currentWeightLoss;

    public Progress(String programTitle, int totalSessions, double weightLossGoal) {
        if (programTitle == null || programTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Program title cannot be null or empty.");
        }
        if (totalSessions <= 0) {
            throw new IllegalArgumentException("Total sessions must be greater than zero.");
        }
        if (weightLossGoal < 0) {
            throw new IllegalArgumentException("Weight loss goal cannot be negative.");
        }

        this.programTitle = programTitle;
        this.totalSessions = totalSessions;
        this.weightLossGoal = weightLossGoal;
        this.attendedSessions = 0;
        this.isCompleted = false;
        this.currentWeightLoss = 0.0;
    }

    public Progress(String programTitle, String isCompleted2, int attendedSessions) {
    	this.programTitle = programTitle;
        this.isCompleted = isCompleted;
        this.attendedSessions = attendedSessions;
	}

	public String getProgramTitle() {
        return programTitle;
    }

    public int getAttendedSessions() {
        return attendedSessions;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public double getWeightLossGoal() {
        return weightLossGoal;
    }

    public double getCurrentWeightLoss() {
        return currentWeightLoss;
    }

    public void attendSession() {
        if (attendedSessions < totalSessions) {
            attendedSessions++;
    }
    }

    public void completeProgram() {
    	
    	
        this.isCompleted = true; }

    public void updateWeightLoss(double weightLoss) {
        if (weightLoss < 0) {
        	
            throw new IllegalArgumentException("Weight loss cannot be negative.");
            
                }
                     this.currentWeightLoss = weightLoss;
 }

    public String getProgressBar() {
    	
        int progress = (int) ((double) attendedSessions / totalSessions * 100);
        
        return progress + "% completed";  
        
 }

    public boolean isWeightLossGoalAchieved() {
    	
        return currentWeightLoss >= weightLossGoal;  }
}
