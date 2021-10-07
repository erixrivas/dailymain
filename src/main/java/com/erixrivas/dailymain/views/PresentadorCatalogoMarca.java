package com.erixrivas.dailymain.views;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.erixrivas.dailymain.domain.entyties.Marca;
import com.erixrivas.dailymain.views.CatalogoMarcaContrac.IModeloCatalogoMarca;
import com.erixrivas.dailymain.views.CatalogoMarcaContrac.IVistaCatalogoMarca;
import com.erixrivas.dailymain.views.component.CustomDownLoadButton;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.Query;

public class PresentadorCatalogoMarca {
	private IVistaCatalogoMarca vista;
	private IModeloCatalogoMarca modelo= new ModeloCataloMarcaMock();
	private TextField txtFiltroAlias;

	public PresentadorCatalogoMarca(CatalogoMarca vista) {
		super();
		this.vista = vista;
		txtFiltroAlias=vista.getTxtFiltroAlias();
	
		vista.getGrilla().setItems(modelo.generarMarcas());
		vista.getTxtFiltroDescripcion().addValueChangeListener(e->filtrarCatalogo(e));
		vista.getTxtFiltroAlias().addValueChangeListener(e->filtrarCatalogo(e));
		vista.getBtnDescargar().getButton().addClickListener(e->{
				
				try {
					this.imprimirYDescargar(vista.getBtnDescargar(),vista.getGrilla(),"MARCAS");
				} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
		);
	}
	
	private void filtrarCatalogo(ComponentValueChangeEvent<TextField, String> e) {
		// TODO Auto-generated method stub
		ListDataProvider<Marca> dataProvider = (ListDataProvider<Marca>) vista.getGrilla().getDataProvider();
		dataProvider.clearFilters();
		if (!vista.getTxtFiltroDescripcion().getValue().isEmpty() && (vista.getTxtFiltroDescripcion().getValue() != null)) {
			dataProvider.addFilter(Marca::getDescripcion,
					s -> caseInsensitiveContains(s.toString(), vista.getTxtFiltroDescripcion().getValue()));
		}
		
		if (!txtFiltroAlias.getValue().isEmpty() && (txtFiltroAlias.getValue() != null)) {
			dataProvider.addFilter(Marca::getDescripcion,
					s -> caseInsensitiveContains(s.toString(), txtFiltroAlias.getValue()));
		}
	}

	private Boolean caseInsensitiveContains(String where, String what) {
		if (where != null && what != null)
			return where.toString().toLowerCase().contains(what.toLowerCase());
		else
			return false;
		// return where.toLowerCase().contains(what.toLowerCase());
	}

	

private void imprimirYDescargar(CustomDownLoadButton boton, Grid<Marca> grilla,String nombre) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

	
	Stream<Marca> auxiliarMarcas =grilla.getDataProvider().fetch(new Query<>());
	StringWriter output = new  StringWriter();
	 StatefulBeanToCsv<Marca> beantocsv = new StatefulBeanToCsvBuilder<Marca>(output).build();
	 beantocsv.write(auxiliarMarcas);
	 String content=output.toString();
	boton.setAnchor(nombre+".csv", content.getBytes());
	}
	

}
