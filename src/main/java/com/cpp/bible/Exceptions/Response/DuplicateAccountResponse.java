package com.cpp.bible.Exceptions.Response;

public class DuplicateAccountResponse {

    private String username;
    public DuplicateAccountResponse(String username) {this.username = username;}
    public String getUsername() {return this.username;}
    public void setUsername(String username) {this.username = username;}

}
