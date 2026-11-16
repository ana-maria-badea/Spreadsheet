
package spreadsheet.content;

public class NumberContent extends Content {

    private double number;

    public NumberContent(double number) {
        this.number = number;
    }

    @Override
    public String getContent() {
        return Double.toString(number);
    }

    public double getNumber() {
        return number;
    }
}
