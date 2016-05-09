package test;


public class Planet {
	
	public double x;
	public double y;
	public double xVelocity;
	public double yVelocity;
	public double mass;
	public double r;
	public String img;
	
	public double angle;
	public double orbit;
	
	public double xNetForce;
	public double yNetForce;
	public double xAccel;
	public double yAccel;
	
	
	public Planet(double x, double y, double xVelocity, double yVelocity,
			double mass, String images) {
		super();
		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.mass = mass;
		this.img = images;
	}
	
	public Planet(double x, double y, double xVelocity, double yVelocity,
			double mass, double r, double angle, String images) {
		super();
		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.mass = mass;
		this.r = r;
		this.img = images;
	}
	
	
	
	public double calcDistance(Planet p) {
		return Math.sqrt(Math.pow((this.x - p.x),2) + Math.pow((this.y - p.y),2));
	}
	
	public double calcPairwiseForce(Planet p){
		double m1, m2, r2, G;
		m1 = this.mass;
		m2 = p.mass;
		r2 = Math.pow(calcDistance(p),2);
		G = 6.67E-11; 
		return G * m1 * m2 / r2;
	}
	
	public double calcPairwiseForceX(Planet p){
		double dx, r, F;
		dx = p.x - this.x;
		r = calcDistance(p);
		F = calcPairwiseForce(p);
		return F * dx / r;
	}
	
	public double calcPairwiseForceY(Planet p){
		double dy, r, F;
		dy = p.y - this.y;
		r = calcDistance(p);
		F = calcPairwiseForce(p);
		
		/*System.out.println("dy: " + dy);
		System.out.println("r: " + r);
		System.out.println("F: " + F);*/
		
		return F * dy / r;
	}
	
	public void setNetForce(Planet[] planets){
		xNetForce = 0;
		yNetForce = 0;
		for(Planet planet: planets){
			if(planet.x == this.x && planet.y == this.y){
				//do nothing, don't return, because then none of the
				// other planets are considered.... oops
			} else {
				xNetForce += calcPairwiseForceX(planet);
				yNetForce += calcPairwiseForceY(planet);
			}						
		}		
	}
	
	public void setAcceleration(){

		if(mass != 0){
			xAccel = xNetForce / mass;
			yAccel = yNetForce / mass;
		}
	}
	
	public void setVelocity(double dt){
		xVelocity += dt * xAccel;
		yVelocity += dt * yAccel;
	}
	
	public void setPosition(double dt){
		x += dt * xVelocity;
		y += dt * yVelocity;
	}
	
	public void setOrbit (double orbit){
		angle += orbit;
	}
	
	public void update(double dt){
		setAcceleration();
		setVelocity(dt);
		setPosition(dt);
		setOrbit(this.orbit);
	}
	
	public void draw(){
	
		StdDraw3D.sphere(x,y,0,r,0,0,angle,img);
		
	}
	
}