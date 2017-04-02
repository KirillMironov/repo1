package math;

/**
 * Created by 123 on 05.02.2017.
 */
public class Vectors {
    public double dotProduct(Vector3D v1,Vector3D v2){
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public double dotProduct(VectorN v1, VectorN v2){
        double sum = 0;
        for (int i = 0; i < v1.a.length; i++){
            sum = sum + v1.a[i] * v2.a[i];
        }
        return sum;
    }
}
