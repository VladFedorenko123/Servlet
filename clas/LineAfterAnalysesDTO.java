package com.srccode.clas;

import java.sql.Timestamp;
import java.util.Date;

public class LineAfterAnalysesDTO {
	private int vowelsNumber;
	private int consonantsNumber;
	private Timestamp timestamp;

	public LineAfterAnalysesDTO() {

	}

	public LineAfterAnalysesDTO(int vowelsNumber, int consonantsNumber, Timestamp timestamp) {
		this.vowelsNumber = vowelsNumber;
		this.consonantsNumber = consonantsNumber;
		this.timestamp = timestamp;
	}

	public int getVowelsNumber() {
		return vowelsNumber;
	}

	public void setVowelsNumber(int vowelsNumber) {
		this.vowelsNumber = vowelsNumber;
	}

	public int getConsonantsNumber() {
		return consonantsNumber;
	}

	public void setConsonantsNumber(int consonantsNumber) {
		this.consonantsNumber = consonantsNumber;
	}

	public Date getTimestamp() {
		return (Date) timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
