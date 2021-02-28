package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "feature")
public class Feature {

    @Id
    private String id;
    private String featureText;
    private String featureIconText;

    public Feature() {
    }

    public Feature(final String id, final String featureText, final String featureIconText) {
        this.id = id;
        this.featureText = featureText;
        this.featureIconText = featureIconText;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFeatureText() {
        return featureText;
    }

    public void setFeatureText(final String featureText) {
        this.featureText = featureText;
    }

    public String getFeatureIconText() {
        return featureIconText;
    }

    public void setFeatureIconText(final String featureIconText) {
        this.featureIconText = featureIconText;
    }
}
