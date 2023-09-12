package org.example.model;

import org.example.exception.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailNotification extends Notification {

    private String recipient;
    private String subject;
    private String message;

    public EmailNotification(String recipient, String subject, String message) throws InvalidEmailException {
        if (recipient == null) throw new IllegalArgumentException("Recipient is null");
        if (!isValidEmail(recipient)) throw new InvalidEmailException("Recipient is not valid");
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void send() {
//        todo: implement sending email logic
        System.out.println("Email sent successfully!");
    }

    @Override
    public String summary() {
        return "Email Info: " +
                "Id: " + getRequestId() +
                ", DateTime: " + getCreateDateTime() +
                ", Recipient: " + recipient +
                ", Message " + message;
    }

    private boolean isValidEmail(String email){
        //todo: implement a logic to validate the email pattern
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
}
