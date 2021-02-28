package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "benefit")
public class Benefit {

    @Id
    private String id;
    private String title;
    private String description;
    private String iconText;

    public Benefit() {
    }

    public Benefit(final String id, final String title, final String description, final String iconText) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.iconText = iconText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconText() {
        return iconText;
    }

    public void setIconText(String iconText) {
        this.iconText = iconText;
    }
}
