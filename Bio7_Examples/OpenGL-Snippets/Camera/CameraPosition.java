import java.awt.Graphics2D;
import java.awt.*;
import java.awt.Font;
import java.text.*;
import java.awt.geom.*;
import com.sun.opengl.util.j2d.*;
/*
This example demonstrates the use of the API to get the position of the
camera if the walkthrough option is enabled. An overlay panel shows
the coordinates of the current postion!
*/


/*A Bio7 method to create an Overlay instance!*/
public Overlay infoOverlay = SpatialUtil.createOverlay();

public Font font = new Font("Verdana", Font.BOLD, 12);
public int height=100;
public int width=200;

public void ecomain(GL gl,GLU glu,GLUT glut){
	
showOverlayInfo(gl);

}

public void showOverlayInfo(GL gl) {
	

	Graphics2D g2d = infoOverlay.createGraphics();
	
	AlphaComposite ac1= AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                                           0.5f);
    g2d.setComposite(ac1);
	g2d.setColor(new Color(0, 0, 0));
	g2d.fillRect(0, 0, width, height);	
	g2d.setColor(Color.WHITE);
	g2d.setFont(font);
	g2d.drawString("X: "+SpatialCamera.getXCamPos(),5, 15);
	g2d.drawString("Y: "+SpatialCamera.getYCamPos(),5, 30);
	g2d.drawString("Z: "+SpatialCamera.getZCamPos(),5, 45);
		
	/*Mark only needed region dirty for efficiency!!!!!!*/
	infoOverlay.markDirty(0, 0, 200, 300);
	infoOverlay.drawAll();
	g2d.dispose();
} 