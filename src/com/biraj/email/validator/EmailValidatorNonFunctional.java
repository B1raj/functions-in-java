package com.biraj.email.validator;

import java.util.regex.Pattern;

public class EmailValidatorNonFunctional {

    private Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");

     void testEmail(String email){
        if(emailPattern.matcher(email).matches()){
            sendVerificationEmail(email);
        }else {
            System.out.println(String.format("email %s is invalid", email));
        }
    }

    private void sendVerificationEmail(String email) {
        System.out.println(String.format("verification email sent to %s",email));
    }

    public static void main(String[] args) {

        EmailValidatorNonFunctional ob =new EmailValidatorNonFunctional();
        ob.testEmail("BIRAJ@hello.com");
        //ob.testEmail(null);

    }


}
