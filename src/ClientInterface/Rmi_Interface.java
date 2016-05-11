package ClientInterface;


import Server.Metrics;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rmi_Interface extends Remote {

    Boolean contains(BigInteger n) throws RemoteException;
    Metrics getMetrics(BigInteger n) throws RemoteException;
    String addToListThreads(String ipThread,BigInteger parameter)  throws RemoteException;
}
