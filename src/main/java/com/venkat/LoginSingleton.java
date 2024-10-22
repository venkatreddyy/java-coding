package com.venkat;

//three way

//1) Multithreaded environment we can use static inner calls
// 2) we can create making constructory private , static method

public class LoginSingleton {
    public static LoginSingleton INSTANCE = null;
    private  LoginSingleton() {

    }
    
    static LoginSingleton getInstance() {
        if(INSTANCE !=null) {
            return  INSTANCE;
        }
     synchronized (INSTANCE) {
         if(INSTANCE == null) {
           return   INSTANCE = new LoginSingleton();
         }
     }
        return   INSTANCE;
    }

}
