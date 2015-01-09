package it.polimi.mw.rest.images.formats;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ImageContainer {
	
	List<Image> containerNames;

	public List<Image> getContainerNames() {
		return containerNames;
	}

	public void setContainerNames(List<Image> containerNames) {
		this.containerNames = containerNames;
	}

	public ImageContainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageContainer(List<Image> containerNames) {
		this.containerNames = containerNames;
	}

	public ImageContainer(Image[] imageArray) {
		// TODO Auto-generated constructor stub
		this.containerNames = new ArrayList<Image>();
		for (Image i : imageArray) {
			this.containerNames.add(i);
		}
	}
	
	

}
