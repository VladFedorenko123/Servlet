package com.srccode.clas;

import java.sql.Timestamp;

import com.srccode.interfaces.Time;

public class TimeStamp implements Time {
	@Override
	public Timestamp getTime() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return (time);
	}
}
