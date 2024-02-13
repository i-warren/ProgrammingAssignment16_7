import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Change clock creates takes user input from text fields to set a clock pane
 * @author Isaac Warren
 */

public class ChangeClock extends Application {
    private static final TextField hourInput = new TextField();
    private static final TextField minuteInput = new TextField();
    private static final TextField secondInput = new TextField();


    public static void main(String[] args) {
        launch(args);
    }


    @Override   // Override the start method in the Application class
    public void start(Stage primaryStage) {
        ClockPane clockPane = new ClockPane();

        // create labels and set text field width
        Label hourLabel = new Label("Hour");
        hourInput.setPrefColumnCount(2);
        Label minuteLabel = new Label("Minutes");
        minuteInput.setPrefColumnCount(2);
        Label secondLabel = new Label("Seconds");
        secondInput.setPrefColumnCount(2);

        // create settings Hbox
        HBox settings = new HBox(10, hourLabel, hourInput,
                minuteLabel, minuteInput, secondLabel, secondInput);
        settings.setAlignment(Pos.CENTER);

        // calls setTime on clockPane from inputs
        hourInput.setOnAction(e -> setTime(clockPane));
        minuteInput.setOnAction(e -> setTime(clockPane));
        secondInput.setOnAction(e -> setTime(clockPane));

        BorderPane pane = new BorderPane(); // create a Borderpane
        pane.setCenter(clockPane);          // set clockPane to center
        pane.setBottom(settings);           // set settings to bottom

        // create a scene and set it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Change Clock");  // set Title
        primaryStage.setScene(scene);           // Place scene in stage
        primaryStage.show();                    // Display stage
    }

    private void setTime(ClockPane pane) {
        int hours, minutes, second;

        try {       // set variables from input
            hours = Integer.parseInt(hourInput.getText());
            minutes = Integer.parseInt(minuteInput.getText());
            second = Integer.parseInt(secondInput.getText());
        }
        catch (Exception e) {   // catches if all fields not filled
            System.out.println("Make sure to fill all fields");
            return;
        }
        // sets time in pane
        pane.setHour(hours); pane.setMinute(minutes); pane.setSecond(second);
    }
}


