package com.myfiu.king.integration;

import com.myftiu.king.server.GameServer;
import com.myftiu.king.server.GameServerImpl;
import com.sun.net.httpserver.HttpExchange;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @author by ali myftiu.
 */


public class GenericTestCase {

	private static final GameServer gameServer = new GameServerImpl();

    @Mock
    protected HttpExchange exchange;

    @Mock
    protected OutputStream outputStream;


	@Before
	public  void startServer() throws IOException {
        gameServer.startServer();

	}

	@After
	public  void stopServer() throws IOException {
        gameServer.stopServer();
	}

	protected HttpURLConnection createConnection(String url, String requestMethod) throws IOException
	{
		HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
		httpConnection.setRequestMethod(requestMethod);
		return httpConnection;
	}


	protected String getResponseBody(InputStream inputStream)
	{
		String responseBody = "";
		Scanner scanner = new Scanner(inputStream);
		if(scanner.hasNext()) {
		 responseBody = scanner.next();
		}
		return responseBody;
	}

}
