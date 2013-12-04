package be.kdg.week3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by xaviergeerinck on 03/12/13.
 */
public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        int portnumber = 1234;

        // Create chatter 1, this got the chat link
        Chatter chatter = new Chatter("Xavier");
        chatter.register(chatter);

        // Bind a registry
        Registry registry = LocateRegistry.createRegistry(portnumber);
        registry.rebind(chatter.getName(), (Remote) chatter);

        // Connect a second chatter
        Chatter chatter2 = new Chatter("Tst2", "Xavier");
        chatter.register(chatter2);
    }
}
