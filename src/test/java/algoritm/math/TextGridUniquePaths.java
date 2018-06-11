package algoritm.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 4. 22..
 */
public class TextGridUniquePaths {
    @Test
    public void 테스트() {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int result = gridUniquePaths.uniquePaths(2, 2);
        assertEquals(2, result);
    }


}
