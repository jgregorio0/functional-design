package dev.jgregorio.course.functional.design.functional.basics.factorial;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

public class FatorialRecursionHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String query = httpExchange.getRequestURI().getQuery();
            String[] keyValue = query.split("=");
            String action = keyValue[0];
            String val = keyValue[1];
            if (!action.equals("var")) {
                httpExchange.sendResponseHeaders(400, 0);
                return;
            }
            BigInteger res = FactorialRecursive.factorial(Integer.valueOf(val));
            byte[] bytes = res.toString().getBytes();
            httpExchange.sendResponseHeaders(200, bytes.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(bytes);
            outputStream.close();
        }
    }