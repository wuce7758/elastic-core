package com.gerald.elastic.core.debug.index;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ClientFactory {
	private static TransportClient client;
	
	static {
		Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "pxsj_release")
                .build();
    	
    	client = TransportClient.builder().settings(settings).build();
    	
    	try {
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.0.101"), 9301))
				  .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.0.101"), 9302))
				  .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.0.101"), 9303));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static TransportClient getClient() {
		return client;
	}
}
