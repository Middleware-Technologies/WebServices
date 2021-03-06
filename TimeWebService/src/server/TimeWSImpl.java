package server;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface="server.TimeWS")
public class TimeWSImpl implements TimeWS {

	@Override
	public String getTimeAsString() {
		return new Date().toString();
	}

	@Override
	public long getTimeAsElapsed() {
		return new Date().getTime();
	}

}
