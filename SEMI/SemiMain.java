package DSP;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.PrintException;

import com.itextpdf.text.BadElementException;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;

public class RevisionLog{
        
    Stage window;
    static Scene scene;
    static ScrollPane pane;
    public static double numberOfFields = 2.5;
    public static int StartAtOne = 1;
    
    static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    
    static int screenWidth = (int) primaryScreenBounds.getWidth();
    static int screenHeight = (int) primaryScreenBounds.getHeight();
    static int fieldWidthAlignment = screenWidth/45;
    static int proportionalHeight = screenHeight/10;
    static double proportionalWidth = screenWidth/16;
    static double numberOfFields1 = 2.5;
    static double halfPlusNumberOfFields = 2.875;
    static double scale = DSP.scale;        
    static Group group;
    
    
    public static void revisionLogScene(Stage stage) throws ClassNotFoundException{
        ScrollPane pane = new ScrollPane();

        Group root = new Group();
        group = root;

        int screenProportionHeightby25 = screenHeight/25;   

        Line line11 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenProportionHeightby25,screenHeight-80);

        System.out.println("SCREEN BY 25:" + screenProportionHeightby25 );

        Line line2 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenProportionHeightby25+40);
            

        Line line3 = LineBlackNoFill(screenWidth-screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenHeight-80);

        Line line = LineBlackNoFill(screenWidth-screenProportionHeightby25, screenHeight-80, screenProportionHeightby25, screenHeight-80);

        root.getChildren().addAll(line11,line2,line3,line);

        Button btnAddAField = button("Add A New Revision and Unlock the Dashboard", fieldWidthAlignment *4, (proportionalHeight * 1.75), "functionalButtonBiggerText", true, "Adds a New Revision Line");
        btnAddAField.setOnAction(e -> {
            ArrayList<TextField> newField = revisionLogAddAField(0);
            for(int i = 0; i < newField.size(); i++)
                RevisionLog.group.getChildren().add(newField.get(i));
        });

        Button btnPrint = button("Print", 120, (screenHeight-75), "functionalButtonBiggerText" ,true, "Print the Current Page");
        btnPrint.setOnAction((ActionEvent e) -> {
            try {
                PrintTest.printPDF();
            } catch (IOException ex) {
                Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadElementException ex) {
                Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PrintException ex) {
                Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button btnDashboard = button("Dashboard", 220, (screenHeight-75), "functionalButtonBiggerText", true, "Redirects to the Dashboard Page");

        Button btnProjectRegistration = button("New Project Registration", 350, (screenHeight-75), "functionalButtonBiggerText" ,true, "Register a Project");

        Button btnSaveDraft = button("Save as PDF", proportionalWidth*7.5, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Save as PDF");
        btnSaveDraft.setOnAction(e -> {
            try {
                PDFClass.generatePDF2();
            } catch (IOException ex) {
                Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadElementException ex) {
                Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button btnRelease = button("Release", proportionalWidth*9.25, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Releases the Revision");

        Button btnRequestToLead = button("Request Lead To Open New Revision", proportionalWidth*11.0, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Request a Lead");
        btnRequestToLead.setOnAction(e -> {
            try {

                EmailClass.email();
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });


        Button btnScope =button("Scope", fieldWidthAlignment*6, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to Scope Page");

        Button btnTermsNorms = button("Terms/Norms", fieldWidthAlignment*8, proportionalHeight*(numberOfFields)-15, "functionalButton", true, 55*scale, "Redirects to Terms/Norms Page");

        System.out.println("THE SCALE IS" + scale);
        Button btnControlVolume = button("Control Volume", fieldWidthAlignment*10, proportionalHeight*numberOfFields-15, "functionalButton", true, 60*scale, "Redirects to Control Volume Page");

        Button btnSystemModels = button("System Models", fieldWidthAlignment*12, proportionalHeight*numberOfFields-15, "functionalButton", true, 60*scale, "Redirects to System Models Page");

        Button btnInterface = button("Interface", fieldWidthAlignment*14, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to Interface Page");

        Button btnDIP = button("DIP", fieldWidthAlignment*16, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIP Page");

        Button btnDIF = button("DIF", fieldWidthAlignment*17, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIF Page");

        Button btnDIL = button("DIL", fieldWidthAlignment*18, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIL Page");

        Button btnKPFs = button("KPFs", fieldWidthAlignment*19, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to KPFs Page");

        Button btnDIPVerification = button("DIP Verification", fieldWidthAlignment*21, proportionalHeight*numberOfFields-15, "functionalButton", true, 80*scale, "Redirects to DIP Verification Page");

        Button btnDNAGenerator = button("DNA Generator", fieldWidthAlignment*24, proportionalHeight*numberOfFields-15, "functionalButton", true, 75*scale, "Redirects to DNA Generator Page");

        Button btnDNALibrary = button("DNA Library", fieldWidthAlignment*27, proportionalHeight*numberOfFields, "functionalButton", true, 90*scale, "Redirects to DNA Library Page");

        root.getChildren().addAll(btnAddAField,btnPrint,btnDashboard,btnProjectRegistration,btnSaveDraft,btnRelease,btnRequestToLead,btnScope,btnTermsNorms,btnControlVolume,btnSystemModels,btnInterface,btnDIP,btnDIF,btnDIL,btnKPFs,btnDIPVerification,btnDNAGenerator);

        Label lblRevisionControl = label("REVISION CONTROL", 175, 15, 60, 30, "revisionControl", "The Current Menu");

        Label lblProjectID = label("123456789012345678901234567890", 250, 15, proportionalWidth*6, 30, "otherBorder", "Project ID");

        Label lblRevisionNum = label("R1", 75, 15, proportionalWidth*10, 30, "otherBorder", "Revision Number");

        Label lblDateBorder = label("YY-MM-DD", 75, 15, proportionalWidth*12, 30, "otherBorder", "Current Date");

        Label lblPageNum = label("Page 1 of 1", 75, 15, proportionalWidth*14, 30, "otherBorder", "Page Number");
        root.getChildren().addAll(lblRevisionControl,lblProjectID,lblRevisionNum,lblDateBorder,lblPageNum);
            
        TextField txtCode = textfield("Code",120, true, proportionalWidth*7.25, proportionalHeight*1.25, "textFieldBiggerText");
        root.getChildren().add(txtCode);

        Label lblRevision = label("Revision", 55, 15, fieldWidthAlignment*2, proportionalHeight *numberOfFields, "label", "Revision Number of Test");

        Label lblDate = label("Date", 40, 15, fieldWidthAlignment *4, proportionalHeight *numberOfFields, "label", "The Date the Test Took Place");

        Label lblCode = label("Release Code", 100, 15, proportionalWidth*5, proportionalHeight *1.25, "labelBiggerText", "The Code to Release the Revision");
        root.getChildren().addAll(lblRevision, lblDate, lblCode);
      
        pane.setContent(group);
        pane.setPannable(true);

        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
        pane.setPadding(new Insets(20, 0, 0, 25));
        scene = new Scene(root, Color.WHITE);

        stage.setScene(scene);
        stage.setTitle("Revision Log");

        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());

        stage.show();
        
    }