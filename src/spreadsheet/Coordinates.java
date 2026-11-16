
package spreadsheet;

public class Coordinates {

    private int row;
    private int column;

    public Coordinates(int row, int column) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException("Invalid coordinates");
        }

        this.row = row;
        this.column = column;
    }

    public Coordinates(String reference) {
        reference = reference.toUpperCase();

        if (!reference.matches("[A-Z]+[1-9][0-9]*")) {
            throw new IllegalArgumentException("Invalid cell reference");
        }

        int i = 0;
        int col = 0;

        while (i < reference.length() &&
                Character.isLetter(reference.charAt(i))) {
            col = col * 26 + (reference.charAt(i) - 'A' + 1);
            i++;
        }

        this.column = col;
        this.row = Integer.parseInt(reference.substring(i));
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
