package com.chat.app.controller;

import com.chat.app.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/message") //Sender sends message in this url
    @SendTo("/topic/return-to") //If clients subscribe this url, then all clients get a message from the sender.
    public Message getContent(@RequestBody Message message) {
        /*try {
            System.out.println("Message :" + message);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return message;
    }

}
