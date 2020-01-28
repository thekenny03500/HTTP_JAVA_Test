package com.company;

import java.io.*;
import java.net.*;

public class Main {
    public static int port = 80;
    public static String adresse = "127.0.0.1";
    public static void main(String[] args) throws Exception {
        Reader readSoc;
        String line;
        boolean isbody = false;
        PrintStream sortie = null;
        boolean fin = false;

        Socket socket = new Socket(adresse, port);
        sortie = new PrintStream(socket.getOutputStream());
        readSoc = new InputStreamReader(socket.getInputStream());
        BufferedReader keyboardSoc = new BufferedReader(readSoc);

        sortie.print("POST /index.php HTTP/1.1\r\nHost:localhost\r\nContent-type:application/x-www-form-urlencoded\r\nContent-length:9\r\nConnection:Close\r\n\r\nReponse=5\r\n");

        while ((line = keyboardSoc.readLine()) != null)
        {
            System.out.println(line);
            /*
            if(line.contains("<span id=\"resultat\">"))
                System.out.println(line.subSequence("<span id=\"resultat\">".length()+1, line.length()-"</span>".length()));
             */
        }

        socket.close();
    }
}