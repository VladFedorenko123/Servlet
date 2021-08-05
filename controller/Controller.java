package com.srccode.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srccode.clas.ConsonantsCalculator;
import com.srccode.clas.MongoDBConnection;
import com.srccode.clas.MySQLTextReader;
import com.srccode.clas.ReadFile;
import com.srccode.clas.TimeStamp;
import com.srccode.clas.VowelsCalculator;
import com.srccode.dto.LineAfterAnalysesDTO;
import com.srccode.interfaces.ConnectMongo;
import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.Reader;
import com.srccode.interfaces.Time;
import com.srccode.interfaces.Vowels;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Consonants consonants = new ConsonantsCalculator();
	Vowels vowels = new VowelsCalculator();
	Time time = new TimeStamp();
	Reader sqlText = new MySQLTextReader();
	Reader fileText = new ReadFile();
	ConnectMongo mongoConnection = new MongoDBConnection();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleRequest(request, response);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = "vlad";
		LineAfterAnalysesDTO dtoConsole = new LineAfterAnalysesDTO(consonants.getConsonants(text),
				vowels.getVowels(text), time.getTime());
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("CONSOLE: \n" + "Text: \"" + text + "\"\nConsonant: " + dtoConsole.getConsonantsNumber()
				+ "\nVowel: " + dtoConsole.getVowelsNumber() + "\nTimestamp: " + dtoConsole.getTimestamp());

		String mongoText = mongoConnection.connection();
		LineAfterAnalysesDTO dtoMongo = new LineAfterAnalysesDTO(consonants.getConsonants(mongoText),
				vowels.getVowels(mongoText), time.getTime());
		writer.println("MONGO: \n" + "Text: \"" + mongoText + "\"\nConsonant: " + dtoMongo.getConsonantsNumber()
				+ "\nVowel: " + dtoMongo.getVowelsNumber() + "\nTimestamp: " + dtoMongo.getTimestamp());

		String mySqlText = sqlText.getText();
		LineAfterAnalysesDTO dtoMySQL = new LineAfterAnalysesDTO(consonants.getConsonants(mySqlText),
				vowels.getVowels(mySqlText), time.getTime());
		writer.println("MySQL: \n" + "Text: \"" + mySqlText + "\"\nConsonant: " + dtoMySQL.getConsonantsNumber()
				+ "\nVowel: " + dtoMySQL.getVowelsNumber() + "\nTimestamp: " + dtoMySQL.getTimestamp());

		String textFile = fileText.getText();
		LineAfterAnalysesDTO dtoFile = new LineAfterAnalysesDTO(consonants.getConsonants(textFile),
				vowels.getVowels(textFile), time.getTime());
		writer.println("MySQL: \n" + "Text: \"" + textFile + "\"\nConsonant: " + dtoFile.getConsonantsNumber()
				+ "\nVowel: " + dtoFile.getVowelsNumber() + "\nTimestamp: " + dtoFile.getTimestamp());

	}

}
