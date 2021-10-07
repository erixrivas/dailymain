package com.erixrivas.dailymain.views;

import java.util.ArrayList;
import java.util.List;

import com.erixrivas.dailymain.domain.entyties.Marca;
import com.erixrivas.dailymain.views.component.CustomDownLoadButton;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;

import net.bytebuddy.asm.Advice.Return;

public interface CatalogoMarcaContrac {
	
	interface IVistaCatalogoMarca {
		Grid<Marca>	getGrilla();
		TextField getTxtFiltroDescripcion();
		TextField getTxtFiltroAlias();
		CustomDownLoadButton getBtnDescargar();
	}
	interface IModeloCatalogoMarca {
		default List<Marca> generarMarcas(){
			List<Marca > marcas = new ArrayList<Marca>();
		
		for (int i = 0; i < 100; i++) {
			marcas.add(new Marca(null, " descripcion "+i, "alias "+Math.random()));
		}
		return marcas; 	
		};
		
	}
	
}
