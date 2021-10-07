package com.erixrivas.dailymain.views;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.erixrivas.dailymain.domain.entyties.Marca;
import com.erixrivas.dailymain.views.CatalogoMarcaContrac.IVistaCatalogoMarca;
import com.erixrivas.dailymain.views.component.CustomDownLoadButton;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("CatalogoMarca")
@Route(value = "CatalogoMarca", layout = MainLayout.class)
public class CatalogoMarca extends VerticalLayout implements IVistaCatalogoMarca{
	private HorizontalLayout barraDeBotones=new HorizontalLayout();
	private Button btnAgregarMarca= new Button("Agregar Marca", VaadinIcon.PLUS.create());
	private Button btnEditarMarca= new Button("Agregar Marca", VaadinIcon.EDIT.create());
	private Button btnAnularMarca= new Button("Agregar Marca", VaadinIcon.TRASH.create());
	private CustomDownLoadButton btnDescargar= new CustomDownLoadButton("Generar Csv");
	
	private Grid<Marca> grilla = new Grid<Marca>();
	
	private TextField txtFiltroDescripcion= new TextField("Filtrar por Descripcion", "escribe aqui para filtrar");
	private TextField txtFiltroAlias= new TextField("Filtrar por Alias", "escribe aqui para filtrar");
	private PresentadorCatalogoMarca presentadorCatalogoMarca;
	
	public CatalogoMarca() {
		super();
		presentadorCatalogoMarca=new PresentadorCatalogoMarca(this);
		barraDeBotones.add(btnAgregarMarca,btnEditarMarca,btnAnularMarca,btnDescargar );
		
		grilla.addColumn(Marca::getDescripcion).setHeader("Descripcion");
		grilla.addColumn(Marca::getAlias).setHeader("Marca");
		
	
		grilla.setAllRowsVisible(true); 
		grilla.setSelectionMode(SelectionMode.MULTI);
		grilla.getColumns().forEach(column->{
			column.setSortable(true);
			column.setResizable(true);
		} );
			
	
		
		add(barraDeBotones,new FormLayout(txtFiltroDescripcion,txtFiltroAlias),grilla);
		
		
		
		// TODO Auto-generated constructor stub
	}

	public HorizontalLayout getBarraDeBotones() {
		return barraDeBotones;
	}

	public void setBarraDeBotones(HorizontalLayout barraDeBotones) {
		this.barraDeBotones = barraDeBotones;
	}

	public Button getBtnAgregarMarca() {
		return btnAgregarMarca;
	}

	public void setBtnAgregarMarca(Button btnAgregarMarca) {
		this.btnAgregarMarca = btnAgregarMarca;
	}

	public Button getBtnEditarMarca() {
		return btnEditarMarca;
	}

	public void setBtnEditarMarca(Button btnEditarMarca) {
		this.btnEditarMarca = btnEditarMarca;
	}

	public Button getBtnAnularMarca() {
		return btnAnularMarca;
	}

	public void setBtnAnularMarca(Button btnAnularMarca) {
		this.btnAnularMarca = btnAnularMarca;
	}

	public CustomDownLoadButton getBtnDescargar() {
		return btnDescargar;
	}

	public void setBtnDescargar(CustomDownLoadButton btnDescargar) {
		this.btnDescargar = btnDescargar;
	}

	public Grid<Marca> getGrilla() {
		return grilla;
	}

	public void setGrilla(Grid<Marca> grilla) {
		this.grilla = grilla;
	}

	public TextField getTxtFiltroDescripcion() {
		return txtFiltroDescripcion;
	}

	public void setTxtFiltroDescripcion(TextField txtFiltroDescripcion) {
		this.txtFiltroDescripcion = txtFiltroDescripcion;
	}

	public TextField getTxtFiltroAlias() {
		return txtFiltroAlias;
	}

	public void setTxtFiltroAlias(TextField txtFiltroAlias) {
		this.txtFiltroAlias = txtFiltroAlias;
	}

	

	
}
