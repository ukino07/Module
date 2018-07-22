import org.junit.Test;

/**
 * Created by u_kino07 on 2018. 6. 26..
 */
public class SwitchTest {
    public enum AbTestType {
        A, B, C, D;
    }

    @Test
    public void test() {
        AbTestType abTestType = null; //AbTestType.A;

        switch (abTestType) {
            case A :
                System.out.println("A good");
                break;
            case B :
                System.out.println("B good");
                break;
            case C :
                System.out.println("C good");
                break;
            case D :
                System.out.println("D good");
                break;
            default :
                System.out.println("nothing");
                break;

        }
    }

    @Test
    public void test1() {
        for (AbTestType abTestType : AbTestType.values()) {
            System.out.println(abTestType.ordinal());
        }
    }
}
