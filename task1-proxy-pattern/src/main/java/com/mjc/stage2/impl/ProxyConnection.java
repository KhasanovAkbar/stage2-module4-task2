package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;


public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    private ConnectionPool connectionPool;
    private boolean isClosed;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
        ConnectionPool.getInstance();
        isClosed = false;
    }

    public void reallyClose() {
        // Write your code here!
        connectionPool.releaseConnection(this);
    }

    @Override
    public void close() {
        realConnection.close();
        isClosed = true;

    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
