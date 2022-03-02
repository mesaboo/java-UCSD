import edu.duke.*;

public class PerimeterRunner {
    
    
    
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints (Shape s){
        //Int to iterate to calculate number of points
        int totalPoints = 0;
        //Interate
        for (Point i: s.getPoints()){
            totalPoints += 1;
        }    
        //return total
        return totalPoints;
    
    }
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("points = " + points);
        System.out.println("average length = " + averageLength);
        System.out.println("largest side = " + largestSide);
        System.out.println("largest X = " + largestX);
        
    }
    
    public double getAverageLength (Shape s) {
        // Total perimeter is all the lengths
        double totalPerimeter = getPerimeter(s);
        // Sides is equivalent to the number of points - 1
        int sides = getNumPoints(s);
        // Average length is length/sides
        double averageLength = totalPerimeter/sides;
        return averageLength;
    }  
    public double getLargestSide (Shape s) {
        // Get largest side by comparing
        double largestSide = 0.0;
        // Start with last point
        Point prevPoint = s.getLastPoint();
        for (Point currPt: s.getPoints()){
            // Find distance from prevPt point to currPt 
            double currDist = prevPoint.distance(currPt);
            if (currDist > largestSide){
                largestSide = currDist;
            }
            // Current point equals the "last" point to compare
            prevPoint = currPt;
        }
        // Returns largest side
        return largestSide;
    }
    
    public double getLargestX (Shape s) {
        // Get largest X value
        double largestX = 0.0;
        for (Point i: s.getPoints()){
            if (i.getX() > largestX){
                largestX = i.getX();
            }
        }
        // Return X value
        return largestX;
    }
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
    
    
}
