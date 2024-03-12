package tp.services;

import org.springframework.stereotype.Component;
import tp.SwingProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLDecoder;
import java.util.stream.Collectors;

@Component
public class WorldMapService {
    private final String map;

    public WorldMapService() throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
        byte[] hardwareAddress = ni.getHardwareAddress();
        long macAsLong = 0;
        for (int i = 0; i < hardwareAddress.length; i++) {
            macAsLong = (macAsLong << 8) | (hardwareAddress[i] & 0xff);
        }
        macAsLong = macAsLong % 32600;
        // Commande à exécuter
        URL resource = SwingProject.class.getClassLoader().getResource("generate.exe");
        String decode = URLDecoder.decode(resource.getPath(), "UTF-8");
        var proc = Runtime.getRuntime().exec(decode + " " + Integer.valueOf((int) macAsLong).toString());
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));


        this.map = stdInput.lines().collect(Collectors.joining("\n"));
        var error = stdError.lines().collect(Collectors.joining());
        if (!error.isEmpty()) System.err.println(error);
    }

    public String getMap() {
        return map;
    }
}
