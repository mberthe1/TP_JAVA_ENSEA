import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Interface extends Application
{
    double gety;
    double getx;
    double zoom;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Hello world");
        Earth earth = new Earth();
        Scene ihm = new Scene(earth, 600, 400, true);
        primaryStage.setScene(ihm);
        primaryStage.show();
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1500);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(40);
        ihm.setCamera(camera);

        ihm.addEventHandler(MouseEvent.ANY, event ->
        {

            if (event.getEventType() == MouseEvent.MOUSE_PRESSED)
            {
                gety = event.getSceneY();
                getx = event.getSceneX();
                System.out.println("Clicked on : (" + event.getSceneX() + ", " + event.getSceneY() + ")");
            }

            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
                zoom = gety - event.getSceneY();
                camera.setTranslateZ(-1500 + zoom);
            }

            if (event.getButton()== MouseButton.SECONDARY && event.getEventType()==MouseEvent.MOUSE_CLICKED)
            {
                PickResult pickResult = event.getPickResult();

                double lon = 0.0;
                double lat = 0.0;
                Aeroport near;
                if (pickResult.getIntersectedNode() != null)
                {
                    getx = pickResult.getIntersectedTexCoord().getX();
                    gety = pickResult.getIntersectedTexCoord().getY();
                    lon = 360 * (getx - 0.5);
                    lat = 2*Math.toDegrees(Math.atan(Math.exp((0.5 - gety) / 0.2678))) -90;
                    System.out.println("longitude =" + lon + " latitude =" + lat);
                    World w = new World("./data/airport-codes_no_comma.csv");
                    near = w.findNearestAirport(lon, lat);
                    System.out.println(near);

                }
            }

        });

    }
    public static void main(String[] args)
    {
        launch(args);

    }
}