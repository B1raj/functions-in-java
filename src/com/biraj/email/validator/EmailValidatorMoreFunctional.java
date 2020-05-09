package com.biraj.email.validator;

import java.util.function.Function;
import java.util.regex.Pattern;

interface Effect<T> {
    void apply(T t);
}
interface FinalResult<T>{
    void bind(Effect<T> success,Effect<T> failure );

    static <T> FinalResult<T> failure(String message){
        return new Failure(message);
    }
    static <T> FinalResult<T> success(String value){
        return new Success(value);
    }

    class Success<T> implements FinalResult<T>{
        private final T value;

        public Success(T t) {
            value = t;
        }
        @Override
        public void bind(Effect success, Effect failure) {
            success.apply(value);
        }
    }
    class Failure<T> implements FinalResult<T>{
        private final T message;

        public Failure(T s) {
            message = s;
        }
        public T getMessage(){
            return  message;
        }
        @Override
        public void bind(Effect success, Effect failure) {
            failure.apply(message);
        }
    }
}
public class EmailValidatorMoreFunctional {
    private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    static Function<String, FinalResult<String>> emailChecker = email -> {
        return null == email ? new FinalResult.Failure(String.format("email address must not be null")):
                email.trim().length()==0? new FinalResult.Failure(String.format("email address must not be blank")):
                        emailPattern.matcher(email).matches()?
                                new FinalResult.Success(email):
                                new FinalResult.Failure(String.format("email address must not be invalid"));
    };

    static void sendVerificationEmail(String email) {
        System.out.println(String.format("verification email sent to %s",email));
    }

    static Effect<String> success = email ->  sendVerificationEmail(email);
    static Effect<String> failure = message ->  System.out.println("Error message logged :: " + message);

    public static void main(String[] args) {
        emailChecker.apply("biraj@hello.com").bind(success,failure);
        emailChecker.apply("").bind(success,failure);
        emailChecker.apply(null).bind(success,failure);
    }


}
