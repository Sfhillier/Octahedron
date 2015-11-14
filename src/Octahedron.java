import javax.vecmath.*;
import javax.media.j3d.*;

public class Octahedron extends IndexedTriangleArray {

	public Octahedron() {

		super(8, TriangleArray.COORDINATES | TriangleArray.NORMALS, 24);
		// Top point
		Point3f p0 = new Point3f(0f,0f,1f);
		setCoordinate(0, p0);
		// Bottom point
		Point3f p1 = new Point3f(0f,0f,-1f);
		setCoordinate(1, p1);
		// Corner 1
		Point3f p2 = new Point3f(-1f,0f,0f);
		setCoordinate(2, p2);
		// Corner 2
		Point3f p3 = new Point3f(1f,0f,0f);
		setCoordinate(3, p3);
		// Corner 3
		Point3f p4 = new Point3f(0f,1f,0f);
		setCoordinate(4, p4);
		// Corner 4
		Point3f p5 = new Point3f(0f,-1f,0f);
		setCoordinate(5, p5);
		
		Point3f p0Copy = p0;
		Point3f p1Copy = p1;
		Point3f p2Copy = p2;
		Point3f p3Copy = p3;
		Point3f p4Copy = p4;
		Point3f p5Copy = p5;
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p5Copy.sub(p0Copy);
		p3Copy.sub(p0Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v1 = new Vector3f(p3Copy);
		Vector3f v2 = new Vector3f(p5Copy);
		Vector3f normal0 = new Vector3f();
		normal0.cross(v1, v2);
		normal0.normalize();
		
		// Resets the copies values so that I can reuse them
		p3Copy = p3;
		p5Copy = p5;
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p2Copy.sub(p0Copy);
		p5Copy.sub(p0Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v3 = new Vector3f(p2Copy);
		Vector3f v4 = new Vector3f(p5Copy);
		Vector3f normal1 = new Vector3f();
		normal1.cross(v3, v4);
		normal1.normalize();
		
		// Resets the copies values so that I can reuse them
		p2Copy = p2;
		p5Copy = p5;
		
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p4Copy.sub(p0Copy);
		p2Copy.sub(p0Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v5 = new Vector3f(p4Copy);
		Vector3f v6 = new Vector3f(p2Copy);
		Vector3f normal2 = new Vector3f();
		normal2.cross(v5, v6);
		normal2.normalize();
		
		// Resets the copies values so that I can reuse them
		p2Copy = p2;
		p4Copy = p4;
		
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p3Copy.sub(p0Copy);
		p4Copy.sub(p0Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v7 = new Vector3f(p4Copy);
		Vector3f v8 = new Vector3f(p3Copy);
		Vector3f normal3 = new Vector3f();
		normal3.cross(v7, v8);
		normal3.normalize();
		
		// Resets the copies values so that I can reuse them
		p4Copy = p4;
		p3Copy = p3;
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p5Copy.sub(p1Copy);
		p3Copy.sub(p1Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v9 = new Vector3f(p3Copy);
		Vector3f v10 = new Vector3f(p5Copy);
		Vector3f normal4 = new Vector3f();
		normal4.cross(v9, v10);
		normal4.normalize();
		
		// Resets the copies values so that I can reuse them
		p3Copy = p3;
		p5Copy = p5;
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p5Copy.sub(p1Copy);
		p2Copy.sub(p1Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v11 = new Vector3f(p2Copy);
		Vector3f v12 = new Vector3f(p5Copy);
		Vector3f normal5 = new Vector3f();
		normal5.cross(v11, v12);
		normal5.normalize();
		
		// Resets the copies values so that I can reuse them
		p5Copy = p5;
		p2Copy = p2;
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p2Copy.sub(p1Copy);
		p4Copy.sub(p1Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v13 = new Vector3f(p4Copy);
		Vector3f v14 = new Vector3f(p2Copy);
		Vector3f normal6 = new Vector3f();
		normal6.cross(v13, v14);
		normal6.normalize();
		
		// Resets the copies values so that I can reuse them
		p2Copy = p2;
		p4Copy = p4;
		
		// Sets new point3f objects equal to the points
		// I'm using to normalize because they will change
		p4Copy.sub(p1Copy);
		p3Copy.sub(p1Copy);
		
		// Creates new vector3f from the subtracted points
		// and crosses them to get the surface normals
		Vector3f v15 = new Vector3f(p4Copy);
		Vector3f v16 = new Vector3f(p3Copy);
		Vector3f normal7 = new Vector3f();
		normal7.cross(v15, v16);
		normal7.normalize();
		
		// Resets the copies values so that I can reuse them
		p4Copy = p4;
		p3Copy = p3;
		
		int[] coords = {3,0,5,0,2,5,2,0,4,0,3,4,5,1,3,2,1,5,4,1,2,3,1,4};
		
		// Surface normals for the octahedron
		setNormal(0, normal0);
		setNormal(1, normal1);
		setNormal(2, normal2);
		setNormal(3, normal3);
		setNormal(4, normal4);
		setNormal(5, normal5);
		setNormal(6, normal6);
		setNormal(7, normal7);
		
		int[] norms = {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7};
		
		setCoordinateIndices(0, coords);
		setNormalIndices(0, norms);
	}
}