package be.kdg.week3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by xaviergeerinck on 03/12/13.
 */
public interface IChatter extends Remote {
    public void unregister(Chatter chatter) throws RemoteException;

    public void register(Chatter chatter) throws RemoteException;

    public List<IChatter> getChatters() throws RemoteException;

    public void send(String message) throws RemoteException;

    public String getName() throws RemoteException;

    public void receive(String msg) throws RemoteException;
}
