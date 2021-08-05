package com.srccode.clas;

import com.srccode.dto.LineAfterAnalysesDTO;
import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.Json;
import com.srccode.interfaces.Time;
import com.srccode.interfaces.Vowels;

public class JsonBuilder implements Json {

	Consonants consonants = new ConsonantsCalculator();
	Vowels vowels = new VowelsCalculator();
	Time time = new TimeStamp();

	@Override
	public String beautifuleJson(String inputType, String text) {
		LineAfterAnalysesDTO dtoFile = new LineAfterAnalysesDTO(consonants.getConsonants(text), vowels.getVowels(text),
				time.getTime());
		String textFile = "{\n " + inputType + ": \n" + " Text: \"" + text + "\"\n Consonant: "
				+ dtoFile.getConsonantsNumber() + "\n Vowel: " + dtoFile.getVowelsNumber() + "\n Timestamp: "
				+ dtoFile.getTimestamp() + "\n}";
		return textFile;
	}
}
