/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import projet.services.Servicecours;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
/**
 * FXML Controller class
 *
 * @author shado
 */
public class Front_coursController implements Initializable {

    @FXML
    private JFXButton id_back1;
    @FXML
    private Pagination pagination;
       File filesJpg[];
    @FXML
    private Label label;
    @FXML
    private Label lb;
    @FXML
    private ImageView read_id;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage parent=new Stage();
        FileChooser photo = new FileChooser();
        Stage stage = new Stage();
                lb.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
      Servicecours sc = new Servicecours();
        try {
            this.pagination.setPageCount(sc.getNumber());
        } catch (SQLException ex) {
            Logger.getLogger(Front_coursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
 

       
          pagination.setPageFactory(new Callback<Integer,Node>() {
            @Override
            public Node call(Integer pageIndex ) {
                 
                try {
                    return createPage(pageIndex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Front_coursController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Front_coursController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Front_coursController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
           
                
            }
        });
    }
    
    
 
    
    public VBox createPage(int index) throws MalformedURLException, SQLException, FileNotFoundException {
        Servicecours sc = new Servicecours();
       
    ImageView imageView = new ImageView();
       /*try (Scanner scanner = new Scanner(new File(sc.getCours().get(index).getLien2()))) {

        while (scanner.hasNext())
            S=S+scanner.next()+"\n";

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
 
       System.out.println(S);*/
       String S1="";
       
		XWPFDocument document = null;
		FileInputStream fileInputStream = null;
		try {
 
			
			File fileToBeRead = new File(sc.getCours().get(index).getLien2());
			fileInputStream = new FileInputStream(fileToBeRead);
			document = new XWPFDocument(fileInputStream);
			XWPFWordExtractor extractor = new XWPFWordExtractor(document);
 
			System.out.println("The Contents of the Word File are ::");
			System.out.println("--------------------------------------");
 
			System.out.println(extractor.getText());
                        String nL1 = System.getProperty("line.separator"); 
                       S1=S1+extractor.getText()+"\n";
                      
		} catch (Exception e) {
			System.out.println("We had an error while reading the Word Doc");
		} finally {
			try {
				
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception ex) {
			}
                }
                     Projet.S=S1;    
                     Projet.nom_cours=sc.getCours().get(index).getNom_cours();
        this.lb.setText(sc.getCours().get(index).getNom_cours());
        lb.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
       File file = new File(sc.getCours().get(index).getLien());
String localUrl = file.toURI().toURL().toString();
           
            Image image=new Image(localUrl);
            
            imageView.setImage(image);
            imageView.setFitWidth(624);
            imageView.setFitHeight(500);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);
     
        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);
        return pageBox;
    }
    

    @FXML
    private void back(MouseEvent event) throws IOException {
          Stage stage=(Stage)this.read_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    private void read_click(MouseEvent event) throws IOException {
          Stage stage=(Stage)this.read_id.getScene().getWindow();
       Parent root=FXMLLoader.load(getClass().getResource("front_cours2.fxml"));
       Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
}
