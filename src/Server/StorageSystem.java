package Server;
import ClientInterface.Rmi_Interface;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class StorageSystem extends UnicastRemoteObject implements Rmi_Interface {
    public StorageSystem() throws RemoteException {
    }

    ArrayList<Integer> array = new ArrayList<>();
    public static void main (String argv[]) throws RemoteException
    {
        try
        {
            StorageSystem obj = new StorageSystem();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/Rmi", obj);
        }catch (Exception e)
        {
            System.err.println("StorageSystem Exception: "+e.toString());
            e.printStackTrace();
        }
        System.out.println("RmiServer started..");
        System.out.println("Listening..");
    }
    @Override
    public String addToList(int a) {
        array.add(a);
        System.out.println(array.toString());
        return "success!";
    }


}