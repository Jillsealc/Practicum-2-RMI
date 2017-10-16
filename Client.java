/*
 * 1.  This client first obtains the stub for the registry by invoking the static LocateRegistry.getRegistry method with the hostname specified on the command line. 
 * 	   If no hostname is specified, then null is used as the hostname indicating that the local host address should be used.
 * 2.  Next, the client invokes the remote method lookup on the registry stub to obtain the stub for the remote object from the server's registry.
 * 3.  Finally, the client invokes the sayHello method on the remote object's stub, which causes the following actions to happen:
       - The client-side runtime opens a connection to the server using the host and port information in the remote object's stub and then serializes the call data.
       - The server-side runtime accepts the incoming call, dispatches the call to the remote object, and serializes the result (the reply string "Hello, world!") to the client.
       - The client-side runtime receives, deserializes, and returns the result to the caller.
 */
package gs2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client 
{

    public Client() {}

    public static void main(String[] args) 
    {
        try {
            Registry registry = LocateRegistry.getRegistry(); // 1
            Bank stub = (Bank) registry.lookup("Bank"); // 2
            String response = stub.sayHello(); // 3
            System.out.println("response: " + response);
            int bankAmmount = stub.balance();
            System.out.println("Ammount: " + bankAmmount);
            stub.deposite(50);
            stub.withdrawl(20);
            bankAmmount = stub.balance();
            System.out.println("Ammount: " + bankAmmount);
            
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}