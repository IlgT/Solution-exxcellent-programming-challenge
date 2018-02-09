package de.exxcellent.challenge;

import de.exxcellent.calculator.Calculations;

import java.util.List;

/**
 * The entry class for this solution.
 *
 * @author Tobias Ilg <tobias.ilg@gmx.net>
 */
public final class App {
    /**
     * The main method,
     *
     * @param args Command line parameters
     *
     * @author Tobias Ilg <tobias.ilg@gmx.net>
     */
    public static void main(String... args) {

        String weatherFilePath = "src/main/resources/de/exxcellent/challenge/weather.csv";
        List<String> daysWithSmallestTempSpread = Calculations.getElementsByDifference(weatherFilePath,"Day",
                "MxT", "MnT");

        int counter = 0;
        for (String day: daysWithSmallestTempSpread) {
            if (counter == 0) {
                System.out.printf("Day(s) with smallest temperature spread : %s.", day);
                counter++;
            } else {
                System.out.printf(" and %s.", day);
                counter++;
            }
        }
        System.out.printf("%n");

        String footballFilePath = "src/main/resources/de/exxcellent/challenge/football.csv";
        List<String> teamsWithSmallestGoalSpread = Calculations.getElementsByDifference(footballFilePath,"Team",
                "Goals", "Goals Allowed");

        counter = 0;
        for (String team: teamsWithSmallestGoalSpread) {
            if (counter == 0) {
                System.out.printf("Team(s) with smallest goal spread       : %s", team);
                counter++;
            } else {
                System.out.printf(" and %s", team);
                counter++;
            }
        }
        System.out.printf("%n");
    }
}
