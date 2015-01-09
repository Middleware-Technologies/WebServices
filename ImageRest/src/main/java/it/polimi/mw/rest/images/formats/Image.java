package it.polimi.mw.rest.images.formats;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Image {

	String name;
	String uri;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public Image() {
		this.name = null;
		this.uri = null;
	}
	
	public Image(String name, String uri) {
		this.name = name;
		this.uri = uri;
	}
	
	
	
}
