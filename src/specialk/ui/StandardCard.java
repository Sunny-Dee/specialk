package specialk.ui;

import com.amazon.speech.ui.Card;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A standard card that includes a title, a text content and an image.
 */
@JsonTypeName("Standard")
public class StandardCard extends Card {
    private String text;
    private Image image;

    /**
     * Returns the text of the card.
     *
     * @return the text of the card
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the card.
     *
     * @param text
     *            the text to be set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the image of the card.
     *
     * @return the image of the card
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image of the card.
     *
     * @param image
     *            the image to be set
     */
    public void setImage(Image image) {
        this.image = image;
    }
}
