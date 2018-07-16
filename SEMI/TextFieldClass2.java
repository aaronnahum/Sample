package DSP;


import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class TextfieldClass {
    static int screenWidth = ScreenResolutionClass.resolutionWidth();
    static int screenHeight = ScreenResolutionClass.resolutionHeight();
    static int fieldWidthAlignment = (int) ScreenResolutionClass.fieldWidthAlignment(screenWidth);
    static int proportionalHeight = ScreenResolutionClass.proportionalHeight(screenHeight);
    static double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
    static double numberOfFields = 2.5;
    static double halfPlusNumberOfFields = 2.875;
   
    public static ArrayList<TextField> revisionLogAddAField(int countPDF){
        ArrayList<TextField> AddAFieldTextFields = new ArrayList<>();
        
        if(numberOfFields <= 7.0) {
            numberOfFields += 0.75;
            halfPlusNumberOfFields += 0.75;
            
            if (countPDF == 1){
                TextField txtDescription = textfield("Please Enter The Description Here", fieldWidthAlignment * 38, false, fieldWidthAlignment * 2, (proportionalHeight*halfPlusNumberOfFields), "disabledTextField");
                AddAFieldTextFields.add(txtDescription);
                TextField txtRevision = textfield("R1234", 55, false, fieldWidthAlignment * 2, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtRevision);
                TextField txtDate = textfield("YY-MM-DD",70,false, fieldWidthAlignment * 4, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDate);
                TextField txtScope = textfield("123", 50,false,fieldWidthAlignment * 6, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtScope);
                TextField txtTermsNorms = textfield("123", 50,false,fieldWidthAlignment * 8, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtTermsNorms);
                TextField txtControlVolume = textfield("123", 50,false,fieldWidthAlignment * 10, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtControlVolume);
                TextField txtSystemModels = textfield("123", 50,false,fieldWidthAlignment * 12, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtSystemModels);
                TextField txtInterface = textfield("123",50, false,fieldWidthAlignment * 14, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtInterface);
                TextField txtDIP = textfield("123",30, false,fieldWidthAlignment * 16, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIP);
                TextField txtDIF = textfield("123", 30,false,fieldWidthAlignment * 17, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIF);
                TextField txtDIL = textfield("123",30, false,fieldWidthAlignment * 18, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIL);
                TextField txtKPFs = textfield("123",30, false,fieldWidthAlignment * 19, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtKPFs);
                TextField txtDIPVerification = textfield("123", 50,false,fieldWidthAlignment * 21, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIPVerification);
                TextField txtDNAGenerator = textfield("123",50, false,fieldWidthAlignment * 24, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDNAGenerator);
                TextField txtDNALibrary = textfield("123", 50,false,fieldWidthAlignment * 27, proportionalHeight*numberOfFields, "disabledTextField");

                AddAFieldTextFields.add(txtDNALibrary); 
            }
            else{
                TextField txtDescription = textfield("Please Enter The Description Here", fieldWidthAlignment * 38, false, fieldWidthAlignment * 2, (proportionalHeight*halfPlusNumberOfFields), "textField");
                AddAFieldTextFields.add(txtDescription);                
                TextField txtRevision = textfield("R1234", 55, true, fieldWidthAlignment * 2, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtRevision);
                TextField txtDate = textfield("YY-MM-DD",70,true, fieldWidthAlignment * 4, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDate);
                TextField txtScope = textfield("123", 50,true,fieldWidthAlignment * 6, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtScope);
                TextField txtTermsNorms = textfield("123", 50,true,fieldWidthAlignment * 8, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtTermsNorms);
                TextField txtControlVolume = textfield("123", 50,true,fieldWidthAlignment * 10, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtControlVolume);
                TextField txtSystemModels = textfield("123", 50,true,fieldWidthAlignment * 12, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtSystemModels);
                TextField txtInterface = textfield("123",50, true,fieldWidthAlignment * 14, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtInterface);
                TextField txtDIP = textfield("123",30, true,fieldWidthAlignment * 16, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIP);
                TextField txtDIF = textfield("123", 30,true,fieldWidthAlignment * 17, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIF);
                TextField txtDIL = textfield("123",30, true,fieldWidthAlignment * 18, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIL);
                TextField txtKPFs = textfield("123",30, true,fieldWidthAlignment * 19, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtKPFs);
                TextField txtDIPVerification = textfield("123", 50,true,fieldWidthAlignment * 21, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIPVerification);
                TextField txtDNAGenerator = textfield("123",50,true, fieldWidthAlignment * 24, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDNAGenerator);
                TextField txtDNALibrary = textfield("123", 50,true,fieldWidthAlignment * 27, proportionalHeight*numberOfFields, "textField");

                AddAFieldTextFields.add(txtDNALibrary);                 

            }

        }
        
        return AddAFieldTextFields;
    }
    

    public static TextField textfield(String text, int textWidth, Boolean booll, double positionX, double positionY, String style) {
    TextField textfield1 = new TextField();
        textfield1.setPromptText(text);
        textfield1.setAlignment(Pos.CENTER);
        textfield1.setPrefWidth(textWidth);
        textfield1.setEditable(booll);
       // eventually might need to add prefHeight
        textfield1.setLayoutX(positionX);
        textfield1.setLayoutY(positionY);
        textfield1.setId(style);
        
        return textfield1;
    }
        
}
