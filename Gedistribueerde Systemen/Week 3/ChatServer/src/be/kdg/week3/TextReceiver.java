package be.kdg.week3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xaviergeerinck on 03/12/13.
 */
public interface TextReceiver extends Remote {
    public void receive(String msg) throws RemoteException;
}
