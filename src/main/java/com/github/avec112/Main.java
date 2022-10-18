package com.github.avec112;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        new MyCsvProcessor().process();
    }

}