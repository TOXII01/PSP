package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class Controller {
@FXML private ListView<String> listView;

    ArrayList<String> listaNombre = new ArrayList<>();
    ArrayList<String> listaDesc = new ArrayList<>();

    public void muestraContenido(ActionEvent actionEvent) {


        Document doc = null;
        try {
            doc = Jsoup.connect("https://lamarinaplaza.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements nombre = doc.select("h4.pt-cv-title a");
        Elements desc = doc.select("div.pt-cv-content");
        for(Element e : nombre) {
           // System.out.println(e.text());
            listaNombre.add(e.text());
        }
        for(Element e : desc) {
         //   System.out.println(e.text());
            listaDesc.add(e.text());
        }
        listView.setItems(getContenido());


    }

    public ObservableList<String> getContenido() {
        ObservableList<String> nombre = FXCollections.observableArrayList();
        for(int i = 0; i < listaDesc.size(); i++) {
               nombre.add("Titulo : " + listaNombre.get(i));
               nombre.add("Descripcion : " + listaDesc.get(i));
        }
        System.out.println(nombre.size());
        return nombre;
    }

}
