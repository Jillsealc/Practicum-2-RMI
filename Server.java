package gs2;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Bank
{
	public int ammount = 0;

    public Server() throws RemoteException {
    	super();
    }

    public String sayHello() throws RemoteException
    {
        return "Hello, world!";
    }
    
    public int balance() throws RemoteException
    {
    	return ammount;
    }
    
    public void deposite(int money) throws RemoteException
    {
    	ammount = ammount + money;
    }
    
    public void withdrawl(int money) throws RemoteException
    {
    	ammount = ammount - money;
    }
    
    public static void main(String[] args) 
    {

        try {
            Server obj = new Server(); //create remote object
            Bank stub = (Bank)obj; //export remote object

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Bank", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
