package framework;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author tanghf
 * @className framework.URL.java
 * @createTime 2019/8/21 11:39
 */
public class URL implements Serializable{
    private String hostname;
    private Integer port;

    public URL(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        URL url = (URL) o;
        return Objects.equals(hostname, url.hostname) &&
                Objects.equals(port, url.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostname, port);
    }
}
