package com.ecommerceapp.points.validator;



public class pointsValidattor {
	
	public static void validate(long mobile) throws Exception {
		String mobileNo=Long.toString(mobile);
		if (mobileNo.length() != 10) {
			throw new Exception("Enter a valid mobileno");
		}
	}
}
