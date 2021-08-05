package com.srccode.enums;

public enum InputType {
	CONSOLE("Console"), MYSQL("MySQL"), MONGODB("MongoDB"), FILE("File");

	private final String inputType;

	InputType(String inputType) {
		this.inputType = inputType;
	}

	public String getInputType() {
		return inputType;
	}
}
