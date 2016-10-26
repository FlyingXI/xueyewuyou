package com.lzu.homework_easy.homework_check;

/**
 * Created by Administrator on 2016/10/3.
 */
public class Message {
    private String message_type;
    private String message_time;
    private String message_view;
    Message(String message_type,String message_time,String message_view){
        this.message_type = message_type;
        this.message_time = message_time;
        this.message_view = message_view;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public String getMessage_time() {
        return message_time;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }

    public String getMessage_view() {
        return message_view;
    }

    public void setMessage_view(String message_view) {
        this.message_view = message_view;
    }
}
