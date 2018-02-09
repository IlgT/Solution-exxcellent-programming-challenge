package de.exxcellent.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The import class will run to import data
 *
 * @author Tobias Ilg <tobias.ilg@gmx.net>
 */
public class Import {

    /**
     * A method that determines the file format and invokes the appropriate method.
     *
     * @param filePath The path of the file to be read
     * @param nameTag The Tag of the desired string-values to be read
     * @return The list of read values as a string
     *
     * @exception IllegalArgumentException File Format is not supported
     *
     * @author Tobias Ilg <tobias.ilg@gmx.net>
     */
    public static List<String> getColumnStrings(String filePath, String nameTag) {
//        Todo: Implement
        List<String> returnList = new ArrayList<>();
        return returnList;
    }

    /**
     * A method that determines the file format and invokes the appropriate method.
     * The read values are parsed into int.
     *
     * @param filePath The path of the file to be read
     * @param nameTag The Tag of the desired string-values to be read
     * @return The list of read values as a int
     *
     * @exception NumberFormatException if it is not possible to parse the string into a int
     * @exception IllegalArgumentException File Format is not supported
     *
     * @author Tobias Ilg <tobias.ilg@gmx.net>
     */
    public static List<Integer> getColumnIntegers(String filePath, String nameTag) {
//        Todo: Implement
        List <Integer> returnList = new ArrayList<>();
        return returnList;
    }

    /**
     * A method to read data from a csv file
     *
     * @param filePath The path of the file to be read
     * @param nameTag The Tag of the desired string-values to be read
     * @return The list of read values as a string
     *
     * @exception ArrayIndexOutOfBoundsException if not every row has the same number of values
     * @exception IllegalArgumentException if the Tag is not included in the file
     * @exception IllegalArgumentException if the file was empty
     *
     * @author Tobias Ilg <tobias.ilg@gmx.net>
     */
    private static List<String> getColumnCSV(String filePath, String nameTag) {
//        Todo: Implement
        List<String> returnList = new ArrayList<>();
        return returnList;
    }

    /**
     * Checks if the CSV file has a separator defined and otherwise returns "," as default.
     *
     * @param row first row of the csv-file
     * @return the separator of the csv-file, if defined, otherwise "," as default
     */
    private static String getCSVSeparator(String row) {
//        Todo: Implement
        String separator = null;
        return separator;
    }
}
