package com.ceme.crm.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "interactions") // The collection name in Mongo
public class InteractionModel {
    @Id
    private ObjectId id;
    private String customerId;
    private Date dateCreated;
    private String comments;

    public InteractionModel() {
    }

    public InteractionModel(String customerId, String comments) {
        this.customerId = customerId;
        this.dateCreated = new Date();
        this.comments = comments;
    }

    public String getDateTime() {
        return dateCreated.toString();
    }

    public void setDateTime(Date dateTime) {
        this.dateCreated = dateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // public Object get() {
    // return null;
    // }

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}