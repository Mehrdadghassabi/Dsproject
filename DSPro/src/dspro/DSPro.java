/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dspro;



import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.FileChooser;


/**
 *
 * @author Dour-Andish
 */

public class DSPro extends Application {
    public static Scene sc;
     private Button searchbtn;
       
    
    @Override
    public void start(Stage stage) throws Exception {
      FileChooser fileChooser = new FileChooser();
      File selectedFile = fileChooser.showOpenDialog(stage);
      String pa=selectedFile.getAbsolutePath();
      pa=pa.replace("here.txt", "");
        System.out.println(pa);
      CsvReader.path=pa;
        
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        sc=scene;
        
        EventHandlerImpl EhI1=new EventHandlerImpl();
        EventHandlerImpl2 EhI2=new EventHandlerImpl2();
        EventHandlerImpl3 EhI3=new EventHandlerImpl3();
        EventHandlerImpl4 EhI4=new EventHandlerImpl4();
        
        this.searchbtn=(Button)DSPro.sc.lookup("#searchBTN");
        Button b2tn=(Button)DSPro.sc.lookup("#Button2");
        Button b3tn=(Button)DSPro.sc.lookup("#Button3");
        Button b4tn=(Button)DSPro.sc.lookup("#Button4");
        
        this.searchbtn.addEventHandler(MouseEvent.MOUSE_CLICKED,EhI1);
        b2tn.addEventHandler(MouseEvent.MOUSE_CLICKED,EhI2);
        b3tn.addEventHandler(MouseEvent.MOUSE_CLICKED,EhI3);
        b4tn.addEventHandler(MouseEvent.MOUSE_CLICKED,EhI4);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       launch(args);
  
    }
    
}