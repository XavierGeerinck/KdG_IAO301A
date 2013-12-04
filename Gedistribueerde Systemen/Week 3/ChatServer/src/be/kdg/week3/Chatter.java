package be.kdg.week3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xaviergeerinck on 03/12/13.
 */
public class Chatter extends UnicastRemoteObject implements TextReceiver, IChatter {
    private String name;
    private List<IChatter> chatters;
    private TextReceiver gui;

    protected Chatter(String name, String otherChatter) throws RemoteException, MalformedURLException, NotBoundException {
        this(name);

        IChatter chatter = (IChatter) Naming.lookup("rmi://localhost:1234/" + otherChatter);
        chatters = chatter.getChatters();
    }

    protected Chatter(String name)  throws RemoteException {
        this.chatters = new ArrayList<IChatter>();
        this.name = name;
        gui = new ChatClientFrame(this);
    }

    public void unregister(Chatter chatter) throws RemoteException {
        chatters.remove(chatter);
    }

    public void register(Chatter chatter) throws RemoteException {
        chatters.add(chatter);
    }

    public List<IChatter> getChatters() throws RemoteException {
        return chatters;
    }

    public void send(String message) throws RemoteException {
        for (IChatter chatter : chatters) {
            chatter.receive(message);
        }
    }

    @Override
    public void receive(String msg) throws RemoteException {
        gui.receive(msg);
    }

    public String getName() {
        return name;
    }
}
