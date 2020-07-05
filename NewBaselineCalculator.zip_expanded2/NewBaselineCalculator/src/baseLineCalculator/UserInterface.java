
package baseLineCalculator;

import baseLineCalculator.BusinessLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * <p> Title: UserInterface Class. </p>
 * 
 * <p> Description: The Java/FX-based user interface test bed to develop and test UI ideas.</p>
 * 
 * <p> Copyright: 

 
 
 Robert Carter © 2018 </p>
 * 
 * @author Lynn Robert Carter
 * @author V.Ravi
 * 
 * @version 1.00 2018-02-03 The JavaFX-based GUI for the implementation of a test bed
 * 
 */

public class UserInterface {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	/* Constants used to parameterize the graphical user interface.  We do not use a layout manager for
	   this application. Rather we manually control the location of each graphical element for exact
	   control of the look and feel. */
	private Pane theRoot;
	private static double WINDOW_WIDTH;
	private BusinessLogic businessLogicObj;

	// These are the application values required by the user interface
	private Label label_Application_Title = new Label("Double Calculator"); // Application Title
	
	// CheckBox for operand1
	private Label op1CheckBoxLabel = new Label("Measured value");
	private CheckBox op1CheckBox = new CheckBox();
	
	// CheckBox for operand2
	private Label op2CheckBoxLabel = new Label("Measured value");
	private CheckBox op2CheckBox = new CheckBox();
	
	// These variables are related to First Operand
	private Label label_Operand1 = new Label("First operand");
	private TextField text_Operand1MeasuredValue = new TextField();
	private TextField text_Operand1ErrorTerm = new TextField();
	private Label label_errOperand1MeasuredValue = new Label("");	
	private Label label_errOperand1ErrorTerm = new Label("");
	private TextFlow errMeasuredValue;
    private Text errMVPart1 = new Text();
    private Text errMVPart2 = new Text();
	private TextFlow errErrorTerm;
    private Text errETPart1 = new Text();
    private Text errETPart2 = new Text();

    // These variables are related to Second Operand
    private Label label_Operand2 = new Label("Second operand");
	private TextField text_Operand2MeasuredValue = new TextField();
	private TextField text_Operand2ErrorTerm = new TextField();
	private Label label_errOperand2MeasuredValue = new Label("");	
	private Label label_errOperand2ErrorTerm = new Label("");	
	private TextFlow errMeasuredValue2;
    private Text errMV2Part1 = new Text();
    private Text errMV2Part2 = new Text();
	private TextFlow err2ErrorTerm;
    private Text errET2Part1 = new Text();
    private Text errET2Part2 = new Text();
    
    // These variables are related to all operands i.e first, second, result
	private Label label_measured_value_op1 = new Label("Measured Value");
	private Label label_error_value_op1 = new Label("Error Value");
	private Label label_measured_value_op2 = new Label("Measured Value");
	private Label label_error_value_op2 = new Label("Error Value");
	private Label label_result_measured_value = new Label("Measured Value");
	private Label label_result_error_value = new Label("Error Value");

	// These variables are related to Result operand   
    private Label label_result = new Label("Result");
	private TextField text_result_measured_value = new TextField();
	private TextField text_result_error_value = new TextField();
    private Label label_result_unit = new Label("Units");
    private TextField text_result_unit = new TextField();
    
	private double BUTTON_SPACE;		// These constants are defined based on the window width
	private double BUTTON_WIDTH = 50;	// at the time this object is instantiated
	private double BUTTON_OFFSET;
	
	// These variables are related to buttons
	private Button button_Add = new Button("\uFF0B");
	private Button button_Sub = new Button(" \u2212");
	private Button button_Mpy = new Button(" \u00D7");			// The multiply symbol: \u00D7
	private Button button_Div = new Button(" \u00F7");			// The divide symbol: \u00F7
	private Button button_sqrt = new Button(" \u221A");			// The Square Root symbol: \u221A
	private Button button_pow = new Button(" ^");				
	
	private String buttonClicked = "";
	
	// These variables are related to First Operand and Second Operand for enabling text fields
	private boolean op1mv;
	private boolean op1ev;
	private boolean op2mv;
	private boolean op2ev;
	
	// To ignore + or - sign in the given input
	private int startIndex; 
	
	// To display error that is obtained from the calculator value i.e Missing Value, Invalid Value, Excess Data
	private Label label_errOperand1 = new Label(""); 
	private Label label_errOperand2 = new Label("");												
	
 // UI Section asking the user to select a Word from a Select List
 	Group rootMainForOp1;
 	Group rootPopUpForOp1;
 	Scene sceneMainForOp1;
 	Scene scenePopUpForOp1;

 	Group rootMainForOp2;
 	Group rootPopUpForOp2;
 	Scene sceneMainForOp2;
 	Scene scenePopUpForOp2;

 	static Stage stagePopUpForOp1;
 	static Stage stagePopUpForOp2;

 	TitledPane t1, t2, t3, t4, t5, t6, t7, t8; //panes for accordion
 	ObservableList<Button> arrayA = FXCollections.observableArrayList();
 	ObservableList<Button> arrayB = FXCollections.observableArrayList();
 	ObservableList<Button> arrayC = FXCollections.observableArrayList();
 	ObservableList<Button> arrayD = FXCollections.observableArrayList();
 	ObservableList<Button> arrayE = FXCollections.observableArrayList();
 	ObservableList<Button> arrayF = FXCollections.observableArrayList();
 	ObservableList<Button> arrayG = FXCollections.observableArrayList();
 	ObservableList<Button> arrayH = FXCollections.observableArrayList();
 	
 	// UI Section asking the user to select a country from a JComboBox
 	Label labelSelectAUnitForOp1 = new Label("Select a Unit");
 	static Button btnSelectAUnitForOp1 = new Button("  - no unit selected - ");

 	Label labelSelectAUnitForOp2 = new Label("Select a Unit");
 	static Button btnSelectAUnitForOp2 = new Button("  - no unit selected - ");
 	
 	TextField outputSelectedUnitIndexForOp1 = new TextField("0");
	TextField outputSelectedUnitIndexForOp2 = new TextField("0");

 	// The quit button that terminates the execution of this application
 	Button buttonQuit = new Button();
 		
	Button btnUnit001 = createAccordionButtonForOp1 ("- no unit selected - ", "0");
	Button btnUnit002 = createAccordionButtonForOp1 ("Kilometers", "1");
	Button btnUnit003 = createAccordionButtonForOp1 ("Meters", "2");
	
	Button btnUnit004 = createAccordionButtonForOp1 ("Hours", "4");
	Button btnUnit005 = createAccordionButtonForOp1 ("Minutes", "5");
	Button btnUnit006 = createAccordionButtonForOp1 ("Seconds", "6");
	
	Button btnUnit007 = createAccordionButtonForOp1 ("Kilometers / Hour", "7");
	Button btnUnit008 = createAccordionButtonForOp1 ("Meters / Second", "8");	
	
	Button btnUnit009 = createAccordionButtonForOp1 ("Kilometers / Hour ^ 2", "9");
	Button btnUnit010 = createAccordionButtonForOp1 ("Meters / Second ^ 2", "10");

	Button btnOp2Unit000 = createAccordionButtonForOp2 ("- no unit selected - ", "0");
	
	Button btnOp2Unit001 = createAccordionButtonForOp2 ("- no unit selected - ", "0");
	Button btnOp2Unit002 = createAccordionButtonForOp2 ("Kilometers", "1");
	Button btnOp2Unit003 = createAccordionButtonForOp2 ("Meters", "2");
	
	Button btnOp2Unit004 = createAccordionButtonForOp2 ("Hours", "4");
	Button btnOp2Unit005 = createAccordionButtonForOp2 ("Minutes", "5");
	Button btnOp2Unit006 = createAccordionButtonForOp2 ("Seconds", "6");
	
	Button btnOp2Unit007 = createAccordionButtonForOp2 ("Kilometers / Hour", "7");
	Button btnOp2Unit008 = createAccordionButtonForOp2 ("Meters / Second", "8");	
	
	Button btnOp2Unit009 = createAccordionButtonForOp2 ("Kilometers / Hour ^ 2", "9");
	Button btnOp2Unit010 = createAccordionButtonForOp2 ("Meters / Second ^ 2", "10");

	/**********************************************************************************************

	Constructors
	
	**********************************************************************************************/

	/**********
	 * This method initializes all of the elements of the graphical user interface. These assignments
	 * determine the location, size, font, color, and change and event handlers for each GUI object.
	 */
	
    public UserInterface (Pane root, double ww) {
		// Save the window root for the setup of the user interface
		theRoot = root;
		
		// Define the formatting constants using the window width from the mainline
		WINDOW_WIDTH = ww;
		BUTTON_SPACE = WINDOW_WIDTH / 35;		// There are five gaps
		BUTTON_WIDTH = WINDOW_WIDTH / 10;		// The width of a button from experimentation
		BUTTON_OFFSET = BUTTON_WIDTH / 2;		// The button offset is half the button width
		
		// Set up the User Interface
		initializeTheUserInterface(theRoot);
		businessLogicObj  = new BusinessLogic();	
	}
	
	public void initializeTheUserInterface(Pane theRoot) {
		
		// Label theScene with the name of the calculator, centered at the top of the pane
		setupLabelUI(label_Application_Title, "Arial", 24, WINDOW_WIDTH, Pos.CENTER, 0, 10);
		// Label checkBox for Operand 1
		setupLabelUI(op1CheckBoxLabel, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 30, 35);
		setCheckBoxUI(op1CheckBox,Pos.BASELINE_LEFT, 10, 50, true);
		
		op1CheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {selectCheckBoxOp1();});

		// Label the first operand just above it, left aligned
		setupLabelUI(label_Operand1, "Arial", 18, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 52);
		setupLabelUI(label_measured_value_op1, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 70);
		setupLabelUI(label_error_value_op1, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 50, 70);

		// Establish the first text input operand field and when anything changes in operand 1 measured value,
		// measured value process all fields to ensure that we are ready to perform as soon as possible.
		setupTextUI(text_Operand1MeasuredValue, "Arial", 18, WINDOW_WIDTH/2 + 30, Pos.BASELINE_LEFT, 10, 89, true);
		text_Operand1MeasuredValue.textProperty().addListener((observable, oldValue, newValue) 
				-> {setOperand1MeasuredValue(); });
		
		// Establish the Error Term text field for the first operand.  If anything changes, process
		// all fields to ensure that we are ready to perform as soon as possible.
		setupTextUI(text_Operand1ErrorTerm, "Arial", 18, 220, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 50, 89, false);
		text_Operand1ErrorTerm.textProperty().addListener((observable, oldValue, newValue) 
				-> {setOperand1ErrorTerm(); });
		
		// Establish an error message for the first operand Measured Value, left aligned
		label_errOperand1MeasuredValue.setTextFill(Color.RED);
		label_errOperand1MeasuredValue.setAlignment(Pos.BASELINE_RIGHT);
		setupLabelUI(label_errOperand1MeasuredValue, "Arial", 14, WINDOW_WIDTH-150-10, Pos.BASELINE_LEFT, 22, 137);
		
		// Establish an error message for the first operand Error Term, left aligned
		label_errOperand1ErrorTerm.setTextFill(Color.RED);
		label_errOperand1ErrorTerm.setAlignment(Pos.BASELINE_RIGHT);
		setupLabelUI(label_errOperand1ErrorTerm, "Arial", 14, WINDOW_WIDTH-150-10, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 - 150, 137);
		setupLabelUI(label_errOperand1, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 53);
		label_errOperand1.setTextFill(Color.RED);

		// Label checkBox for Operand 2
		setupLabelUI(op2CheckBoxLabel, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 30, 157);
		setCheckBoxUI(op2CheckBox,Pos.BASELINE_LEFT, 10, 172, true);

		op2CheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {selectCheckBoxOp2();});

		// Label the Second operand just above it, left aligned
		setupLabelUI(label_Operand2, "Arial", 18, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 175);
		setupLabelUI(label_measured_value_op2, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 193);
		setupLabelUI(label_error_value_op2, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 50, 193);

		// Establish the Second text input operand field and when anything changes in operand 1 measured value,
		// measured value process all fields to ensure that we are ready to perform as soon as possible.
		setupTextUI(text_Operand2MeasuredValue, "Arial", 18, WINDOW_WIDTH/2 + 30, Pos.BASELINE_LEFT, 10, 211, true);
		text_Operand2MeasuredValue.textProperty().addListener((observable, oldValue, newValue) 
				-> {setOperand2MeasuredValue(); });
		 
		// Establish the Error Term text field for the second operand.  If anything changes, process
		// all fields to ensure that we are ready to perform as soon as possible.
		setupTextUI(text_Operand2ErrorTerm, "Arial", 18, 220, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 50, 211, false);
		text_Operand2ErrorTerm.textProperty().addListener((observable, oldValue, newValue) 
				-> {setOperand2ErrorTerm();});
		
		// Establish an error message for the second operand Measured Value, left aligned
		label_errOperand2MeasuredValue.setTextFill(Color.RED);
		label_errOperand2MeasuredValue.setAlignment(Pos.BASELINE_RIGHT);
		setupLabelUI(label_errOperand2MeasuredValue, "Arial", 14,  
						WINDOW_WIDTH-150-10, Pos.BASELINE_LEFT, 22, 260);
		
		// Establish an error message for the second operand Error Term, left aligned
		label_errOperand2ErrorTerm.setTextFill(Color.RED);
		label_errOperand2ErrorTerm.setAlignment(Pos.BASELINE_RIGHT);
		setupLabelUI(label_errOperand2ErrorTerm, "Arial", 14, WINDOW_WIDTH-150-10, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 - 150, 260);
		setupLabelUI(label_errOperand2, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 176);
		label_errOperand2.setTextFill(Color.RED);
 
		// Result 
		setupLabelUI(label_result, "Arial", 18, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 272);
		setupLabelUI(label_result_measured_value, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 290);
		setupLabelUI(label_result_error_value, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 50, 290);
		setupLabelUI(label_result_unit, "Arial", 14, WINDOW_WIDTH-10, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 280, 290);

		setupTextUI(text_result_measured_value, "Arial", 18, WINDOW_WIDTH/2 + 30, Pos.BASELINE_LEFT, 10, 308, false);
		setupTextUI(text_result_error_value, "Arial", 18, 220, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 50, 308, false);
		setupTextUI(text_result_unit, "Arial", 18, 170, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 280, 308, false);

		 BUTTON_SPACE = WINDOW_WIDTH / 5 - 20;		// There are five gaps
		 BUTTON_WIDTH = WINDOW_WIDTH / 20;			// The width of a button from experimentation
		 BUTTON_OFFSET = BUTTON_WIDTH / 2;			// The button offset is half the button width

		// Establish the ADD "+" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Add, "Symbol", 28, BUTTON_WIDTH, Pos.BASELINE_LEFT, 0.3 * BUTTON_SPACE-BUTTON_OFFSET, 370);
		button_Add.setOnAction((event) -> {
		convertOperand1(); convertOperand2();
		String unit1 = outputSelectedUnitIndexForOp1.getText();
		String unit2 = outputSelectedUnitIndexForOp2.getText();
		convertOperand1(); convertOperand2();
		if(businessLogicObj.isUnitsCompatible(unit1, unit2)) {
		if (!binaryOperandIssues()) {label_errOperand2.setText(" ");
		label_result.setText("Sum");System.out.println("SUM :" + businessLogicObj.addOperands());
		text_result_measured_value.setText(businessLogicObj.addOperands().split(":")[0]);
		text_result_error_value.setText(businessLogicObj.addOperands().split(":")[1]);setResultUnitTextFieldForAddSub();}
		} else {label_result.setText("Result"); text_result_measured_value.setText(""); text_result_error_value.setText("");
		text_result_unit.setText("");}}); 
		
		// Establish the SUB "-" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Sub, "Symbol", 28, BUTTON_WIDTH, Pos.BASELINE_LEFT, 1.3 * BUTTON_SPACE-BUTTON_OFFSET, 370);
		button_Sub.setOnAction((event) -> {
		convertOperand1(); convertOperand2();
		String unit1 = outputSelectedUnitIndexForOp1.getText();
		String unit2 = outputSelectedUnitIndexForOp2.getText();
		convertOperand1(); convertOperand2();
		if(businessLogicObj.isUnitsCompatible(unit1, unit2)) {
		if(!binaryOperandIssues()) {label_errOperand2.setText(" ");
		label_result.setText("Differnce"); text_result_measured_value.setText(businessLogicObj.subOperands().split(":")[0]);
		text_result_error_value.setText(businessLogicObj.subOperands().split(":")[1]);setResultUnitTextFieldForAddSub();}
		} else {label_result.setText("Result"); text_result_measured_value.setText(""); text_result_error_value.setText("");
		text_result_unit.setText("");}});
		
		// Establish the MPY "x" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Mpy, "Symbol", 28, BUTTON_WIDTH, Pos.BASELINE_LEFT, 2.3 * BUTTON_SPACE-BUTTON_OFFSET, 370);
		button_Mpy.setOnAction((event) -> { buttonClicked = "*";
		convertOperand1(); convertOperand2(); setResultUnitsForMpyDiv();
		if (!binaryOperandIssues()) {label_errOperand2.setText(" ");
		label_result.setText("Product"); text_result_measured_value.setText(businessLogicObj.mpyOperands().split(":")[0]);
		text_result_error_value.setText(businessLogicObj.mpyOperands().split(":")[1]);}
		else {label_result.setText("Result"); text_result_measured_value.setText(""); text_result_error_value.setText(""); text_result_unit.setText("");}});
		
		// Establish the DIV "/" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_Div, "Symbol", 28, BUTTON_WIDTH, Pos.BASELINE_LEFT, 3.3 * BUTTON_SPACE-BUTTON_OFFSET, 370);
		button_Div.setOnAction((event) -> { buttonClicked = "/";
		convertOperand1(); convertOperand2(); setResultUnitsForMpyDiv();	
		if (!binaryOperandIssues()) {label_errOperand2.setText(" "); label_result.setText("Division");
		if (businessLogicObj.divOperands() == "null") label_errOperand2.setText("Error: / by 0 Not Possible"); 
		else {text_result_measured_value.setText(businessLogicObj.divOperands().split(":")[0]);
		text_result_error_value.setText(businessLogicObj.divOperands().split(":")[1]);}}
		else {label_result.setText("Result"); text_result_measured_value.setText(""); text_result_error_value.setText(""); text_result_unit.setText("");}});

		// Establish the Square root button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_sqrt, "Symbol", 28, BUTTON_WIDTH, Pos.BASELINE_LEFT, 4.3 * BUTTON_SPACE-BUTTON_OFFSET, 370);
		button_sqrt.setOnAction((event) -> {convertOperand1(); convertOperand2();text_Operand2MeasuredValue.setText(""); text_Operand2ErrorTerm.setText("");
		if(businessLogicObj.isOperand1Defined()) {if(businessLogicObj.sqrtOperands() == null) {
		label_errOperand1.setText("Square root cannot be performed for negative numbers");
		label_result.setText("Result");} else {text_result_measured_value.setText(businessLogicObj.sqrtOperands().split(":")[0]);
		text_result_error_value.setText(businessLogicObj.sqrtOperands().split(":")[1]); 
		if(!btnSelectAUnitForOp1.getText().trim().equals("- no unit selected -")) {
			text_result_unit.setText(btnSelectAUnitForOp1.getText() + " ^ " + "1/2");
		} else {
			text_result_unit.setText("No Units");	
		}
		text_Operand2MeasuredValue.setText("");text_Operand2ErrorTerm.setText("");label_errOperand2.setText("");}} else 
		{label_result.setText("Result"); text_result_measured_value.setText(""); text_result_error_value.setText("");}});
		
		// Establish the Power "^" button, position it, and link it to methods to accomplish its work
		setupButtonUI(button_pow, "Symbol", 28, BUTTON_WIDTH, Pos.BASELINE_LEFT, 5.3 * BUTTON_SPACE-BUTTON_OFFSET, 370);
		button_pow.setOnAction((event) -> {convertOperand1(); convertOperand2();if(op2CheckBox.isSelected()) {text_Operand2MeasuredValue.setText(""); text_Operand2ErrorTerm.setText("");
		businessLogicObj.setOperand2Defined(false); op2CheckBox.setSelected(false);
		if(businessLogicObj.isOperand1Defined()) {label_errOperand2.setText("Please Enter A Constant Value");
		return;}} if (!binaryOperandIssues()) {label_errOperand2.setText(" ");
		label_result.setText("Power"); text_result_measured_value.setText(businessLogicObj.powOperands().split(":")[0]);
		text_result_error_value.setText(businessLogicObj.powOperands().split(":")[1]);
		if(!btnSelectAUnitForOp1.getText().trim().equals("- no unit selected -")) {
			text_result_unit.setText(btnSelectAUnitForOp1.getText() + " ^ " + text_Operand2MeasuredValue.getText());
		} else {
			text_result_unit.setText("No Units");	
			}
		} else {label_result.setText("Result"); text_result_measured_value.setText(""); text_result_error_value.setText(""); text_result_unit.setText("");}});

		// error Measured Value for arrow and description for that text
		errMVPart1.setFill(Color.BLACK);
	    errMVPart1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errMVPart2.setFill(Color.RED);
	    errMVPart2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    errMeasuredValue = new TextFlow(errMVPart1, errMVPart2);
		errMeasuredValue.setMinWidth(WINDOW_WIDTH-10); 
		errMeasuredValue.setLayoutX(22);  
		errMeasuredValue.setLayoutY(116);
		
		// Error Message for the Error Term for operand 1
	    errETPart1.setFill(Color.BLACK);
	    errETPart1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errETPart2.setFill(Color.RED);
	    errETPart2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    errErrorTerm = new TextFlow(errETPart1, errETPart2);
	    
		// Establish an error message for the second operand just above it with, left aligned
		errErrorTerm.setMinWidth(WINDOW_WIDTH-10); 
		errErrorTerm.setLayoutX(WINDOW_WIDTH/2+63);  
		errErrorTerm.setLayoutY(116);

		// error Measured Value for arrow and description for that text
		errMV2Part1.setFill(Color.BLACK);
	    errMV2Part1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errMV2Part2.setFill(Color.RED);
	    errMV2Part2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    errMeasuredValue2 = new TextFlow(errMV2Part1, errMV2Part2);
		errMeasuredValue2.setMinWidth(WINDOW_WIDTH-10); 
		errMeasuredValue2.setLayoutX(22);  
		errMeasuredValue2.setLayoutY(240);
		
		// Error Message for the Error Term for operand 2
	    errET2Part1.setFill(Color.BLACK);
	    errET2Part1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
	    errET2Part2.setFill(Color.RED);
	    errET2Part2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
	    err2ErrorTerm = new TextFlow(errET2Part1, errET2Part2);
	    
		// Establish an error message for the second operand just above it with, left aligned
		err2ErrorTerm.setMinWidth(WINDOW_WIDTH-10); 
		err2ErrorTerm.setLayoutX(WINDOW_WIDTH/2+63);  
		err2ErrorTerm.setLayoutY(240);
		
		// Accordion
		setupLabelUI(labelSelectAUnitForOp1, "Arial", 14, 320, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 280, 68);
		setupButtonUI(btnSelectAUnitForOp1, "Arial", 16, 170, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 280, 88);

		btnSelectAUnitForOp1.setOnAction(e->{
			if (stagePopUpForOp1.isShowing()) {
				stagePopUpForOp1.toFront();
			} else {
				stagePopUpForOp1.showAndWait();
				}
			
		outputSelectedUnitIndexForOp1.setText(btnSelectAUnitForOp1.getId());
		btnSelectAUnitForOp1.setMinWidth(120);});		

		setupLabelUI(labelSelectAUnitForOp2, "Arial", 14, 320, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 280, 192);
		setupButtonUI(btnSelectAUnitForOp2, "Arial", 16, 170, Pos.BASELINE_LEFT, WINDOW_WIDTH/2 + 280, 210);

		btnSelectAUnitForOp2.setOnAction(e->{
			if (stagePopUpForOp2.isShowing()) {
				stagePopUpForOp2.toFront();
			} else {
				stagePopUpForOp2.showAndWait();
				}
		outputSelectedUnitIndexForOp2.setText(btnSelectAUnitForOp2.getId());
		btnSelectAUnitForOp2.setMinWidth(120);});		

		setupButtonUI(buttonQuit, "Dialog", 16, 70, Pos.BOTTOM_RIGHT, 840, 485);
		buttonQuit.setText("  Quit  ");
		buttonQuit.setOnAction((event) -> doQuit());

		arrayA = FXCollections.observableArrayList(btnUnit001, btnUnit002, btnUnit003);
		arrayB = FXCollections.observableArrayList(btnUnit001, btnUnit004, btnUnit005, btnUnit006);		
		arrayC = FXCollections.observableArrayList(btnUnit001, btnUnit007, btnUnit008);
		arrayD = FXCollections.observableArrayList(btnUnit001, btnUnit009,btnUnit010);

		arrayE = FXCollections.observableArrayList(btnOp2Unit001, btnOp2Unit002, btnOp2Unit003);
		arrayF = FXCollections.observableArrayList(btnOp2Unit001, btnOp2Unit004, btnOp2Unit005, btnOp2Unit006);		
		arrayG = FXCollections.observableArrayList(btnOp2Unit001, btnOp2Unit007, btnOp2Unit008);
		arrayH = FXCollections.observableArrayList(btnOp2Unit001, btnOp2Unit009,btnOp2Unit010);

		rootMainForOp1 = new Group();			// Create a group to hold the window UI elements
		rootPopUpForOp1 = new Group();
		
		rootMainForOp2 = new Group();			// Create a group to hold the window UI elements
		rootPopUpForOp2 = new Group();

		// This objects establish the five accordion panes
				t1 = new TitledPane("Distance", new ListView<>(arrayA));
				t2 = new TitledPane("Time", new ListView<>(arrayB));
				t3 = new TitledPane("Velocity", new ListView<>(arrayC));
				t4 = new TitledPane("Acceleration", new ListView<>(arrayD));

				Accordion accordion = new Accordion();
				accordion.getPanes().addAll(t1,t2,t3,t4);
				accordion.setMinWidth(300);
				accordion.setMaxHeight(400);
				
				rootMainForOp1.getChildren().addAll(labelSelectAUnitForOp1, btnSelectAUnitForOp1, buttonQuit);
				rootPopUpForOp1.getChildren().addAll(accordion);

				sceneMainForOp1 = new Scene(rootMainForOp1, WINDOW_WIDTH, 500);		// Create the scene with
				scenePopUpForOp1 = new Scene(rootPopUpForOp1, 300, 400);

				stagePopUpForOp1 = new Stage();
				stagePopUpForOp1.setScene(scenePopUpForOp1);
				stagePopUpForOp1.setTitle("Units for Operand 1");

				t5 = new TitledPane("Distance", new ListView<>(arrayE));
				t6 = new TitledPane("Time", new ListView<>(arrayF));
				t7 = new TitledPane("Velocity", new ListView<>(arrayG));
				t8 = new TitledPane("Acceleration", new ListView<>(arrayH));

				Accordion accordion2 = new Accordion();
				accordion2.getPanes().addAll(t5,t6,t7,t8);
				accordion2.setMinWidth(300);
				accordion2.setMaxHeight(400);
			
				rootMainForOp2.getChildren().addAll(labelSelectAUnitForOp2, btnSelectAUnitForOp2);
				rootPopUpForOp2.getChildren().addAll(accordion2);

				sceneMainForOp2 = new Scene(rootMainForOp2, WINDOW_WIDTH, 500);		// Create the scene with
				scenePopUpForOp2 = new Scene(rootPopUpForOp2, 300, 400);

				stagePopUpForOp2 = new Stage();
				stagePopUpForOp2.setScene(scenePopUpForOp2);
				stagePopUpForOp2.setTitle("Units for Operand 2");
		
		// Place all of the just-initialized GUI elements into the pane
		theRoot.getChildren().addAll(label_Application_Title, op1CheckBoxLabel, op1CheckBox, label_Operand1, 
				text_Operand1MeasuredValue, text_Operand1ErrorTerm, label_errOperand1MeasuredValue, label_errOperand1ErrorTerm,
				op2CheckBoxLabel, op2CheckBox, label_Operand2, text_Operand2MeasuredValue, text_Operand2ErrorTerm, 
				label_errOperand2MeasuredValue, label_errOperand2ErrorTerm, errMeasuredValue, errErrorTerm, 
				errMeasuredValue2, err2ErrorTerm, label_measured_value_op1, label_error_value_op1, label_measured_value_op2, 
				label_error_value_op2, label_result, label_result_measured_value, label_result_error_value, 
				text_result_measured_value, text_result_error_value, label_result_unit, text_result_unit, 
				button_Add, button_Sub, button_Mpy, button_Div, button_sqrt, button_pow, 
				label_errOperand1, label_errOperand2, rootMainForOp1, rootMainForOp2
				);
	}
	
	
	/**********
	 * Private local method to initialize the standard fields for a label
	 */
	private void setupLabelUI(Label l, String ff, double f, double w, Pos p, double x, double y){
		l.setFont(Font.font(ff, f));
		l.setMinWidth(w);
		l.setAlignment(p);
		l.setLayoutX(x);
		l.setLayoutY(y);		
	}
	
	/**********
	 * Private local method to initialize the standard fields for a text field
	 */
	private void setupTextUI(TextField t, String ff, double f, double w, Pos p, double x, double y, boolean e){
		t.setFont(Font.font(ff, f));
		t.setMinWidth(w);
		t.setMaxWidth(w);
		t.setAlignment(p);
		t.setLayoutX(x);
		t.setLayoutY(y);		
		t.setEditable(e);
	}
	
	/**********
	 * Private local method to initialize the standard fields for a button
	 */
	private void setupButtonUI(Button b, String ff, double f, double w, Pos p, double x, double y){
		b.setFont(Font.font(ff, f));
		b.setMinWidth(w);
		b.setAlignment(p);
		b.setLayoutX(x);
		b.setLayoutY(y);		
	}
	
	/**
	 * Private Local Method To Initialize The Standard Fields of CheckBox
	 */
	private void setCheckBoxUI(CheckBox checkBoxObj, Pos p, int x, int y, boolean b) {
		// TODO Auto-generated method stub
		checkBoxObj.setAlignment(p);
		checkBoxObj.setLayoutX(x);
		checkBoxObj.setLayoutY(y);
		checkBoxObj.setMinHeight(20);
		checkBoxObj.setMinWidth(20);
		checkBoxObj.setSelected(b);
	}
	
	/**
	 * Private Local Method for changing the labels check box, measured value and to set visibility of
	 * label error value and text box error value of operand 1
	 * If check box is selected then the above two fields are visible otherwise they are not visible
	 */
	private void selectCheckBoxOp1() {
		// TODO Auto-generated method stub
		
		boolean checkBox1Selected = op1CheckBox.isSelected();
		if(!checkBox1Selected) {
			op1CheckBoxLabel.setText("Constant");
			label_measured_value_op1.setText("Constant");
			text_Operand1ErrorTerm.setText("");
			label_errOperand1.setText("");
		} else {
			op1CheckBoxLabel.setText("Measured Value");
			label_measured_value_op1.setText("Measured Value");
		}
		
		text_Operand1ErrorTerm.setEditable(checkBox1Selected);
		convertOperand1();
		setResultFields();			
	}

	/**
	 * Private Local Method for changing the labels check box, measured value and set the visibility of
	 * label error value and text box error value of operand 2
	 * If check box is selected then the above two fields are visible otherwise they are not visible
	 */
	private void selectCheckBoxOp2() {
		// TODO Auto-generated method stub
		
		boolean checkBox2Selected = op2CheckBox.isSelected();
		if(!checkBox2Selected) {
			op2CheckBoxLabel.setText("Constant");
			label_measured_value_op2.setText("Constant");
			text_Operand2ErrorTerm.setText("");
			label_errOperand2.setText("");
		} else {
			op2CheckBoxLabel.setText("Measured Value");
			label_measured_value_op2.setText("Measured Value");
		}
		
		text_Operand2ErrorTerm.setEditable(checkBox2Selected);		
		convertOperand2();
		setResultFields();				
	}
	
	/**
	 * Private Local Method for setting the visibility of label error value and text box
	 * error value of result
	 * If both check boxes are selected then above both fields get hide otherwise they are visible
	 */
	private void setResultFields() {
		// TODO Auto-generated method stub
		boolean checkBox1Selected = op1CheckBox.isSelected();
		boolean checkBox2Selected = op2CheckBox.isSelected();
		if(!checkBox1Selected || !checkBox2Selected) {text_result_error_value.setText("");}
	}

	private void setResultUnitTextFieldForAddSub() {
		int u1 = Integer.parseInt(outputSelectedUnitIndexForOp1.getText());
		int u2 = Integer.parseInt(outputSelectedUnitIndexForOp2.getText());
		if(u1 == 0 && u2 != 0) {
			text_result_unit.setText(btnSelectAUnitForOp2.getText());
		} else if (u2 == 0 && u1 != 0) {
			text_result_unit.setText(btnSelectAUnitForOp1.getText());
		} else if(u1 < u2) {
			text_result_unit.setText(btnSelectAUnitForOp1.getText());
		} else {
			text_result_unit.setText(btnSelectAUnitForOp2.getText());
		}
	}
	
	private void setResultUnitsForMpyDiv() {
		
		int u1 = Integer.parseInt(outputSelectedUnitIndexForOp1.getText());
		int u2 = Integer.parseInt(outputSelectedUnitIndexForOp2.getText());
		
		String unitCode = businessLogicObj.isUNitsCompatibleForMPYDIV(u1, u2);
		
		if (!unitCode.isEmpty() && (unitCode.charAt(0) == '1' || unitCode.charAt(0) == '2')) {
			text_result_unit.setText("(" + unitCode.substring(1) + ")^2");
		} else {
			if((u1 == 0 && u2 == 0)) {
				text_result_unit.setText(btnSelectAUnitForOp2.getText());
			} else if (u1 == 0 && u2 != 0) {
				text_result_unit.setText(btnSelectAUnitForOp2.getText());
			} else if (u1 != 0 && u2 == 0) {
				text_result_unit.setText(btnSelectAUnitForOp1.getText());
			} else if(u1 != u2) {
				String[] arr = unitCode.split(",");
				if (arr.length == 1 && !arr[0].isEmpty() && arr[0].charAt(1) == '2') {
					if(buttonClicked.equals("*")) {
						text_result_unit.setText(btnSelectAUnitForOp1.getText() + " * " + arr[0].substring(2));
					} else if (buttonClicked.equals("/")) {
						text_result_unit.setText(btnSelectAUnitForOp1.getText() + " / " + arr[0].substring(2));	
					}
				} else if(arr.length == 1 && !arr[0].isEmpty() && arr[0].charAt(1) == '1') {
					if (buttonClicked.equals("*")) {
						text_result_unit.setText(arr[0].substring(2) + " * " + btnSelectAUnitForOp2.getText());
					} else if (buttonClicked.equals("/")) {
						text_result_unit.setText(arr[0].substring(2) + " / " + btnSelectAUnitForOp2.getText());
					}
				} else if (arr.length == 1 && arr[0].isEmpty()) {
					if (buttonClicked.equals("*")) {
						text_result_unit.setText(btnSelectAUnitForOp1.getText() + " * " + btnSelectAUnitForOp2.getText());
					} else if (buttonClicked.equals("/")) {
						text_result_unit.setText(btnSelectAUnitForOp1.getText() + " / " + btnSelectAUnitForOp2.getText());
					}
				} else {
					if(buttonClicked.equals("*")) {
					text_result_unit.setText(arr[0].substring(2) + " * " + arr[1].substring(2)); 
					} else {
						text_result_unit.setText(arr[0].substring(2) + " / " + arr[1].substring(2)); 	
					}
				}
			} else {
				if (buttonClicked.equals("*")) {
					text_result_unit.setText("(" + btnSelectAUnitForOp2.getText() + ")^2");
				} else if (buttonClicked.equals("/")) {
					text_result_unit.setText("No Units");
				}
			}
		}
	}

	/**********
	 * Create a new button, set up its word, and set up the value 
	 * 
	 * @param buttonText	The text that defines the word
	 * @param txtIndex		The text that defines the word's index
	 * @return
	 */
	private Button createAccordionButtonForOp1 (String buttonText, String txtIndex) {
		Button button = new Button(buttonText);
		button.setId(txtIndex);
		button.setOnAction(eve->{btnSelectAUnitForOp1.setText(button.getText());
		btnSelectAUnitForOp1.setId(button.getId());
		outputSelectedUnitIndexForOp1.setText(txtIndex);});
		return button;
	}		

	private Button createAccordionButtonForOp2 (String buttonText, String txtIndex) {
		Button button = new Button(buttonText);
		button.setId(txtIndex);
		button.setOnAction(eve->{btnSelectAUnitForOp2.setText(button.getText());
		btnSelectAUnitForOp2.setId(txtIndex);
		outputSelectedUnitIndexForOp2.setText(txtIndex);});
		return button;
	}		

	/**
	 * Code to handle the "Quit" button.
	 * @param e ActionEvent
	 */
	private void doQuit() {
		System.exit(0);
	}
	/**********************************************************************************************

	User Interface Actions
	
	**********************************************************************************************/
	// sets the variables related to operand1 
	private void setOperand1MeasuredValue() {
		label_errOperand1MeasuredValue.setText("");
		label_errOperand1.setText("");
		errMVPart1.setText("");
		errMVPart2.setText("");
		label_result.setText("Result");
		text_result_measured_value.setText("");									// Clear the result field
		text_result_error_value.setText("");									// Clear the result field
     	convertOperand1();
	}
	
	private void setOperand1ErrorTerm() {
		label_errOperand1ErrorTerm.setText("");
		errETPart1.setText("");
		errETPart2.setText("");
		label_result.setText("Result");
		text_result_measured_value.setText("");									// Clear the result field
		text_result_error_value.setText("");									// Clear the result field
		convertOperand1();
	}
	
	private void setOperand2MeasuredValue() {
		label_errOperand2MeasuredValue.setText("");
		label_errOperand2.setText("");
		errMV2Part1.setText("");
		errMV2Part2.setText("");
		label_result.setText("Result");
		text_result_measured_value.setText("");									// Clear the result field
		text_result_error_value.setText("");									// Clear the result field
		convertOperand2();
	}
	
	private void setOperand2ErrorTerm() {
		label_errOperand2ErrorTerm.setText("");
		errET2Part1.setText("");
		errET2Part2.setText("");
		label_result.setText("Result");
		text_result_measured_value.setText("");									// Clear the result field
		text_result_error_value.setText("");									// Clear the result field
		convertOperand2();
	}
	
	private void convertOperand1() {
		
		op1mv = false;
		op1ev = false;
		startIndex = 0;
		
		String measuredValue = text_Operand1MeasuredValue.getText().trim();
		if (measuredValue.length() > 0 && (measuredValue.charAt(0) == '+' || measuredValue.charAt(0) == '-')) {startIndex++;}
		
		String errorValue = text_Operand1ErrorTerm.getText().trim();
		String errMessage = MeasuredValueRecognizer.checkMeasuredValue(measuredValue.substring(startIndex));
		
		if (errMessage != "") {
			label_errOperand1MeasuredValue.setText(MeasuredValueRecognizer.measuredValueErrorMessage);
			if (MeasuredValueRecognizer.measuredValueIndexofError <= -1) return;
			String input = MeasuredValueRecognizer.measuredValueInput;
			errMVPart1.setText(input.substring(0, MeasuredValueRecognizer.measuredValueIndexofError));
			errMVPart2.setText("\u21EB");
			label_errOperand1ErrorTerm.setText("");
			op1mv = false;
			businessLogicObj.setOperand1Defined(false);
		} else {op1mv = true;}
		
		text_Operand1ErrorTerm.setEditable(op1mv && op1CheckBox.isSelected()); label_errOperand1ErrorTerm.setText("");
		
		startIndex = 0;
		
		if (errorValue.length() > 0 && (errorValue.charAt(0) == '+' || errorValue.charAt(0) == '-')) {startIndex++;}

		errMessage = ErrorTermRecognizer.checkErrorTerm(errorValue.substring(startIndex));
		if (errMessage != "" && op1mv) {
			System.out.println(errMessage);
			label_errOperand1ErrorTerm.setText(ErrorTermRecognizer.errorTermErrorMessage);
			String input = ErrorTermRecognizer.errorTermInput;
			if (ErrorTermRecognizer.errorTermIndexofError <= -1) return;
			errETPart1.setText(input.substring(0, ErrorTermRecognizer.errorTermIndexofError).trim());
			errETPart2.setText("\u21EB");
			op1ev = false;
		} else {op1ev = true; errETPart1.setText(""); errETPart2.setText(""); label_errOperand1ErrorTerm.setText("");}
		
		if (op1mv && op1ev) {text_Operand2MeasuredValue.setEditable(op1mv);
			errorValue = !op1CheckBox.isSelected() ? "0"  : errorValue; 
			businessLogicObj.setOperand1(measuredValue, errorValue);
			String errorString = businessLogicObj.getOperand1ErrorMessage();			// make and operand out of it
			if (errorString.length() > 0) {												// If there is an error the
				label_errOperand1.setText(errorString);									// returned error string is used
				businessLogicObj.setOperand1Defined(false);
				return;
			}
			label_errOperand1.setText("");									// returned error string is used
			label_errOperand1MeasuredValue.setText("");									// Reset the error message
		} else {
			businessLogicObj.setOperand1Defined(false);
		}
	}
	
	private void convertOperand2() {
		
		op2mv = false;
		op2ev = false;
		startIndex = 0;
		
		String measuredValue = text_Operand2MeasuredValue.getText();
		if (measuredValue.length() > 0 && (measuredValue.charAt(0) == '+' || measuredValue.charAt(0) == '-')) {startIndex++;}
		String errorValue = text_Operand2ErrorTerm.getText();

		String errMessage = MeasuredValueRecognizer.checkMeasuredValue(measuredValue.substring(startIndex));
		if (errMessage != "") {
			System.out.println(errMessage);
			label_errOperand2MeasuredValue.setText(MeasuredValueRecognizer.measuredValueErrorMessage);
			if (MeasuredValueRecognizer.measuredValueIndexofError <= -1) return;
			String input = MeasuredValueRecognizer.measuredValueInput;
			errMV2Part1.setText(input.substring(0, MeasuredValueRecognizer.measuredValueIndexofError));
			errMV2Part2.setText("\u21EB");
			op2mv = false;
		} else {op2mv = true;}
		
		text_Operand2ErrorTerm.setEditable(op2mv && op2CheckBox.isSelected()); label_errOperand2ErrorTerm.setText("");

		startIndex = 0;
		
		if (errorValue.length() > 0 && (errorValue.charAt(0) == '+' || errorValue.charAt(0) == '-')) {startIndex++;}

		errMessage = ErrorTermRecognizer.checkErrorTerm(errorValue.substring(startIndex));
		if (errMessage != "" && op2mv) {
			label_errOperand2ErrorTerm.setText(ErrorTermRecognizer.errorTermErrorMessage);
			String input = ErrorTermRecognizer.errorTermInput;
			if (ErrorTermRecognizer.errorTermIndexofError <= -1) return;
			errET2Part1.setText(input.substring(0, ErrorTermRecognizer.errorTermIndexofError));
			errET2Part2.setText("\u21EB");
			businessLogicObj.setOperand2Defined(false);
		} else {op2ev = true; errET2Part1.setText(""); errET2Part2.setText(""); label_errOperand2ErrorTerm.setText("");}
		
		if (op2mv && op2ev) {
			errorValue = !op2CheckBox.isSelected() ? "0"  : errorValue; 
			businessLogicObj.setOperand2(measuredValue, errorValue);
			String errorString = businessLogicObj.getOperand2ErrorMessage();			// make and operand out of it
			if (errorString.length() > 0) {												// If there is an error the
				label_errOperand2.setText(errorString);									// returned error string is used
				businessLogicObj.setOperand2Defined(false);
				return;
			}
		label_errOperand2.setText("");									// returned error string is used
		label_errOperand2MeasuredValue.setText("");										// Reset the error message
		} else {
			businessLogicObj.setOperand2Defined(false);
		}
	}
	
	// Checks whether there are any issues with operands
	private boolean binaryOperandIssues() {
		if (!businessLogicObj.isOperand1Defined()) 	{									// Check operand 1 and set a
			label_errOperand1.setText("Missing a valid value");							// missing value error
		}
		if (!businessLogicObj.isOperand2Defined()) 	{									// Check operand 2 and set a
			label_errOperand2.setText("Missing a valid value");							// missing value error
		}
		if (businessLogicObj.isOperandError())											// See if invalid input errors
			return true;																// return true if so
		if (!businessLogicObj.isOperand1Defined() || !businessLogicObj.isOperand2Defined())					// See if any missing input values
			return true;																// return true is so
		return false;																	// Else okay input, return false
	}
}