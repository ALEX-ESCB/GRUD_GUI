/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.proyecto.grud;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.pmp.dao.Registro;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author alex-escb
 */
public class RegistroController implements Initializable {


    
    private Registro selectedRegistro;
    private boolean isConfirmed = false;
    
    private String mode;
    
    @FXML
    private TextField TxtCodigo;
    @FXML
    private TextField TxtNombre;
    @FXML
    private TextField TxtCorreo;
    @FXML
    private TextField TxtMeses;
    @FXML
    private TextField TxtArea;
    @FXML
    private TextField TxtPais;
    @FXML
    private RadioButton RdbInactivo;
    @FXML
    private Button BtnConfirmar;
    @FXML
    private Button BtnCancelar;
    @FXML
    private RadioButton RdbActivo;
    @FXML
    private Label LblTitulo;
    @FXML
    private ToggleGroup Activo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setRegistro( Registro registro){
      this.selectedRegistro = registro;
      TxtCodigo.setText(String.valueOf(this.selectedRegistro.getCodigo()));
      TxtNombre.setText(this.selectedRegistro.getNombre());
      TxtCorreo.setText(this.selectedRegistro.getCorreo());
      TxtMeses.setText(this.selectedRegistro.getMeses());
      TxtArea.setText(this.selectedRegistro.getArea());
      TxtPais.setText(this.selectedRegistro.getPais());
      if(this.selectedRegistro.getEstado().contentEquals("ACT")) {
        RdbActivo.setSelected(true);
      } else {
        RdbInactivo.setSelected(true);
      }
    }
    public void setMode(String mode) {
      this.mode = mode;
      TxtCodigo.setDisable(true);
      switch(this.mode){
        case "DSP":
          LblTitulo.setText("Mostrando detalle de:");
          BtnConfirmar.setDisable(true);
          TxtNombre.setDisable(true);
          TxtCorreo.setDisable(true);
          TxtMeses.setDisable(true);
          TxtArea.setDisable(true);
          TxtPais.setDisable(true);
          RdbActivo.setDisable(true);
          RdbInactivo.setDisable(true);
          break;
        case "DEL":
          LblTitulo.setText("Eliminando:");
          TxtNombre.setDisable(true);
          TxtCorreo.setDisable(true);
          TxtMeses.setDisable(true);
          TxtArea.setDisable(true);
          TxtPais.setDisable(true);
          RdbActivo.setDisable(true);
          RdbInactivo.setDisable(true);
          break;
        case "UPD":
          LblTitulo.setText("Editando:");
          break;
      }
    }

    @FXML
    private void BtnConfirmar_onclicked(ActionEvent event) {
        this.selectedRegistro.setNombre(TxtNombre.getText());
        this.selectedRegistro.setCorreo(TxtCorreo.getText());
        this.selectedRegistro.setMeses(TxtMeses.getText());
        this.selectedRegistro.setArea(TxtArea.getText());
        this.selectedRegistro.setPais(TxtPais.getText());
        if (RdbActivo.isSelected()) {
            this.selectedRegistro.setEstado("ACT");
        } else {
            this.selectedRegistro.setEstado("INA");
        }
        this.isConfirmed = true;
        App.closeModal(event);
    }

    @FXML
    private void BtnCancelar_onclicked(ActionEvent event) {
        App.closeModal(event);
    }

    public boolean getIsConfirmed(){
        return this.isConfirmed;
    }
    
    public Registro getRegistro() {
        return this.selectedRegistro;
    }
}
