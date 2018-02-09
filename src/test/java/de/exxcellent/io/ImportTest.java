package de.exxcellent.io;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ImportTest {

    private List<String> testNameList = new ArrayList<>();
    private List<Integer> testFirstIntegerList = new ArrayList<>();

    @Before
    public void setUp() {
        testNameList.add("Test1");
        testNameList.add("Test2");
        testNameList.add("Test3");
        testNameList.add("Test4");

        testFirstIntegerList.add(5);
        testFirstIntegerList.add(78);
        testFirstIntegerList.add(20);
        testFirstIntegerList.add(80);
    }

    @Test
    public void givenFileAndNameTagShouldReadCorrectly() {
        String filePath = "src/test/resources/de/exxcellent/challenge/testFileCorrect.csv";
        List<String> calculatedList = Import.getColumnStrings(filePath,"Test");
        assertEquals(testNameList, calculatedList);
    }

    @Test
    public void givenFileAndIntegerTagShouldReadCorrectly() {
        String filePath = "src/test/resources/de/exxcellent/challenge/testFileCorrect.csv";
        List<Integer> calculatedList = Import.getColumnIntegers(filePath,"Wert1");
        assertEquals(testFirstIntegerList, calculatedList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void givenFileFormatShouldThrowNotSupportedFileformatException() {
        String filePath = "src/test/resources/de/exxcellent/challenge/testFileCorrect.json";
        Import.getColumnIntegers(filePath,"Wert1");
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void givenFileShouldGenerateMissingDataException() {
        String filePath = "src/test/resources/de/exxcellent/challenge/testFileMissingData.csv";
        Import.getColumnIntegers(filePath, "Wert2");
    }

    @Test (expected = IllegalArgumentException.class)
    public void givenTagShouldGenerateNameTagNotFound() {
        String filePath = "src/test/resources/de/exxcellent/challenge/testFileCorrect.csv";
        Import.getColumnIntegers(filePath, "Wert3");
    }
}