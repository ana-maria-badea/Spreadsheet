
package spreadsheet;

import java.util.ArrayList;
import spreadsheet.content.Content;

public class Spreadsheet {

    private ArrayList<Cell> cells;

    public Spreadsheet() {
        cells = new ArrayList<>();
    }

    public void setCellContent(int row, int column, Content content) {
        Coordinates coordinate = new Coordinates(row, column);

        for (Cell cell : cells) {
            if (cell.getCoordinate().getRow() == row &&
                    cell.getCoordinate().getColumn() == column) {

                cell.setContent(content);
                return;
            }
        }

        cells.add(new Cell(coordinate, content));
    }

    public String getCellContent(int row, int column) {
        for (Cell cell : cells) {
            if (cell.getCoordinate().getRow() == row &&
                    cell.getCoordinate().getColumn() == column) {

                return cell.getContent();
            }
        }

        return "";
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }
}
