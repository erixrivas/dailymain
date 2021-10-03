package com.erixrivas.dailymain.views;

import java.util.ArrayList;
import java.util.List;

import com.erixrivas.dailymain.domain.entyties.Marca;
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
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("CatalogoMarca")
@Route(value = "CatalogoMarca", layout = MainLayout.class)
public class CatalogoMarca extends VerticalLayout {
	private HorizontalLayout barraDeBotones=new HorizontalLayout();
	private Button btnAgregarMarca= new Button("Agregar Marca", VaadinIcon.PLUS.create());
	private Button btnEditarMarca= new Button("Agregar Marca", VaadinIcon.EDIT.create());
	private Button btnAnularMarca= new Button("Agregar Marca", VaadinIcon.TRASH.create());
	
	private Grid<Marca> grilla = new Grid<Marca>();
	
	private TextField txtFiltroDescripcion= new TextField("Filtrar por Descripcion", "escribe aqui para filtrar");
	private TextField txtFiltroAlias= new TextField("Filtrar por Alias", "escribe aqui para filtrar");

	public CatalogoMarca() {
		super();
		barraDeBotones.add(btnAgregarMarca,btnEditarMarca,btnAnularMarca );
		
		grilla.addColumn(Marca::getDescripcion).setHeader("Descripcion");
		grilla.addColumn(Marca::getAlias).setHeader("Marca");
		
		List<Marca > marcas = new ArrayList<Marca>();
		
		for (int i = 0; i < 100; i++) {
			marcas.add(new Marca(null, " descripcion "+i, "alias "+Math.random()));
		}
		grilla.setItems(marcas);
		grilla.setAllRowsVisible(true); 
		grilla.setSelectionMode(SelectionMode.MULTI);
		grilla.getColumns().forEach(column->{
			column.setSortable(true);
			column.setResizable(true);
		} );
		txtFiltroDescripcion.addValueChangeListener(e->filtrarCatalogo(e));
		txtFiltroAlias.addValueChangeListener(e->filtrarCatalogo(e));
		
		add(barraDeBotones,new FormLayout(txtFiltroDescripcion,txtFiltroAlias),grilla);
		
		
		
		// TODO Auto-generated constructor stub
	}

	private void filtrarCatalogo(ComponentValueChangeEvent<TextField, String> e) {
		// TODO Auto-generated method stub
		ListDataProvider<Marca> dataProvider = (ListDataProvider<Marca>) grilla.getDataProvider();
		dataProvider.clearFilters();
		if (!txtFiltroDescripcion.getValue().isEmpty() && (txtFiltroDescripcion.getValue() != null)) {
			dataProvider.addFilter(Marca::getDescripcion,
					s -> caseInsensitiveContains(s.toString(), txtFiltroDescripcion.getValue()));
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

}
