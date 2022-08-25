package com.acheron.offlinecommunication.model;

public enum status {
    TODO("TODO"),
    IN_COMPLETE("In_Complete"),
    COMPLETED("Completed");

    public final String type;

    status(String type) {
        this.type = type;
    }

}


