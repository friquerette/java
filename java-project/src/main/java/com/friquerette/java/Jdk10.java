package com.friquerette.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class Jdk10 {

    public static void main(String[] args) throws Exception {
        var message = "Local Variable type inference from JDK10 with 'var'";
        System.out.println(message);
    }
    public static void before() throws Exception {
        URL url = new URL("http://www.orable.com");
        URLConnection con = url.openConnection();
        InputStreamReader is = new InputStreamReader(con.getInputStream());
        Reader reader = new BufferedReader(is);
    }

    public void withLocalVariaableTypeInference() throws Exception {
        var url = new URL("http://www.orable.com");
        var con = url.openConnection();
        var is = new InputStreamReader(con.getInputStream());
        var reader = new BufferedReader(is);
    }

}
