package com.srccode.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srccode.clas.ConsonantsCalcualator;
import com.srccode.clas.LineAfterAnalysesDTO;
import com.srccode.clas.TimeStamp;
import com.srccode.clas.VowelsCalculator;
import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.Time;
import com.srccode.interfaces.Vowels;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Consonants consonants = new ConsonantsCalcualator();
	Vowels vowels = new VowelsCalculator();
	Time time = new TimeStamp();

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
		LineAfterAnalysesDTO dto = new LineAfterAnalysesDTO(consonants.getConsonants(text), vowels.getVowels(text),
				time.getTime());
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("Text: \"" + text + "\"\nConsonant: " + dto.getConsonantsNumber() + "\nVowel: "
				+ dto.getVowelsNumber() + "\nTimestamp: " + dto.getTimestamp());

	}

}
