/*
 * TCSS 305 – Fall 2017
 * Assignment 1 - Testing
 */

package shapestests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import shapes.Circle;

/**
 * Test cases for the Circle Class.
 * 
 * @author eduardk
 * @version 5 Oct 2017
 */
public class CircleTest {

    /**
     * The tolerance value used for comparing values.
     */
    private static final double TOLERANCE = .000001;

    /**
     * The test circle object.
     */
    private Circle myTesterCircle;

    /**
     * This initializes the object tested before each test.
     */
    @Before
    public void setUp() {
        myTesterCircle = new Circle();
    }

    /**
     * 
     * Tests if radius is initialized to the default value of 1. Tests if point is
     * initialized to the default of (0, 0). Tests if color is initialized to the
     * default of BLACK.
     * 
     * Test method for {@link shapes.Circle#Circle()}.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals(1.0, myTesterCircle.getRadius(), TOLERANCE);
        assertEquals(new Point(0, 0), myTesterCircle.getCenter());
        assertEquals(Color.BLACK, myTesterCircle.getColor());
    }

    /**
     * Creates a non-default Circle. Tests if radius was initialized with 2.0. Tests
     * if Point was initialized with the coordinates at (17, 38). Tests if Color was
     * initialized with the color GREEN.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testOverloadConstructor() {
        final Circle nonDefaultCircle = new Circle(2.0, new Point(17, 38), Color.GREEN);
        assertEquals(2.0, nonDefaultCircle.getRadius(), TOLERANCE);
        assertEquals(new Point(17, 38), nonDefaultCircle.getCenter());
        assertEquals(Color.GREEN, nonDefaultCircle.getColor());
    }

    /**
     * Creates a Circle with a radius of 0. Looks for IllegalArgumentException.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOverloadConstructorRadZero() {
        new Circle(0.0, new Point(0, 0), Color.BLACK);
    }

    /**
     * Creates a Circle with negative radius. Looks for IllegalArgumentException.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOverloadConstructorRadNegative() {
        new Circle(-3.0, new Point(0, 0), Color.BLACK);
    }

    /**
     * Creates a Circle with maximum double value. Tests if radius was initialized
     * with max double value.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testOverloadConstructorRadMaxValue() {
        final Circle maxRadCircle = new Circle(Double.MAX_VALUE, new Point(0, 0), Color.BLACK);
        assertEquals(Double.MAX_VALUE, maxRadCircle.getRadius(), TOLERANCE);
    }

    /**
     * Creates a Circle with null point. Looks for NullPointerException.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test(expected = NullPointerException.class)
    public void testOverloadConstructorPointNull() {
        new Circle(1.0, new Point(null), Color.BLACK);
    }

    /**
     * Creates a Circle with max integer point. Tests if point was initialized with
     * maximum integer value.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testOverloadConstructorPointMaxValue() {
        final Circle maxPointCircle =
                        new Circle(1.0, new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                                   Color.BLACK);
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                     maxPointCircle.getCenter());
    }

    /**
     * Creates a Circle with minimum integer point. Tests if point was initialized
     * with minimum integer value.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testOverloadConstructorPointMinValue() {
        final Circle minPointCircle =
                        new Circle(1.0, new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                                   Color.BLACK);
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                     minPointCircle.getCenter());
    }

    /**
     * Creates a Circle with null color. Looks for NullPointerException.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test(expected = NullPointerException.class)
    public void testOverloadConstructorColorNull() {
        new Circle(1.0, new Point(0, 0), null);
    }

    /**
     * Creates a Circle with RGB color. Tests if color was initialized using RGB.
     * 
     * Test method for
     * {@link shapes.Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testOverloadConstructorColorRBG() {
        final Circle rgbCircle =
                        new Circle(1.0, new Point(0, 0), Color.getHSBColor(50, 100, 200));
        assertEquals(Color.getHSBColor(50, 100, 200), rgbCircle.getColor());
    }

    /**
     * Sets radius to 2.0. Tests if radius was set to 2.0.
     * 
     * Test method for {@link shapes.Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius() {
        myTesterCircle.setRadius(2.0);
        assertEquals(2.0, myTesterCircle.getRadius(), TOLERANCE);
    }

    /**
     * Sets radius to 0.0. Looks for IllegalArgumentException.
     * 
     * Test method for {@link shapes.Circle#setRadius(double)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusZero() {
        myTesterCircle.setRadius(0.0);
    }

    /**
     * Sets radius to -2.0. Looks for IllegalArgumentException.
     * 
     * Test method for {@link shapes.Circle#setRadius(double)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusNegative() {
        myTesterCircle.setRadius(-2.0);
    }

    /**
     * Sets radius to maximum double value. Tests if radius was set to max double.
     * 
     * Test method for {@link shapes.Circle#setRadius(double)}.
     */
    @Test
    public void testSetMaxValue() {
        myTesterCircle.setRadius(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, myTesterCircle.getRadius(), TOLERANCE);
    }

    /**
     * Sets center to maximum integer values. Tests if center was set to max integer
     * value.
     * 
     * Test method for {@link shapes.Circle#setCenter(java.awt.Point)}.
     */
    @Test
    public void testSetCenterMaxValue() {
        myTesterCircle.setCenter(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                     myTesterCircle.getCenter());
    }

    /**
     * Sets center to minimum integer values. Tests if center was set to minimum
     * integer value.
     * 
     * Test method for {@link shapes.Circle#setCenter(java.awt.Point)}.
     */
    @Test
    public void testSetCenterMinValue() {
        myTesterCircle.setCenter(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                     myTesterCircle.getCenter());
    }

    /**
     * Sets radius center to null. Looks for NullPointerException.
     * 
     * Test method for {@link shapes.Circle#setCenter(java.awt.Point)}.
     */
    @Test(expected = NullPointerException.class)
    public void testSetCenterNull() {
        myTesterCircle.setCenter(new Point(null));
    }

    /**
     * Sets color to green. Tests if color was set to green.
     * 
     * Test method for {@link shapes.Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor() {
        myTesterCircle.setColor(Color.GREEN);
        assertEquals(Color.GREEN, myTesterCircle.getColor());
    }

    /**
     * Sets color to RGB (100, 150, 250). Tests if color was set to RGB (100, 150,
     * 250).
     * 
     * Test method for {@link shapes.Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColorRGB() {
        myTesterCircle.setColor(Color.getHSBColor(100, 150, 250));
        assertEquals(Color.getHSBColor(100, 150, 250), myTesterCircle.getColor());
    }

    /**
     * Sets color to null. Looks for NullPointerException.
     * 
     * Test method for {@link shapes.Circle#setColor(java.awt.Color)}.
     */
    @Test(expected = NullPointerException.class)
    public void testSetColorNull() {
        myTesterCircle.setColor(null);
    }

    /**
     * Tests if return value is the default value.
     * 
     * Test method for {@link shapes.Circle#getRadius()}.
     */
    @Test
    public void testGetRadius() {
        assertEquals(1.0, myTesterCircle.getRadius(), TOLERANCE);
    }

    /**
     * Tests if return value is the default value.
     * 
     * Test method for {@link shapes.Circle#getCenter()}.
     */
    @Test
    public void testGetCenter() {
        assertEquals(new Point(0, 0), myTesterCircle.getCenter());
    }

    /**
     * Tests if return value is the default value.
     * 
     * Test method for {@link shapes.Circle#getColor()}.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.BLACK, myTesterCircle.getColor());
    }

    /**
     * Tests if return value follows the 2r formula.
     * 
     * Test method for {@link shapes.Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter() {
        assertEquals(2 * myTesterCircle.getRadius(), myTesterCircle.calculateDiameter(),
                     TOLERANCE);
    }

    /**
     * Tests if return value follows the 2(Pi)r formula.
     * 
     * Test method for {@link shapes.Circle#calculateCircumference()}.
     */
    @Test
    public void testCalculateCircumference() {
        assertEquals(2 * Math.PI * myTesterCircle.getRadius(),
                     myTesterCircle.calculateCircumference(), TOLERANCE);
    }

    /**
     * Tests if return value follows the (Pi)r^2 formula.
     * 
     * Test method for {@link shapes.Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {
        assertEquals(Math.PI * Math.pow(myTesterCircle.getRadius(), 2),
                     myTesterCircle.calculateArea(), TOLERANCE);
    }

    /**
     * Tests if ToString is correctly formatted.
     * 
     * Test method for {@link shapes.Circle#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Circle [radius=" + String.format("%.2f", myTesterCircle.getRadius())
                     + ", center=" + myTesterCircle.getCenter() + ", color="
                     + myTesterCircle.getColor() + "]", myTesterCircle.toString());
    }
}
