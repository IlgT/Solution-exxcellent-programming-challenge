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
//        Todo: Implement
        List<String> names = new ArrayList<>();

        return names;
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
//        Todo: Implement
        List<String> returnList = new ArrayList<>();
        return returnList;
    }
}
