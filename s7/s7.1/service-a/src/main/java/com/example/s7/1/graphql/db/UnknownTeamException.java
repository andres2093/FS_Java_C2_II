package com.example.s7.1.graphql.db;

@SuppressWarnings("serial")
public class UnknownTeamException extends Exception {

    public UnknownTeamException(String message) {
        super(message);
    }
}