package Server;
import ClientInterface.Rmi_Interface;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class StorageSystem extends UnicastRemoteObject implements Rmi_Interface {

    public StorageSystem() throws RemoteException
    {

    }

    private HashMap<String, BigInteger>  threads = new HashMap<>();
    private HashMap<BigInteger, Metrics> hashMap = new HashMap<>();


    public static void main (String argv[]) throws RemoteException
    {
        try
        {
            StorageSystem obj = new StorageSystem();
//            System.setProperty("java.rmi.server.hostname", Inet4Address.getLocalHost().getHostAddress());
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Grupo20", obj);
//            reg.rebind("Grupo20",obj);
        }catch (Exception e)
        {
            System.err.println("StorageSystem Exception: "+e.toString());
            e.printStackTrace();
        }
        System.out.println("RmiServer started..");
        System.out.println("Listening..");
    }


    public Boolean contains(BigInteger n)
    {
        return hashMap.containsKey(n);
    }

    public synchronized String addToListThreads(String ipThread, BigInteger parameter)
    {
        threads.put(ipThread, parameter);
        System.err.println(threads.toString());
        return "success!";
    }
    public synchronized String addToHashmap (String ipThread, Metrics metrics)
    {
        BigInteger bi = new BigInteger(ipThread);
        hashMap.put(bi,metrics);
        return "success";
    }

    public Metrics getMetrics(BigInteger n)
    {
        return hashMap.get(n);
    }



}