
package spreadsheet;

import spreadsheet.content.*;
import java.io.*;

public class FileManager {

    public void saveSpreadsheet(Spreadsheet sheet, String filename)
            throws IOException {

        PrintWriter writer = new PrintWriter(filename);

        int rows = 0;
        int columns = 0;

        for (Cell cell : sheet.getCells()) {
            rows = Math.max(rows, cell.getCoordinate().getRow());
            columns = Math.max(columns, cell.getCoordinate().getColumn());
        }

        for (int row = 1; row <= rows; row++) {
            int lastColumn = 0;

            for (int col = 1; col <= columns; col++) {
                if (!sheet.getCellContent(row, col).isEmpty()) {
                    lastColumn = col;
                }
            }

            for (int col = 1; col <= lastColumn; col++) {
                if (col > 1) {
                    writer.print(";");
                }

                String value = sheet.getCellContent(row, col);

                if (value.startsWith("=")) {
                    value = value.replace(';', ',');
                }

                writer.print(value);
            }

            writer.println();
        }

        writer.close();
    }

    public Spreadsheet loadSpreadsheet(String filename)
            throws IOException {

        Spreadsheet sheet = new Spreadsheet();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        int row = 1;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(";", -1);

            for (int col = 0; col < values.length; col++) {
                String value = values[col];

                if (!value.isEmpty()) {
                    Content content;

                    if (value.startsWith("=")) {
                        content = new FormulaContent(value.replace(',', ';'));
                    } else {
                        try {
                            content = new NumberContent(Double.parseDouble(value));
                        } catch (NumberFormatException e) {
                            content = new TextContent(value);
                        }
                    }

                    sheet.setCellContent(row, col + 1, content);
                }
            }

            row++;
        }

        reader.close();
        return sheet;
    }
}
