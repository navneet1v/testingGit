import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLConnectionExample {
    
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.javatpoint.com/java-tutorial");
            URLConnection urlConnection = url.openConnection();
            InputStream in = urlConnection.getInputStream();
            int i;
            // read the input stream charcter by charcter
            while((i = in.read() )!= -1){
                System.out.print((char)i);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLConnectionExample.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException e){
            System.out.println("Problem in the URL connection");
            e.printStackTrace();
        }
    }
    
}
