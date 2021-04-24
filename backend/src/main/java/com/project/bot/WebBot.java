package com.project.bot;

import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class WebBot extends TelegramWebhookBot {

    private String botUsername= "SunEclipseBot";
    private String botToken = "1745907536:AAEhvVpDfFBymxlITCXaiyD3sCfcAdtJgvo";

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        long chatId = update.getMessage().getChatId();
        message.setChatId(String.valueOf(chatId));

        message.setText("blablabla");

        return message;
    }

    @Override
    public String getBotPath() {

        return getBotUsername();
    }
}
