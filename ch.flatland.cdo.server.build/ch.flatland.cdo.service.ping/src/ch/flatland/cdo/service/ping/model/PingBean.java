package ch.flatland.cdo.service.ping.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PingBean {
	public String name;
	public String version;

	public PingBean() {
		this.name = "Flatland CDO Server";
		this.version = "1.0.0";
	}

	public PingBean(String name, String version) {
		this.name = name;
		this.version = version;
	}
}