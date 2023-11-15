package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private final RealConnection realConnection;
    private ConnectionPool connectionPool;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
        ConnectionPool.getInstance();
    }


    public void reallyClose() {
        //
        connectionPool.getConnection();


    }

    @Override
    public void close() {
        realConnection.close();
        connectionPool.destroyPool();
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }
}
