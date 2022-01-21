import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Earth extends Group {

    private Rotate ry = new Rotate(0, new Point3D(0,1,0));
    private Sphere sph = new Sphere();
    ArrayList<Sphere> yellowSphere = new ArrayList<>();
    PhongMaterial material = new PhongMaterial();


    public Earth() {
        super();
        Image im = new Image("/earth_lights_4800.png");
        sph.setRadius(300);
        sph.getTransforms().add(ry);
        material.setDiffuseMap(im);
        sph.setMaterial(material);
        this.getChildren().add(sph);
        animationTimer.start();


    }
    AnimationTimer animationTimer = new AnimationTimer() {
        double angle = 0;
        @Override
        public void handle(long time) {
            ry.setAngle(time/50000000);
        }
    };
}