import java.util.Scanner;
/**
 * GeometryTester.java 
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */

public class GeometryTester 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a radius.");
        double r = sc.nextDouble();
        System.out.println("Please enter a height.");
        double h = sc.nextDouble();
        System.out.println("The volume of the cube is: " + Geometry.cubeVolume(h));
        System.out.println("The surface area of the cube is: " + Geometry.cubeSurface(h));
        System.out.println("The volume of the sphere is: " + Geometry.sphereVolume(r));
        System.out.println("The surface area of the sphere is: " + Geometry.sphereSurface(r));
        System.out.println("The volume of the cylinder is: " + Geometry.cylinderVolume(r,h)); 
        System.out.println("The surface area of the cylinder is: " + Geometry.cylinderSurface(r, h));
        System.out.println("The volume of the cone is: " + Geometry.coneVolume(r, h));
        System.out.println("The surface area of the cone is: " + Geometry.coneSurface(r, h));
    }
}
// Please enter a radius.
// 4
// Please enter a height.
// 5
// The volume of the cube is: 125.0
// The surface area of the cube is: 150.0
// The volume of the sphere is: 268.082573106329
// The surface area of the sphere is: 201.06192982974676
// The volume of the cylinder is: 251.32741228718345
// The surface area of the cylinder is: 226.1946710584651
// The volume of the cone is: 83.77580409572782
// The surface area of the cone is: 130.72951471480383
