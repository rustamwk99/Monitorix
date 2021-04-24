package com.project.bot;

import com.project.model.MUser;
import com.project.model.WinLog;
import com.project.repository.UserRepository;
import com.project.repository.WinLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {
    private String botUsername= "SunEclipseBot";
    private String botToken = "1745907536:AAEhvVpDfFBymxlITCXaiyD3sCfcAdtJgvo";
    private MUser user;
    private WinLog winLog;
    @Autowired
    private WinLogRepository winLogRepository;

    @Autowired
    private UserRepository userRepository;


    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage()){
            long chatId = update.getMessage().getChatId();
            String inputText = update.getMessage().getText();
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText(inputText);
            try {
                execute(message);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
//            if(inputText.startsWith("/login") && inputText.matches("[^,;]+")){
//                MUser user = userRepository.findUserByLogin(inputText.substring(7));
//                try {
//                    message.setText(user.getLogin()+"\n"+"Введите пароль");
//                } catch (Exception e){
//                    message.setText("Неверный логин");
//                }
//
//            } else message.setText("Вы не авторизованы");
//            if (inputText.startsWith("/password") && inputText.matches("[^,;]+")){
//                String pass = inputText.substring(10);
//                if(bCryptPasswordEncoder.matches(pass,user.getPassword())){
//                    message.setText("Вход выполнен успешно");
//                }
//                try {
//
//
//
//                } catch (Exception e ){
//
//                    message.setText("Неверный пароль");
//                }
//
//            }
//            if(inputText.startsWith("/logout")){
//                user = null;
//                message.setText("Выход");
//
//            }
//
//            if (inputText.startsWith("/logs")){
//                List<WinLog> result = winLogRepository.findAllByLoginAndDescriptionOrDescription(inputText,"Warning","Error");
//
//                for (int i = 0; i < result.size(); i++) {
//                    message.setText(result.get(i).getMessage());
//                    try {
//                        execute(message);
//                    } catch (TelegramApiException e){
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//
//
//
//            try {
//                execute(message);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }

        }

    }

    public void auth(Update update){
        long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();
        if(inputText.equals("auth")){
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText("Hello. This is start message");
            onUpdateReceived(update);
        }
    }
}
