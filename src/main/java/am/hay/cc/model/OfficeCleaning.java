package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "office_cleaning")
public class OfficeCleaning {

    @Id
    private String id;
    private String title;
    private String description;
    private Map<String, String> cleaningTypes;
    private Map<String, List<String>> services;
    private String photo;

    public OfficeCleaning(final String id, final String title, final String description, final Map<String, String> cleaningTypes, final Map<String, List<String>> services, final String photo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cleaningTypes = cleaningTypes;
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

    public Map<String, String> getCleaningTypes() {
        return cleaningTypes;
    }

    public void setCleaningTypes(final Map<String, String> cleaningTypes) {
        this.cleaningTypes = cleaningTypes;
    }

    public Map<String, List<String>> getServices() {
        return services;
    }

    public void setServices(final Map<String, List<String>> services) {
        this.services = services;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }
}
