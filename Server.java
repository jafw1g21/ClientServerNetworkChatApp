import java.io.*;
import java.net.*; //imports


//this is the code needed to run the chat server
// The server program must be running first, then a client program should run afterwards and connect to it
public class Server {


    public static void main(String[] args) {

        try { //uses a try catch statement to catch any errors
            ServerSocket sock = new ServerSocket(1337); //creates a server socket with port 1337
            System.out.println("Awaiting a client to connect to the server");

            Socket sock2 = sock.accept(); //waits for a client to try to connect and accepts their connection


            BufferedReader input = new BufferedReader(new InputStreamReader(sock2.getInputStream())); //this can read from the server

            String current = "";
            System.out.println("Client connected, awaiting client input");
            while (current != null && !(current.equals("#"))) { //loops until there is a null input
                current = input.readLine(); //waits until there is a new input to the server and reads it
                System.out.println(current); //prints the input onto the server command line
            }
            System.out.println("Connection stopped");

            input.close(); //closes connections
            sock2.close();
            sock.close();




        } catch (Exception e) { //if it catches an error it displays an error message
            System.out.println("An error has occurred");
        }



    }
}
