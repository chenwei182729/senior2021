package rpc;

public class EchoServerImpl implements EchoServer {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok" : "ping is null";
    }
}
