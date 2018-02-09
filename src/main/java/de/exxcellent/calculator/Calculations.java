package de.exxcellent.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * The Calculations class will run to calculate the difference between two sets of data
 *
 * @author Tobias Ilg <tobias.ilg@gmx.net>
 */
public class Calculations {

    /**
     * A method that makes all the preparations for the calculation.
     *
     * @param filePath The path of the file to be read
     * @param nameTag The Tag of the desired String-values to be read
     * @param firstValueTag The Tag of the desired first Integer-values to be read
     * @param secondValueTag The Tag of the desired first Integer-values to be read
     * @return The result of the calculation as a list of strings
     *
     * @author Tobias Ilg <tobias.ilg@gmx.net>
     */
    public static List<String> getElementsByDifference(String filePath, String nameTag, String firstValueTag,
                                                       String secondValueTag) {
        List<String>  names = de.exxcellent.io.Import.getColumnStrings(filePath, nameTag);
        List<Integer> firstValues = de.exxcellent.io.Import.getColumnIntegers(filePath, firstValueTag);
        List<Integer> secondValues = de.exxcellent.io.Import.getColumnIntegers(filePath, secondValueTag);

        return getElementsWithLowestDifference(names, firstValues, secondValues);
    }

    /**
     * A method to find the name of the smallest difference between two lists.
     *
     * @param nameList List of imported names
     * @param firstValues List of the first imported values
     * @param secondValues List of the first imported values
     * @return The result of the calculation as a list of strings
     *
     * @author Tobias Ilg <tobias.ilg@gmx.net>
     */
    private static List<String> getElementsWithLowestDifference(List<String> nameList, List<Integer> firstValues,
                                                                List<Integer> secondValues) {
        int minDifference = Integer.MAX_VALUE;
        List<String> returnList = new ArrayList<>();
        for (int i = 0; i < firstValues.size(); i++) {
            int difference = Math.abs(firstValues.get(i) - secondValues.get(i));
            if (difference < minDifference) {
                minDifference = difference;
                returnList.clear();
                returnList.add(nameList.get(i));
            } else if (difference == minDifference) {
                returnList.add(nameList.get(i));
            }
        }
        return returnList;
    }
}
