package com.erixrivas.dailymain.views.map;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.erixrivas.dailymain.components.leafletmap.LeafletMap;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.erixrivas.dailymain.views.MainLayout;

@PageTitle("Map")
@Route(value = "map", layout = MainLayout.class)
public class MapView extends VerticalLayout {

    private LeafletMap map = new LeafletMap();

    public MapView() {
        setSizeFull();
        setPadding(false);
        map.setSizeFull();
        map.setView(55.0, 10.0, 4);
        add(map);
    }
}
