package math;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by 123 on 05.02.2017.
 */
public class VectorsTest {
    Vectors vectors = new Vectors();
    @Test
    public void testVector3D() {
        double result = vectors.dotProduct(new Vector3D(1,2,3), new Vector3D(4,5,6));
        assertTrue(32.0 == result);
    }

    @Test
    public void testVectorN() {
        double result = vectors.dotProduct(new VectorN(new double[]{1.0,2.0,3.0}), new VectorN(new double[]{4,5,6}));
        assertTrue(32.0 == result);
    }
}


