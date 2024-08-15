package dev.jgregorio.course.functional.design.functional.basics;

import dev.jgregorio.course.functional.design.functional.basics.factorial.FatorialIterativeHandler;
import dev.jgregorio.course.functional.design.functional.basics.factorial.FatorialRecursionHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HttpServer {
    private static final int NUMBER_OF_THREADS = 1;

    public static void main(String[] args) throws IOException {
        com.sun.net.httpserver.HttpServer server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/factorial/iterative", new FatorialIterativeHandler());
        server.createContext("/factorial/recursive", new FatorialRecursionHandler());
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }

}
