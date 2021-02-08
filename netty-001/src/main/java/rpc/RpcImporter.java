package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RpcImporter<S> {

    public S importer(final Class<?> serverClass, final InetSocketAddress addr) {
        return (S) Proxy.newProxyInstance(serverClass.getClassLoader(),
                serverClass.getInterfaces(),
                (proxy, method, args) -> {
                    Socket socket = null;
                    ObjectOutputStream output = null;
                    ObjectInputStream input = null;

                    try {
                        socket = new Socket();
                        socket.connect(addr);
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeUTF(serverClass.getName());
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);

                        input = new ObjectInputStream(socket.getInputStream());
                        return input.readObject();
                    } finally {
                        if (socket != null) {
                            socket.close();
                        }
                        if (output != null) {
                            output.close();
                        }
                        if (input != null) {
                            input.close();
                        }
                    }
                });

    }
}
