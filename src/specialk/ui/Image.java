package specialk.ui;

/**
* Contains information about an image that is going to be displayed on a card.
*/
public class Image {
private String smallImageUrl;
private String largeImageUrl;

/**
 * Returns the URL of the small image.
 *
 * @return the URL of the small image
 */
public String getSmallImageUrl() {
    return smallImageUrl;
}

/**
 * Sets the URL of the small image.
 *
 * @param smallImageUrl
 *            the URL to be set
 */
public void setSmallImageUrl(String smallImageUrl) {
    this.smallImageUrl = smallImageUrl;
}

/**
 * Returns the URL of the large image.
 *
 * @return the URL of the large image
 */
public String getLargeImageUrl() {
    return largeImageUrl;
}

/**
 * Sets the URL of the large image.
 * 
 * @param largeImageUrl
 *            the URL to be set
 */
public void setLargeImageUrl(String largeImageUrl) {
    this.largeImageUrl = largeImageUrl;
}
}
