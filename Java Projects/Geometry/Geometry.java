
/**
 * Geometry.java  
 *
 * @author: Bailey Sachs
 * Assignment #:
 * 
 * Brief Program Description:
 * This calculates the volume and surface area of 4 different shapes.
 *
 */
public class Geometry
{
    public static double cubeVolume(double h)
    {
        return Math.pow(h, 3);
    }
    
    public static double cubeSurface(double h)
    {
        return 6 * Math.pow(h, 2);
    }
    
    public static double sphereVolume(double r)
    {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }
    
    public static double sphereSurface(double r)
    {
        return 4 * Math.PI * Math.pow(r, 2);
    }
    
    public static double cylinderVolume(double r, double h)
    {
        return Math.PI * Math.pow(r, 2) * h;
    }
    
    public static double cylinderSurface(double r, double h)
    {
        return (2 * Math.PI * r * h) + 2 * Math.PI * Math.pow(r, 2);
    }
    
    public static double coneVolume(double r, double h)
    {
        return Math.PI * Math.pow(r, 2) * (h / 3.0);
    }
    
    public static double coneSurface(double r, double h)
    {
        double l = Math.sqrt((r * r) + (h * h));
        double area = area = (Math.PI * r * l) + (Math.PI * r * r);
        return area;
    }
}
