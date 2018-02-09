package de.exxcellent.calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.exxcellent.calculator.Calculations.getElementsByDifference;
import static org.junit.Assert.*;

public class CalculationsTest {

    private String filePath;
    private String nameColumn;
    private String firstValueColumn;
    private String secondValueColumn;
    private List<String> resultList = new ArrayList<>();

    @Before
    public void setUp() {
        filePath = "src/test/resources/de/exxcellent/challenge/testFileCorrect.csv";
        nameColumn = "Test";
        firstValueColumn = "Wert1";
        secondValueColumn = "Wert2";

        resultList.add("Test4");
    }

    @Test
    public void givenValuesShouldGenerateCorrectResult() {
        System.out.println(System.getProperty("user.dir"));

        List<String>  calculatedList = getElementsByDifference(filePath, nameColumn,  firstValueColumn, secondValueColumn);
        assertEquals(resultList, calculatedList);
    }
}