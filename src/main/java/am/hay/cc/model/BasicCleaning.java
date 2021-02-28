package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "basic_cleaning")
public class BasicCleaning {

    @Id
    private String id;
    private String title;
    private String description;
    private Map<String, List<String>> services;
    private List<BaseCleaning> baseCleanings;

    public BasicCleaning(final String id, final String title, final String description, final Map<String, List<String>> services, final List<BaseCleaning> baseCleanings) {
        this.id = id;
        this.title = title;
        this.services = services;
        this.description = description;
        this.baseCleanings = baseCleanings;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<BaseCleaning> getBaseCleanings() {
        return baseCleanings;
    }

    public void setBaseCleanings(final List<BaseCleaning> baseCleanings) {
        this.baseCleanings = baseCleanings;
    }

    public Map<String, List<String>> getServices() {
        return services;
    }

    public void setServices(final Map<String, List<String>> services) {
        this.services = services;
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
}
