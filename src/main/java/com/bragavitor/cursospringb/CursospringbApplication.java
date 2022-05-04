package com.bragavitor.cursospringb;

import com.bragavitor.cursospringb.domain.*;
import com.bragavitor.cursospringb.domain.enums.*;
import com.bragavitor.cursospringb.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursospringbApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursospringbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
