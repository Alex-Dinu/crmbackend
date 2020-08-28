package com.ceme.crm.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments") // The collection name in Mongo
public class InteractionModel {
    @Id
    private ObjectId id;
    private String customerID;
    private Date dateCreated;
    private String comments;

    public InteractionModel() {
    }

    public InteractionModel(String customerID, Date dateCreated, String comments) {
        this.customerID = customerID;
        this.dateCreated = dateCreated;
        this.comments = comments;
    }

    public Date getDateTime() {
        return dateCreated;
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

    public Object get() {
        return null;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

}