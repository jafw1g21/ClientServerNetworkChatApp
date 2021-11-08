import java.net.*;
import java.io.*;
import java.util.Scanner; //imports

//this is the code needed to run the client accessing the chat server
//The server program must be running first before this program can be used otherwise it will not find a server to connect to
//this only works for 1 client, I did not do the extension
public class Client {



    public static void main (String[] args) {

        try { //uses a try catch statement to catch any errors

            Socket sock = new Socket("127.0.0.1", 1337); //uses the same port number as the server program, so it will connect to the server
            PrintWriter output = new PrintWriter(sock.getOutputStream(), true); //this allows the program to write to the server

            Scanner myScanner = new Scanner(System.in);
            String current = "";

            System.out.println("You have connected to the server!");
            while (!(current.equals("#"))) { //loops until the user enters # to stop
                System.out.println("Send a message to the server! Enter # to stop");

                current = myScanner.nextLine(); //stores the message the user inputs
                output.println(current); //outputs this message to the server (which will be shown on the command line of the server program)
            }
            System.out.println("Connection stopped");

            output.close(); //closes connections
            sock.close();

        } catch (Exception e) { //if an error occurs, it will print an error message!
            System.out.println("An error has occurred, make sure the server program is running first!");
        }

    }
}












