package test;

// for the 3D drawing test

public class my3D {
	public static void main(String[] args){
		StdDraw3D.setCanvasSize(1024, 860);
		StdDraw3D.setScale(-9.50e+11,9.50e+11);
		
		StdDraw3D.setBackgroundSphere("universe.jpg");
		double radius = 0.2;
		double R = 6.963e+10;
		double angle = 0;
		int time = 20;
		
		while (true){
			double x = R * Math.cos(angle);
			double y = R * Math.sin(angle);
			double z = 0;
			angle += 0.9;
			
			StdDraw3D.clear();
			

			StdDraw3D.sphere(0,0,0,2.963e+10,0,0,angle,"sun.jpg");
			//StdDraw3D.sphere(x,y,0,0.9e+10,0,0,angle,"earth.jpg");
			
			StdDraw3D.show(time);
			System.out.println(StdDraw3D.mouseX()+","+StdDraw3D.mouseY());
		}
		
		
	}
}
