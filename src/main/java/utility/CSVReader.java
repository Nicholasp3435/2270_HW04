package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//345678901234567890123456789012345678901234567890123456789012345678901234567890


/**
 * <strong>CSVReader</strong> - Reads a CSV file and returns a list of records.
 * Each record is represented as a List&lt;String&gt;, corresponding to a column
 * in the CSV file. This results in a List&lt;List&lt;String&gt;&gt; structure,
 * where the outer list contains all rows, and each inner list contains the
 * values for a specific row. The first row, potentially serving as a header, is treated
 * the same as any other row.<br><br>
 * <p>
 * The method returns a list of records, enabling access to any cell in the
 * CSV file by row and column index. Data is stored as text (String), with
 * interpretation left to the caller.<br><br>
 * </p>
 * <strong>Note:</strong> Fully provided to students as part of an educational
 * toolkit for Java. Intended to illustrate file reading and parsing in the
 * context of data structures and algorithms. Unauthorized distribution or
 * publishing online or on other platforms is not allowed.<br><br>
 *
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */

public class CSVReader {
    public static List<List<String>> readCSV(String filePath) {

        // This list will hold all records read from the CSV file.
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read the file line by line
            String line;
            while ((line = br.readLine()) != null) {

                // Remove extraneous whitespace characters, if any, but leave (intentional) spaces intact.
                line = line.replaceAll("[\\t\\n\\x0B\\f\\r]+", "");
                // Remove non-breaking spaces
                line = line.replace("\u00A0", "");

                // Split the line into individual values using a comma as the delimiter.
                //      NOTE: if CVS file use different delimiter change this
                String[] values = line.split(",");

                // Create a new list to hold the values for this record.
                List<String> record = new ArrayList<>();
                for (String value : values) {
                    // Trim leading and trailing whitespace from each value and add to the record.
                    record.add(value.trim());
                }
                // Add the record to the list of all records.
                records.add(record);
            }
        } catch (IOException e) {
            // Return the list of records read from the CSV file.
            e.printStackTrace();
        }
        return records;
    }
}