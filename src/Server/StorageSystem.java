package Server;
import ClientInterface.Rmi_Interface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class StorageSystem extends UnicastRemoteObject implements Rmi_Interface {

    public StorageSystem() throws RemoteException
    {

    }

    private HashMap<String, BigInteger>  threads = new HashMap<>();
    private static HashMap<BigInteger, Metrics> hashMap = new HashMap<>();


    public static void main (String argv[]) throws RemoteException
    {
        try
        {
            StorageSystem obj = new StorageSystem();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("RmiServer/Grupo20", obj);
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
        System.out.println(threads.toString());
        return "success!";
    }
    public synchronized String addToHashmap (String ipThread, Metrics metrics) throws IOException {
        BigInteger bi = new BigInteger(ipThread);

        if (hashMap.containsKey(bi))
        {
            hashMap.remove(bi);
            hashMap.put(bi, metrics);
        }
        else
            hashMap.put(bi,metrics);


        System.err.println(hashMap.toString());
        write();
        return "success";
    }

    public Metrics getMetrics(BigInteger n)
    {
        return hashMap.get(n);
    }

    public String hello()
    {
        System.out.println("mira mira mira");
        return "sucess";
    }
    public static void write () throws IOException {
        File hash = new File("hash.txt");

        if (!hash.exists())
        {
            hash.createNewFile();
        }
       String content = hashMap.toString();
        FileWriter fw = new FileWriter(hash.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }


}