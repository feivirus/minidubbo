package com.feivirus.framework;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author feivirus
 */
public class InterfaceAddress implements Serializable {
    private String hostName;

    private Integer port;

    public InterfaceAddress(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        InterfaceAddress that = (InterfaceAddress) o;
        return hostName.equals(that.hostName) &&
                port.equals(that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostName, port);
    }
}
