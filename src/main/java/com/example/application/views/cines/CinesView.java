package com.example.application.views.cines;

import java.util.ArrayList;

import com.example.application.views.MainLayout;
import com.modelos.Cine;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin.Horizontal;

@PageTitle("Cines")
@Route(value = "Cines", layout = MainLayout.class)
public class CinesView extends VerticalLayout {

    private TextField cNombre = new TextField("Nombre del Cine");
    private TextField cDireccion = new TextField("Direccion");
    private TextField cTelefono = new TextField("Numero Telefono");
    private TextField cCorreo = new TextField("Correo");
    private ArrayList<Cine> cines = new ArrayList<>();
    private Grid<Cine> gridCines = new Grid<>();
    private Button bAgregar = new Button("Guardar");

    public CinesView() {
        add(gridCines);
        //gridCines.addColumn(Cine::getIdCine);
        gridCines.addColumn(Cine::getNombre);
        gridCines.addColumn(Cine::getDireccion);
        gridCines.addColumn(Cine::getTelefono);
        gridCines.addColumn(Cine::getCorreo);
        actualizar();

        HorizontalLayout layoutCampos= new HorizontalLayout();
        add(layoutCampos);
        layoutCampos.add(cNombre, cDireccion, cTelefono, cCorreo, bAgregar);
        bAgregar.addClickListener(event -> agregarCine(cNombre.getValue(), cDireccion.getValue(), cTelefono.getValue(), cCorreo.getValue()));

    }

    private void agregarCine(String nombre, String direccion, String telefono, String correo){  
        cines.add(new Cine(nombre, direccion, telefono, correo));
        actualizar();
        cNombre.setValue("");
        cDireccion.setValue("");
        cTelefono.setValue("");
        cCorreo.setValue("");
    }

    private void actualizar(){
        gridCines.setItems(cines);
    }

}
