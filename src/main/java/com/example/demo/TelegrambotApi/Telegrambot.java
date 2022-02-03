package com.example.demo.TelegrambotApi;

import com.example.demo.SummeryAPI.APICall;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class Telegrambot extends TelegramLongPollingBot {

    public static String token = "1828432941:AAEqmigiaaOmYSR9yEhb54F-x4B-4F7j0Ys";

    public String name = null;

    public void onUpdateReceived(Update update) {
        APICall ap = new APICall();

        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            String chat_id = update.getMessage().getChatId().toString();
            System.out.println(chat_id + "  " + message_text);

            String check = null;
            try {
                check = ap.check(message_text);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SendMessage message = new SendMessage(); // Create a message object object
            message.setChatId(chat_id);
            message.setText(check);


            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        // TODO Auto-generated method stub
        return "kakashi107_bot";
    }

    @Override
    public String getBotToken() {
        // TODO Auto-generated method stub
        return token;
    }
}