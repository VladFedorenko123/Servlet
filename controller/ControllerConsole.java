package com.srccode.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srccode.clas.JsonBuilder;
import com.srccode.enums.InputType;
import com.srccode.interfaces.Json;

@WebServlet("/consoleController")
public class ControllerConsole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Json json = new JsonBuilder();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = "vlad";
		String inputType = InputType.CONSOLE.getInputType();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println(json.beautifuleJson(inputType, text));
	}
}
