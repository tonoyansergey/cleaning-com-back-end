package am.hay.cc.model;

public class BaseCleaning {

    private String category;
    private String photo;

    public BaseCleaning(final String category, final String photo) {
        this.category = category;
        this.photo = photo;
    }

    public BaseCleaning() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }
}
