package com.example.turtlearmorsecurity;
import java.util.Random;

public class OTPGenerator {

    public static String generateOTP() {
        String allowedChars = "0123456789";

        StringBuilder otp = new StringBuilder();

        Random random = new Random();
        int length = 6;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(index);
            otp.append(randomChar);
        }
        return otp.toString();
    }

    public static void main(String[] args) {
        String otp = generateOTP();

        System.out.println("Generated OTP: " + otp);
    }
}
