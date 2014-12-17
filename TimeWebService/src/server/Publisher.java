package server;

import javax.xml.ws.Endpoint;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9999/timews", new TimeWSImpl());
	}
}
