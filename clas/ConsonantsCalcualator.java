package com.srccode.clas;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import com.srccode.interfaces.Consonants;

public class ConsonantsCalcualator implements Consonants {
	private static final List<Character> CONSONANT = new ArrayList<>((Arrays.asList('b', 'c', 'd', 'f', 'q', 'j', 'k',
			'l', 'm', 'n', 'p', 'q', 's', 't', 'v', 'x', 'z', 'h', 'r', 'w')));

	@Override
	public int getConsonants(String text) {
		int consonantCounter = 0;
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			if (CONSONANT.contains(text.charAt(i))) {
				consonantCounter++;
			}
		}
		return consonantCounter;
	}
}
