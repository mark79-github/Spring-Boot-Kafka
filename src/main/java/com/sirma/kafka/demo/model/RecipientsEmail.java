package com.sirma.kafka.demo.model;

import java.util.List;

public class RecipientsEmail {

    private List<RecipientModel> recipientModels;

    public RecipientsEmail(List<RecipientModel> recipientModels) {
        this.recipientModels = recipientModels;
    }

    public List<RecipientModel> getRecipientModels() {
        return recipientModels;
    }

    public void setRecipientModels(List<RecipientModel> recipientModels) {
        this.recipientModels = recipientModels;
    }
}
