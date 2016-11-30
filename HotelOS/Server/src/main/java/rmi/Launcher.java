package rmi;

import java.rmi.RemoteException;

/**
 * Created by kevin on 2016/11/16.
 */
public class Launcher {
    public static void main(String[] args) throws RemoteException {
        new RemoteHelper().run();
    }
}
