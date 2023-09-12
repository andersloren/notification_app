package org.example;

import org.example.exception.InvalidEmailException;
import org.example.model.EmailNotification;
import org.example.model.Notification;

public class App
{
    public static void main( String[] args ) {

        try {
            Notification notification = new EmailNotification("mehrdad.java@lexicon.se", "Meeting reminder", "Don't forget the meeting at 15:00");
            notification.send();
            System.out.println(notification.summary());
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }
}
