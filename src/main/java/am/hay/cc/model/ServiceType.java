package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "service_type")
public class ServiceType {

    @Id
    private String id;
    private String title;
    private String description;
    private String angularComponent;
    private String startingPrice;
    private String photo;

    public ServiceType(final String id, final String title, final String description, final String angularComponent, final String startingPrice, final String photo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.angularComponent = angularComponent;
        this.startingPrice = startingPrice;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getAngularComponent() {
        return angularComponent;
    }

    public void setAngularComponent(final String angularComponent) {
        this.angularComponent = angularComponent;
    }

    public String getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(final String startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }
}
