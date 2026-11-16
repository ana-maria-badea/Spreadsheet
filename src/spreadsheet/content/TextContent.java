
package spreadsheet.content;

public class TextContent extends Content {

    private String text;

    public TextContent(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }

    public String getText() {
        return text;
    }
}
