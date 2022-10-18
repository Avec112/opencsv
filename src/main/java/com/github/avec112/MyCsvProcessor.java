package com.github.avec112;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.ClassPathUtils;
import org.apache.commons.lang3.ClassUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MyCsvProcessor {

    public void process() throws IOException, CsvException {
        String fileName = MyCsvProcessor.class.getClassLoader().getResource("file1.csv").getFile();
        CSVParser columnParser = new CSVParserBuilder()
                .withSeparator('>')
                .withIgnoreQuotations(true)
                .build();

        CSVParser parser = new CSVParserBuilder().build();
        try(CSVReader reader = new CSVReaderBuilder(new FileReader(fileName))
                .withCSVParser(parser)
                .build()) {
            List<String[]> rows = reader.readAll();
//            rows.forEach(row -> System.out.println(Arrays.toString(row)));

            rows.forEach(row -> {
                String[] column = row[0].split(";");
                StringTokenizer tokenizer = new StringTokenizer(column[0], ">");
                while(tokenizer.hasMoreTokens()) {
                    System.out.print(tokenizer.nextToken());
                    if(tokenizer.hasMoreTokens()) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
//                String[] column = row[0].split(";");
//                try(CSVReader columnReader = new CSVReaderBuilder(new StringReader(column[0]))
//                        .withCSVParser(columnParser)
//                        .build()) {
//                    List<String[]> values = columnReader.readAll();
//                    values.forEach(value -> System.out.println(Arrays.toString(value)));
//
//                } catch (IOException | CsvException e) {
//                    throw new RuntimeException(e);
//                }
            });


        }
    }
}
