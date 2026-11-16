
package spreadsheet.content;

public class FormulaContent extends Content {

    private String formula;

    public FormulaContent(String formula) {
        this.formula = formula;
    }

    @Override
    public String getContent() {
        return formula;
    }
}
