package am.hay.cc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {

    @Id
    private String id;
    private String cleaningTypeId;
    private String clientName;
    private String clientEmail;
    private String clientPhoneNumber;
    private Integer square;

    public Order() {
    }

    public Order(final String id, final String cleaningTypeId, final String clientName, final String clientEmail, final String clientPhoneNumber, final Integer square) {
        this.id = id;
        this.cleaningTypeId = cleaningTypeId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.square = square;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCleaningTypeId() {
        return cleaningTypeId;
    }

    public void setCleaningTypeId(final String cleaningTypeId) {
        this.cleaningTypeId = cleaningTypeId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(final String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(final String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(final Integer square) {
        this.square = square;
    }
}
