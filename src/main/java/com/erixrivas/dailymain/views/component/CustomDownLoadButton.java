package com.erixrivas.dailymain.views.component;

import java.io.ByteArrayInputStream;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.StreamResource;

public class CustomDownLoadButton extends Div {
	private Button button=new Button();
	private Anchor download=new Anchor();
	
	
//	public FirCustomDownLoadButton() {
//		super();
//		//button.setText(NombreBoton);
//	   add(button,download);
//		// TODO Auto-generated constructor stub
//	}

	
	
	public CustomDownLoadButton(String NombreBoton) {
		super();
		button.setText(NombreBoton);
		button.setIcon(VaadinIcon.PRINT.create());
	   add(button,download);
		// TODO Auto-generated constructor stub
	}

//	public FirCustomDownLoadButton(String fileName, byte[] bytes) {
//		super();
//		
//		if(fileName!=null&&bytes!=null) {
//			
//		    
//	        //download.add(new Button(new Icon(VaadinIcon.DOWNLOAD_ALT)));
//			setAnchor(fileName, bytes);
//		}
//		// TODO Auto-generated constructor stub
//		add(download);
//	}

	private void createAnchor(String fileName, byte[] bytes) {
		download = new Anchor(new StreamResource(fileName, () -> new ByteArrayInputStream(bytes)),"");
        download.getElement().setAttribute("download", true);
        download.add(createButton(fileName));
	}

	private Button createButton(String texto) {
		Button	buttonDownload=new Button(texto, VaadinIcon.DOWNLOAD_ALT.create());
		return buttonDownload; 
	}
	
	public void setAnchor(String fileName, byte[] bytes){
		if (this.getChildren().findFirst().isPresent()) {
			this.remove(download);
		}
		
		 createAnchor(fileName, bytes);
		 add(download);
		 
		}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}
	
}