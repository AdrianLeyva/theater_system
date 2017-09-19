package utils;

/*
    This class contents a generic message to response another module for any purpose.

    author: Adrián Leyva Sánchez
 */

public class MessageBack {
    private String subject;
    private String content;
    private String typeOfMessage;
    private Class sentBy;

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    public static final String NULL = "NULL";
    public static final String UNIDENTIFIED = "UNIDENTIFIED";
    public static final String AUTHORIZED = "AUTHORIZED";
    public static final String UNAUTHORIZED = "UNAUTHORIZED";



    public MessageBack() {
    }

    public MessageBack(String subject, String content, String typeOfMessage, Class sentBy) {
        this.subject = subject;
        this.content = content;
        this.typeOfMessage = typeOfMessage;
        this.sentBy = sentBy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeOfMessage() {
        return typeOfMessage;
    }

    public void setTypeOfMessage(String typeOfMessage) {
        this.typeOfMessage = typeOfMessage;
    }

    public Class getSentBy() {
        return sentBy;
    }

    public void setSentBy(Class sentBy) {
        this.sentBy = sentBy;
    }

    @Override
    public String toString() {
        String line;
        line = "Subject: " + subject + " || " + "Content: " + content + " || " +
                "Type of message: " + typeOfMessage + " || " + "Sent by: " + sentBy;
        return line;
    }
}
