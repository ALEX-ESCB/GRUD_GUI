package com.pmp.proyecto.grud;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.pmp.dao.Registro;
import com.pmp.dao.RegistroDao;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author alex-escb
 */
public class ProyectoController implements Initializable {

    @FXML
    private Label LblTitulo;
    @FXML
    private TableView<Registro> TablaRegistro;
    
    private Registro selectedRegistro;
    private ArrayList<Registro> registro;
    
    @FXML
    private TableColumn<Registro, Integer> TcId;
    @FXML
    private TableColumn<Registro, String> TcNombre;
    @FXML
    private TableColumn<Registro, String> TcEstado;
    @FXML
    private TableColumn<Registro, String> TcCorreo;
    @FXML
    private TableColumn<Registro, String> TcMeses;
    @FXML
    private TableColumn<Registro, String> TcArea;
    @FXML
    private TableColumn<Registro, String> TcPais;
    @FXML
    private Button BtnAgregar;
    @FXML
    private Button BtnActualizar;
    @FXML
    private Button BtnEliminar;
    @FXML
    private Button BtnVisualizar;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RegistroDao.setup();
        TcId.setCellValueFactory(new PropertyValueFactory("codigo")); //getCodigo 
        TcNombre.setCellValueFactory(new PropertyValueFactory("nombre")); //getNombre
        TcEstado.setCellValueFactory(new PropertyValueFactory("estado")); //getEstado
        TcCorreo.setCellValueFactory(new PropertyValueFactory("correo")); //getCorreo
        TcMeses.setCellValueFactory(new PropertyValueFactory("meses")); //getMeses
        TcArea.setCellValueFactory(new PropertyValueFactory("area")); //getArea
        TcPais.setCellValueFactory(new PropertyValueFactory("pais")); //getPais
        
        this.loadRegistro();

    }
    
    private void loadRegistro() {
        registro = RegistroDao.obtenerTodos();
        TablaRegistro.setItems(FXCollections.observableArrayList(registro));
    }
    
    private Registro loadRegistroForm(Registro registro, String mode) throws IOException {
        try {
            FXMLLoader modal = App.getFXMLLoader("registro");
            Parent modalObject = modal.load();
            RegistroController modalForm = (RegistroController) modal.getController();
            modalForm.setRegistro(registro);
            modalForm.setMode(mode);
            App.loadFXMLModal(modalObject);
            if (modalForm.getIsConfirmed()) {
                
                switch (mode) {
                    case "INS":
                        RegistroDao.agregar(registro);
                        break;
                    case "UPD":
                        RegistroDao.actualizar(registro);
                        break;
                    case "DEL":
                        RegistroDao.eliminar(registro.getCodigo());
                        break;
                }
                this.loadRegistro();
            }
            return null;
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    private Registro getSelectedRegistro(){
        return (Registro) TablaRegistro.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void BtnVisualizar_onclick(ActionEvent event) {
        try {
            Registro selectedRegistro = getSelectedRegistro();
            this.loadRegistroForm(selectedRegistro, "DSP");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void BtnAgregar_onclick(ActionEvent event) {
        try {
            Registro newRegistro = new Registro();
            newRegistro.setEstado("ACT");
            newRegistro.setNombre("");
            newRegistro.setCorreo("");
            newRegistro.setMeses("");
            newRegistro.setArea("");
            newRegistro.setPais("");
            this.loadRegistroForm(newRegistro, "INS");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void BtnActualizar_onclick(ActionEvent event) {
        try {
            Registro selectedRegistro = getSelectedRegistro();
            this.loadRegistroForm(selectedRegistro, "UPD");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
        
    }

    @FXML
    private void BtnEliminar_onclick(ActionEvent event) {
        try {
            Registro selectedRegistro = getSelectedRegistro();
            this.loadRegistroForm(selectedRegistro, "DEL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
