package ch.flatland.cdo.service.ping.model

import javax.xml.bind.annotation.XmlRootElement
import org.eclipse.xtend.lib.annotations.Data

@XmlRootElement
@Data class PingBean {
	String name;
	String version;
}