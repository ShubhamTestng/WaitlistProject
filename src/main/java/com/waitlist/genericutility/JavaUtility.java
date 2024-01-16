package com.waitlist.genericutility;

import java.time.LocalDateTime;

public class JavaUtility {

	public String timeStamp() {
		String timestamp = LocalDateTime.now().toString().replace(':','-');
		return timestamp;
	}
}
