package dataservice;

        import java.rmi.Remote;
        import java.rmi.RemoteException;

/**
 * Created by Hiki on 2016/10/16.
 */


public interface DataServiceParent {

    // 初始化数据
    public void initial() throws RemoteException;

    // 结束持久化数据库的使用
    public void finish() throws RemoteException;

}
