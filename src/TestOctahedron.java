
import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import java.applet.*;
import com.sun.j3d.utils.applet.MainFrame;

	public class TestOctahedron extends Applet {
	  public static void main(String[] args) {
	    new MainFrame(new TestOctahedron(), 640, 480);
	  }

	  public void init() {
	    // create canvas
	    GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
	    Canvas3D cv = new Canvas3D(gc);
	    setLayout(new BorderLayout());
	    add(cv, BorderLayout.CENTER);
	    BranchGroup bg = createSceneGraph();
	    bg.compile();
	    SimpleUniverse su = new SimpleUniverse(cv);
	    su.getViewingPlatform().setNominalViewingTransform();
	    su.addBranchGraph(bg);
	  }

	  private BranchGroup createSceneGraph() {
	    BranchGroup root = new BranchGroup();
	    TransformGroup spin = new TransformGroup();
	    spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	    root.addChild(spin);
	    //object
	    Appearance ap = new Appearance();
	    ap.setMaterial(new Material());
	    Shape3D shape = new Shape3D(new Octahedron(), ap);
	    //rotating object
	    Transform3D tr = new Transform3D();
	    tr.setScale(0.25);
	    TransformGroup tg = new TransformGroup(tr);
	    spin.addChild(tg);
	    tg.addChild(shape);
	    Alpha alpha = new Alpha(-1, 4000);
	    RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
	    BoundingSphere bounds = new BoundingSphere();
	    rotator.setSchedulingBounds(bounds);
	    spin.addChild(rotator);
	    //light and background
	    Background background = new Background(1.0f, 1.0f, 1.0f);
	    background.setApplicationBounds(bounds);
	    root.addChild(background);
	    AmbientLight light = new AmbientLight(true, new Color3f(Color.red));
	    light.setInfluencingBounds(bounds);
	    root.addChild(light);
	    
	    // Four point lights, one from each corner so that I could
	    // verify that all of the surface normals were correctly working
	    PointLight ptlight = new PointLight(new Color3f(Color.green),
	        new Point3f(0f,0f,-2f), new Point3f(1f,0f,0f));
	    	ptlight.setInfluencingBounds(bounds);
	    	root.addChild(ptlight);
	    PointLight ptlight2 = new PointLight(new Color3f(Color.green),
	        new Point3f(0f,0f,2f), new Point3f(1f,0f,0f));
	    	ptlight2.setInfluencingBounds(bounds);
	    	root.addChild(ptlight2);
	    PointLight ptlight3 = new PointLight(new Color3f(Color.green),
		        new Point3f(2f,2f,-2f), new Point3f(1f,0f,0f));
		    ptlight3.setInfluencingBounds(bounds);
		    root.addChild(ptlight3);
		PointLight ptlight4 = new PointLight(new Color3f(Color.green),
			    new Point3f(-2f,-2f,-2f), new Point3f(1f,0f,0f));
			ptlight4.setInfluencingBounds(bounds);
			root.addChild(ptlight4);    
	    return root;
	  }
}
