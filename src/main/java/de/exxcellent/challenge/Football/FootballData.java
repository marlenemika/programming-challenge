package de.exxcellent.challenge.Football;

import de.exxcellent.challenge.CustomFileReader.CsvFileReader.InvalidLineException;

public class FootballData {

    private String team;
    private int goalsScored, goalsAllowed;

    public FootballData(String team, int goalsScored, int goalsAllowed) {
        this.team = team;
        this.goalsScored = goalsScored;
        this.goalsAllowed = goalsAllowed;
    }

    public FootballData(String[] contents) {
        try {
            this.team = contents[0];
            this.goalsScored = Integer.parseInt(contents[5]);
            this.goalsAllowed = Integer.parseInt(contents[6]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidLineException("Invalid data in line: " + String.join(",", contents));
        }
    }

    public String getTeam() {
        return team;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    /**
     * @return the absolute difference between goalsScored and goalsAllowed
     */
    public int getGoalsDifference() {
        return Math.abs(goalsScored - goalsAllowed);
    }

    @Override
    public String toString() {
        return String.format("Team: %s, goalsScored: %d, goalsAllowed: %d", team, goalsScored, goalsAllowed);
    }

    @Override
    public boolean equals(Object obj) {

        // Object is compared with itself
        if (obj == this) return true;

        // Comparing object is not instance of FootballData
        if (!(obj instanceof FootballData)) return false;

        // Parse comparing object to FootballData object in order to compare
        FootballData other = (FootballData) obj;

        return other.team.equals(this.team) &&
                other.goalsScored == this.goalsScored &&
                other.goalsAllowed == this.goalsAllowed;
    }
}