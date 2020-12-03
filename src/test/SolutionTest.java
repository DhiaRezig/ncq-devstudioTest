package test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import app.*;

public class SolutionTest {
    @Test
    public void test1() {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] res= {3, 2, 2, 4, 2};
        Assert.assertArrayEquals(res, new Solution().solution1(5,A));

    }

    @Test
    public void testCountWays() {
        assertEquals(5, new Solution().countWays(4));
    }

    @Test
    public void test2() {
        int[] A = {4 ,4 ,5 ,5 ,1};
        int[] B = {3 ,2 ,4 ,3 ,1};
        int[] res= {5 ,1 ,0 ,2 ,1} ;
        Assert.assertArrayEquals(res, new Solution().solution2(A,B));
    }

    @Test
    public void test3() {
        int[] A = {1 ,5 ,2 ,-2};
        int res= 0;
        Assert.assertEquals(res, new Solution().solution3(A));
    }
}
