//Kaitlin Giles, Lab 8 B, 04/24/2021
//Draw Rectangles from Coordinates, determine if intersecting

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.*;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class Giles_Lab8B extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //initiate borderpane; initiate and place pane and anchorpane
        BorderPane borderPane = new BorderPane(); // main layout control
        Pane pane = new Pane(); // to be placed in center of borderpane
        borderPane.setMinHeight(800);
        borderPane.setCenter(pane);
        pane.setStyle("-fx-background-color: #777777");
        AnchorPane anchorPane = new AnchorPane(); // to be placed in top of borderpane
        borderPane.setTop(anchorPane);
        anchorPane.setStyle("-fx-background-color: #006666");
        anchorPane.setPrefSize(700,150);

        //create and position text fields for user to enter coordinates
        TextField x1 = new TextField(); //X coordinate of rectangle 1
        x1.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(x1, 10.0);
        TextField y1 = new TextField(); //Y coordinate of rectangle 1
        y1.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(y1, 10.0);
        AnchorPane.setTopAnchor(y1, 30.0);
        TextField x2 = new TextField(); //X coordinate of rectangle 2
        x2.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(x2, 10.0);
        AnchorPane.setTopAnchor(x2, 60.0);
        TextField y2 = new TextField(); //Y coordinate of rectangle 2
        y2.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(y2, 10.0);
        AnchorPane.setTopAnchor(y2, 90.0);
        anchorPane.getChildren().addAll(x1, y1, x2, y2); // add all text fields to pane

        //label all coordinate text fields
        Text textX1 = new Text();
        textX1.setText("X coordinate for rectangle 1");
        AnchorPane.setLeftAnchor(textX1, 70.0);
        AnchorPane.setTopAnchor(textX1, 5.0);
        Text textY1 = new Text();
        textY1.setText("Y coordinate for rectangle 1");
        AnchorPane.setLeftAnchor(textY1, 70.0);
        AnchorPane.setTopAnchor(textY1, 35.0);
        Text textX2 = new Text();
        textX2.setText("X coordinate for rectangle 2");
        AnchorPane.setLeftAnchor(textX2, 70.0);
        AnchorPane.setTopAnchor(textX2, 65.0);
        Text textY2 = new Text();
        textY2.setText("Y coordinate for rectangle 2");
        AnchorPane.setLeftAnchor(textY2, 70.0);
        AnchorPane.setTopAnchor(textY2, 95.0);
        anchorPane.getChildren().addAll(textX1, textY1, textX2, textY2); // add all text labels to pane

        //create and position text fields for user to enter height/width
        TextField h1 = new TextField(); //height for rectangle 1
        h1.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(h1, 300.0);
        TextField w1 = new TextField(); //width for rectangle 1
        w1.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(w1, 300.0);
        AnchorPane.setTopAnchor(w1, 30.0);
        TextField h2 = new TextField();//height for rectangle 2
        h2.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(h2, 300.0);
        AnchorPane.setTopAnchor(h2, 60.0);
        TextField w2 = new TextField();//width for rectangle 2
        w2.setPrefWidth(50.0);
        AnchorPane.setLeftAnchor(w2, 300.0);
        AnchorPane.setTopAnchor(w2, 90.0);
        anchorPane.getChildren().addAll(h1, w1, h2, w2);// add all textfields to pane

        //label all height/width text fields
        Text textH1 = new Text();
        textH1.setText("Height of rectangle 1");
        AnchorPane.setLeftAnchor(textH1, 360.0);
        AnchorPane.setTopAnchor(textH1, 5.0);
        Text textW1 = new Text();
        textW1.setText("Width of rectangle 1");
        AnchorPane.setLeftAnchor(textW1, 360.0);
        AnchorPane.setTopAnchor(textW1, 35.0);
        Text textH2 = new Text();
        textH2.setText("Height of rectangle 2");
        AnchorPane.setLeftAnchor(textH2, 360.0);
        AnchorPane.setTopAnchor(textH2, 65.0);
        Text textW2 = new Text();
        textW2.setText("Width of rectangle 2");
        AnchorPane.setLeftAnchor(textW2, 360.0);
        AnchorPane.setTopAnchor(textW2, 95.0);
        anchorPane.getChildren().addAll(textW1, textH1, textW2, textH2); // add all text labels to pane

        //create and position draw button and intersect text
        Button drawButton = new Button("Draw"); // draw button
        AnchorPane.setLeftAnchor(drawButton,565.0);
        AnchorPane.setTopAnchor(drawButton, 25.0);
        Text alertText = new Text(); // will change value to report if rectangles intersect or not
        alertText.setText("Enter all values and press \"Draw\"");
        alertText.setFill(Color.WHITESMOKE);
        AnchorPane.setLeftAnchor(alertText, 520.0);
        AnchorPane.setTopAnchor(alertText, 80.0);
        anchorPane.getChildren().addAll(drawButton, alertText);// add to pane

        drawButton.setOnAction(event -> {
            pane.getChildren().clear(); //clears main HBox before drawing

            try {
                //draw rectangle 1 from user input
                int intx1 = Integer.parseInt(x1.getText());
                int inty1 = Integer.parseInt(y1.getText());
                int intw1 = Integer.parseInt(w1.getText());
                int inth1 = Integer.parseInt(h1.getText());
                Rectangle rectangle1 = new Rectangle(intx1, inty1, intw1, inth1);
                rectangle1.setStrokeType(StrokeType.INSIDE);
                rectangle1.setStroke(Color.WHITE);
                rectangle1.setFill(Color.TRANSPARENT);

                //draw rectangle 2 from user input
                int intx2 = Integer.parseInt(x2.getText());
                int inty2 = Integer.parseInt(y2.getText());
                int intw2 = Integer.parseInt(w2.getText());
                int inth2 = Integer.parseInt(h2.getText());
                Rectangle rectangle2 = new Rectangle(intx2, inty2, intw2, inth2);
                rectangle2.setStrokeType(StrokeType.INSIDE);
                rectangle2.setStroke(Color.WHITE);
                rectangle2.setFill(Color.TRANSPARENT);

                //assign points to top left and bottom right corners of each rectangle to be used for mathematical equation
                Point l1 = new Point(), r1 = new Point(), l2 = new Point(), r2 = new Point();
                l1.x = Integer.parseInt(x1.getText()); //top left X coordinate of rectangle 1
                l1.y = Integer.parseInt(y1.getText()); //top left Y coordinate of rectangle 1
                r1.x = l1.x + Integer.parseInt(w1.getText()); //bottom right X coordinate of rectangle 1
                r1.y = l1.y + Integer.parseInt(h1.getText()); //bottom right Y coordinate of rectangle 1
                l2.x = Integer.parseInt(x2.getText()); //top left X coordinate of rectangle 2
                l2.y = Integer.parseInt(y2.getText()); //top left Y coordinate of rectangle 2
                r2.x = l2.x + Integer.parseInt((w2.getText())); //bottom right X coordinate of rectangle 2
                r2.y = l2.y + Integer.parseInt(h2.getText()); //bottom right Y coordinate of rectangle 2

                //math to determine if rectangles intersect
                if ((l1.x > r2.x) || (r1.x < l2.x) || (l1.y > r2.y) || (r1.y < l2.y)) { //math says rectangles do not intersect
                    alertText.setText("The rectangles do not intersect");
                } else {
                    alertText.setText("The rectangles intersect");
                }

                //place both rectangles in main HBox
                pane.getChildren().addAll(rectangle1, rectangle2);

            } catch (Exception e) { //catch will run if any user input is blank or contains anything but numbers
                alertText.setText("Fill all blanks with numbers");
            }
        });

        //place borderPane in scene, scene in stage, show stage
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Rectangle Creator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //launch method
    public static void main(String[] args) {
        launch(args);
    }
}
