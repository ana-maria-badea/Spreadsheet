
package spreadsheet;

import spreadsheet.content.*;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Spreadsheet sheet = new Spreadsheet();
        FileManager fileManager = new FileManager();

        int option;

        do {
            System.out.println("\n1. Set cell content");
            System.out.println("2. View cell content");
            System.out.println("3. Save spreadsheet");
            System.out.println("4. Load spreadsheet");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());

                if (option == 1) {
                    System.out.print("Cell (ex: A2): ");
                    Coordinates coordinate =
                            new Coordinates(scanner.nextLine());

                    System.out.print("Content: ");
                    String value = scanner.nextLine();

                    Content content;

                    if (value.startsWith("=")) {
                        content = new FormulaContent(value);
                    } else {
                        try {
                            content = new NumberContent(Double.parseDouble(value));
                        } catch (NumberFormatException e) {
                            content = new TextContent(value);
                        }
                    }

                    sheet.setCellContent(
                            coordinate.getRow(),
                            coordinate.getColumn(),
                            content
                    );
                }

                if (option == 2) {
                    System.out.print("Cell (e.g. A2): ");
                    Coordinates coordinate =
                            new Coordinates(scanner.nextLine());

                    System.out.println("Content: " +
                            sheet.getCellContent(
                                    coordinate.getRow(),
                                    coordinate.getColumn()
                            ));
                }

                if (option == 3) {
                    System.out.print("Filename: ");
                    String filename = scanner.nextLine();

                    fileManager.saveSpreadsheet(sheet, filename);
                    System.out.println("Spreadsheet saved.");
                }

                if (option == 4) {
                    System.out.print("Filename: ");
                    String filename = scanner.nextLine();

                    sheet = fileManager.loadSpreadsheet(filename);
                    System.out.println("Spreadsheet loaded.");
                }

            } catch (IOException e) {
                System.out.println("File error: " + e.getMessage());
                option = -1;

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                option = -1;
            }

        } while (option != 0);

        scanner.close();
    }
}
