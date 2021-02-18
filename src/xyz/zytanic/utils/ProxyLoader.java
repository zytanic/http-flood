package xyz.zytanic.utils;

import xyz.zytanic.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProxyLoader {

    public static ArrayList<Proxy> proxyArrayList = new ArrayList<>();


        public static void loadproxys(String filename) throws FileNotFoundException {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                String[] content = scanner.nextLine().split(":");
                InetSocketAddress address = new InetSocketAddress(content[0], Integer.parseInt(content[1]));
                java.net.Proxy javaProxy = new java.net.Proxy(java.net.Proxy.Type.HTTP,address);

                proxyArrayList.add(javaProxy);
            }







        }
        public static Proxy getProxy(int intertaro) {
            if (intertaro <= proxyArrayList.size()) {
                Main.v = 0;
            }
            return proxyArrayList.get(intertaro);



        }



}
