package ClientInterface;

import Server.Metrics;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rmi_Interface extends Remote {

    Boolean contains(BigInteger n) throws RemoteException;
    Metrics getMetrics(BigInteger n) throws RemoteException;
}
