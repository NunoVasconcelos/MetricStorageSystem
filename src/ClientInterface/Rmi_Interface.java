package ClientInterface;


import Server.Metrics;

import java.io.IOException;
import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rmi_Interface extends Remote {


     Boolean contains(BigInteger n) throws RemoteException;
     Metrics getMetrics(BigInteger n) throws RemoteException;
     String addToListThreads(String ipThread,BigInteger parameter)  throws RemoteException;
     String addToHashmap (String ipThread, Metrics metrics) throws IOException;
     String hello ()throws RemoteException;

}
