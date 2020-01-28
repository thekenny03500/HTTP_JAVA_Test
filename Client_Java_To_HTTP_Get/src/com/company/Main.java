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

        char[] buff = new char[1000];

        sortie.print("GET /index.html HTTP/1.1\r\nHost: localhost\r\n\r\n");

        while ((line = keyboardSoc.readLine()) != null)
        {
            if(line.contains("</body>"))
                isbody = false;
            if(isbody)
                System.out.println(line);
            if (line.contains("<body>"))
                isbody = true;
        }

        socket.close();
    }
}
