package com.srccode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srccode.clas.JsonBuilder;
import com.srccode.clas.MongoDBConnection;
import com.srccode.enums.InputType;
import com.srccode.interfaces.ConnectMongo;
import com.srccode.interfaces.Json;

@WebServlet("/mongoDBController")
public class ControllerMongoDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectMongo text = new MongoDBConnection();
	Json json = new JsonBuilder();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String inputType = InputType.MONGODB.getInputType();
		response.setContentType("text/html");
		String textMongo = text.connection();
		writer.println(json.beautifuleJson(inputType, textMongo));
	}

}
