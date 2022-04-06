package com.example.demo;

import com.example.demo.Model.Notes;
import com.example.demo.Repository.NotesRepository;
import com.example.demo.TelegrambotApi.Telegrambot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		try {
//			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//			botsApi.registerBot(new Telegrambot());
//		} catch (TelegramApiException e) {
//			e.printStackTrace();
//		}


	}

	@Autowired
	NotesRepository notesRepository;
	@Override
	public void run(String... args) throws Exception {

//		Optional<Notes> byId = notesRepository.findById(10);
//		Notes notes = byId.get();
//		notes.setTitle("mohit");
//		notesRepository.save(notes);
	}
}
