package javanodejspingpong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Kaylem
 */
public class JavaNodeJSPingPong {

    //socket object
    private Socket socket;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        JavaNodeJSPingPong client = new JavaNodeJSPingPong();
        
        //socket tcp connection
        
        final String IP = "localhost";
        final int PORT = 6969;
        client.socketConnect(IP,PORT); 
        
        String message = "Hello node";
        
        
        System.out.println("Sending: "+ message);
        String returnString = client.echo(message);
        System.out.println("Receiving: "+ returnString);
        
        
    }

    //connects to socket
    private void socketConnect(String IP, int PORT) throws IOException {
        System.out.println("[Connecting to socket...]");
        this.socket = new Socket(IP,PORT);
        
    }

    //writes and recieeves message in the soccket
    private String echo(String message) {
        try{
            //out and in
            PrintWriter out = new PrintWriter(getSocket().getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
            
            //writes and reads
            out.println(message);
            String returnString = in.readLine();
            
            //closes socket
            getSocket().close();
            
            return returnString;
            
            
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return null;
    }

    private Socket getSocket() {
        return socket;
    }
    
}
