package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "after_repair_cleaning")
public class AfterRepairCleaning {

    @Id
    private String id;
    private String title;
    private String description;
    private List<String> services;
    private String photo;

    public AfterRepairCleaning(final String id, final String title, final String description, final List<String> services, final String photo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.services = services;
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

    public List<String> getServices() {
        return services;
    }

    public void setServices(final List<String> services) {
        this.services = services;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }
}
