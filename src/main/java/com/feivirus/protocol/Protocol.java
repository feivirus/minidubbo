package com.feivirus.protocol;

import com.feivirus.framework.InterfaceAddress;
import com.feivirus.framework.Invocation;

/**
 * @author feivirus
 */
public interface Protocol {
    void start(InterfaceAddress address);
    String send(InterfaceAddress address, Invocation invocation);
}
