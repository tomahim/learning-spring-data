package com.book.library;

import com.github.mongobee.Mongobee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public Mongobee mongobee(){
		Mongobee runner = new Mongobee("mongodb://localhost:27017/library");
		runner.setDbName("library");         // host must be set if not set in URI
		runner.setChangeLogsScanPackage("com.book.library.changelogs"); // the package to be scanned for changesets
		return runner;
	}
}
