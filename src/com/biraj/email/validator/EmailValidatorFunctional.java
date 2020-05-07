package com.biraj.email.validator;

import java.util.function.Function;
import java.util.regex.Pattern;

interface Executable {
    void exec();
}
interface Result{
    class Success implements Result{}
    class Failure implements Result{
        private final String message;

        public Failure(String s) {
            message = s;
        }
        public String getMessage(){
            return  message;
        }
    }
}
public class EmailValidatorFunctional {
    private static final Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");

    static Function<String, Result> emailChecker = email -> {
        return null == email ? new Result.Failure(String.format("email address must not be null")):
        email.trim().length()==0? new Result.Failure(String.format("email address must not be blank")):
                emailPattern.matcher(email).matches()?
             new Result.Success():
             new Result.Failure(String.format("email address must not be invalid"));
    };

     static void sendVerificationEmail(String email) {
        System.out.println(String.format("verification email sent to %s",email));
    }

     static Function<String,Executable> validate = email -> {
        Result result = emailChecker.apply(email);
       return (result instanceof Result.Failure)
               ? () -> System.out.println(((Result.Failure) result).getMessage())
               : () -> sendVerificationEmail(email);
    };

    public static void main(String[] args) {
        validate.apply("biraj@hello.com").exec();
        validate.apply("").exec();
        validate.apply(null).exec();
    }
}
