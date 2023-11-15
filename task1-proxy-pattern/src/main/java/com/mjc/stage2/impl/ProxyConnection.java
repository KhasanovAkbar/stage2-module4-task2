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
        if (!isClosed) {
            realConnection.close();
            isClosed = true;
        }
    }

    @Override
    public void close() {
        if (!isClosed) {
            isClosed = true;
            connectionPool.releaseConnection(this);
        }
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
