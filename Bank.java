package gs2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote
{
	String sayHello() throws RemoteException;
	int balance() throws RemoteException;
	void deposite(int money) throws RemoteException;
	void withdrawl(int money) throws RemoteException;
	
}

