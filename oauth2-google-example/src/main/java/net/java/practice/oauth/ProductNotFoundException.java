package net.java.practice.oauth;

public class ProductNotFoundException extends Exception {

    private String message;
    public ProductNotFoundException(){
        super();
    }

    public ProductNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
