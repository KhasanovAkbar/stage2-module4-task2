package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private  RealConnection realConnection;
    private ConnectionPool connectionPool;
    private boolean isClosed;

    public ProxyConnection(RealConnection realConnection, ConnectionPool connectionPool, boolean isClosed) {
        this.realConnection = realConnection;
        this.connectionPool = connectionPool;
        this.isClosed = false;
    }

    public void reallyClose() {
        //
        realConnection.close();
        isClosed = true;
    }

    @Override
    public void close() {
        connectionPool.releaseConnection(this);

    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
