
package spreadsheet;

import spreadsheet.content.Content;

public class Cell {

    private Coordinates coordinate;
    private Content content;

    public Cell(Coordinates coordinate, Content content) {
        this.coordinate = coordinate;
        this.content = content;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public String getContent() {
        return content.getContent();
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
