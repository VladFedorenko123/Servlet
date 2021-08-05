package com.srccode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srccode.clas.JsonBuilder;
import com.srccode.clas.MySQLTextReader;
import com.srccode.enums.InputType;
import com.srccode.interfaces.Json;
import com.srccode.interfaces.Reader;

@WebServlet("/getMySQLDatabaseController")
public class ControllerMySQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Reader text = new MySQLTextReader();
	Json json = new JsonBuilder();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String inputType = InputType.MYSQL.getInputType();
		response.setContentType("text/html");
		String textSQL = text.getText();
		writer.println(json.beautifuleJson(inputType, textSQL));
	}

}
