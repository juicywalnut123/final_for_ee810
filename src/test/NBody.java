package test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NBody {
	
    public static void main(String[] args) {
    	
    	final double T = 157788000.0;
    	final double dt = 25000.0;
    	double angle = 0;
    	
    	int numPlanets = 6;
    	double universeRadius = 8.000e11;
        Planet[] planets = new Planet[numPlanets];

        
  
        Planet p1_sun     = new Planet (0       , 0, 0, 0       , 1.989e30, 2.935e10, 0, "sun.jpg");
        Planet p2_mercury = new Planet (5.790e10, 0, 0, 4.790e04, 3.302e23, 0.440e10, 0, "mercury.jpg");
        Planet p3_venus   = new Planet (1.082e11, 0, 0, 3.500e04, 4.869e24, 1.210e10, 0, "venus.jpg");
        Planet p4_earth   = new Planet (1.496e11, 0, 0, 2.980e04, 5.974e24, 1.140e10, 0, "earth.jpg");
        Planet p5_mars    = new Planet (2.279e11, 0, 0, 2.410e04, 6.419e23, 0.612e10, 0, "mars.jpg");
        Planet p6_jupiter = new Planet (7.779e11, 0, 0, 1.307e04, 1.899e27, 2.087e10, 0, "jupiter.jpg");
        
        /*
        Planet p7_saturn  = new Planet (1.427e12, 0, 0, 9.639e03, 5.6846e26, 0.900e10, "saturn.jpg");
        Planet p8_neptune = new Planet (4.495e12, 0, 0, 5.432e03, 1.0243e26, 0.900e10, "neptune.jpg");
        Planet p9_uranus  = new Planet (2.870e12, 0, 0, 6.795e03, 8.683e25, 0.900e10, "uranus.jpg");
        Planet p10_pluto  = new Planet (5.906e12, 0, 0, 0.470e04, 1.3055e22, 0.900e10, "pluto.jpg");
 		*/
        
        
        planets[0] = p1_sun;
        planets[1] = p2_mercury;
        planets[2] = p3_venus;
        planets[3] = p4_earth;
        planets[4] = p5_mars;
        planets[5] = p6_jupiter;
        
        
        /*
        planets[6] = p7_saturn;
        planets[7] = p8_neptune;
        planets[8] = p9_uranus;
        planets[9] = p10_pluto;
		*/
        

        //create canvas, set scale
        StdDraw3D.setCanvasSize(1024,860);
        StdDraw3D.setScale(-universeRadius, universeRadius);
        StdDraw3D.setBackgroundSphere("universe.jpg");

        
        for(int i = 0; i < T; i += dt){
            //StdDraw.picture(0, 0, "images/universe.jpg");
        	
        	
        	for(Planet p : planets){
            	p.setNetForce(planets);
            	p.update(dt);  
            	
            	// after every update, redraw a new sphere. 
            	// This is the problem @kylewh
            	//System.out.println(p.img.charAt(7) + " | " + p.xAccel + " | " + p.yAccel);
            }
        	
        	dfs
        	p1_sun.angle += 4.07;
        	p2_mercury.angle += 1.698;
        	p3_venus.angle += 0.4098;
        	p4_earth.angle += 100;
        	p5_mars.angle  += 98.03;
        	p6_jupiter.angle += 241.54;
        	
        	
        	/*p2_mercury.angle += p2_mercury.orbit;
        	p3_venus.angle += p3_venus.orbit;
        	p4_earth.angle += p4_earth.orbit;
        	p5_mars.angle += p5_mars.orbit;
        	p6_jupiter.angle += p6_jupiter.orbit;
        	*/
        	
        	StdDraw3D.clear();
        	
        	for(Planet p : planets){
        		p.draw(); 
            }
        	
        	StdDraw3D.show();
        	StdDraw3D.clear();
        	System.out.println(StdDraw3D.mouseX()+","+StdDraw3D.mouseY()+","+ p2_mercury.angle);
        	//StdDraw.show(10);
        }


        
  
    }
	

}
