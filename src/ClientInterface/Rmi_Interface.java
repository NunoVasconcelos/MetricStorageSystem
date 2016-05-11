package ClientInterface;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rmi_Interface extends Remote {

     String addToListThreads(String ipThread,BigInteger parameter)  throws RemoteException;
}
