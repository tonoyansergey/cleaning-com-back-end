package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "home_cleaning")
public class HomeCleaning {

    @Id
    private String id;
    private String title;
    private String definition;
    private String angularComponent;
    private String pricePerSquare;
    private String photo;

    public HomeCleaning() {
    }

    public HomeCleaning(final String id, final String title, final String definition, final String angularComponent, final String pricePerSquare, final String photo) {
        this.id = id;
        this.title = title;
        this.definition = definition;
        this.angularComponent = angularComponent;
        this.pricePerSquare = pricePerSquare;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(final String definition) {
        this.definition = definition;
    }

    public String getAngularComponent() {
        return angularComponent;
    }

    public void setAngularComponent(final String angularComponent) {
        this.angularComponent = angularComponent;
    }

    public String getPricePerSquare() {
        return pricePerSquare;
    }

    public void setPricePerSquare(final String pricePerSquare) {
        this.pricePerSquare = pricePerSquare;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }
}
