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
        String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1);
        switch (fileExtension) {
            case "csv":
                return getColumnCSV(filePath, nameTag);

            default:
                throw new IllegalArgumentException("File format (." + fileExtension + ") is not supported");
        }
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
        String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1);
        switch (fileExtension) {
            case "csv":
                List<String> stringList = getColumnCSV(filePath, nameTag);
                List<Integer> returnList = new ArrayList<>();
                for (String numberString : stringList) {
                    try {
                        returnList.add(Integer.parseInt(numberString));
                    } catch (NumberFormatException exception) {
                        exception.printStackTrace();
                    }
                }
                return returnList;

            default:
                throw new IllegalArgumentException("File format (." + fileExtension + ") is not supported");
        }
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
        List<String> returnList = new ArrayList<>();
        try {
            java.io.BufferedReader FileReader = new java.io.BufferedReader(new java.io.FileReader(
                    new java.io.File(filePath)));

            String row = FileReader.readLine();
            int column = -1;
            if (row != null) {
                String separator = getCSVSeparator(row);
                if (!separator.equals(",")) {
                    row = FileReader.readLine();
                }
                String[] columns = row.split(separator);
                for (int i = 0; i < columns.length; i++) {
                    if (columns[i].equals(nameTag)) {
                        column = i;
                        break;
                    }
                }

                if (column >= 0) {
                    while ((row = FileReader.readLine()) != null) {
                        columns = row.split(separator);
                        if (column < columns.length ) {
                            returnList.add(columns[column]);
                        } else {
                            throw new ArrayIndexOutOfBoundsException("Missing Data");
                        }
                    }
                    FileReader.close();
                    return returnList;
                } else {
                    FileReader.close();
                    throw new IllegalArgumentException("NameTag not Found");
                }
            } else {
                FileReader.close();
                throw new IllegalArgumentException("File was empty");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
        return returnList;
    }

    /**
     * Checks if the CSV file has a separator defined and otherwise returns "," as default.
     *
     * @param row first row of the csv-file
     * @return the separator of the csv-file, if defined, otherwise "," as default
     */
    private static String getCSVSeparator(String row) {
        String separator = ",";
        if (row.contains("sep=")){
            int separatorStartIndex = row.indexOf("sep=") + 4;
            separator = row.substring(separatorStartIndex, separatorStartIndex + 1);
        }
        return separator;
    }
}
