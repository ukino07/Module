package algoritm.String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 6. 3..
 */
public class AtoiTest {

//    @Test
//    public void intTest() {
//        Atoi atoi = new Atoi();
//        assertEquals(Integer.MAX_VALUE, atoi.intTest(Integer.MAX_VALUE));
//    }

//    @Test
//    public void convertCharactersToInt() {
//        String s = "-12";
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            System.out.println(c);
//        }
////        List<Character> target = new ArrayList<Character>(s.toCharArray());//
////        target.add('1');
////        target.add('2');
//
//        Atoi atoi = new Atoi();
////        assertEquals(12, atoi.convertCharactersToInt(target));
//    }

    @Test
    public void 숫자앞에_whitespace_포함되면_무시 () {
        String string = "        9 11#$$#$drdgdgf rksk 9";
        Atoi atoi = new Atoi();

        assertEquals(9, atoi.atoi(string));
    }

    @Test
    public void 숫자뒤에_쓰레기문자있으면_무시 () {
        String string = "91111111#$$#$drdgdgf rksk 9";
        Atoi atoi = new Atoi();

        assertEquals(91111111, atoi.atoi(string));
    }

    @Test
    public void 쓰레기문자만날때까지_숫자없으면_0반환 () {
        String string = "   #$$#$drdgdgf  9111111111 rksk 9";
        Atoi atoi = new Atoi();

        assertEquals(0, atoi.atoi(string));
    }

    @Test
    public void intergerMax_넘으면_intergerMax반환 () {
        String string = "911111111111#$$#$drdgdgf rksk 9";
        Atoi atoi = new Atoi();

        assertEquals(Integer.MAX_VALUE, atoi.atoi(string));
    }

    @Test
    public void intergerMin_보다크면이면_그대로_반환 () {
        String string = " - 5#$$#$drdgdgf rksk 9";
        Atoi atoi = new Atoi();

        assertEquals(0, atoi.atoi(string));
    }

    @Test
    public void intergerMin_보다_작은음수면_intergerMin반환 () {
        String string = "        -9111111111#$$#$drdgdgf rksk 9";
        Atoi atoi = new Atoi();

//        int i = 9111111111;
        assertEquals(Integer.MIN_VALUE, atoi.atoi(string));
    }

    @Test
    public void intergerMin_보다_작은양수면_intergerMin반환 () {
        String string = "-88297565555#$$#$drdgdgf rksk 9";
        Atoi atoi = new Atoi();

//        int i = 9111111111;
        assertEquals(Integer.MIN_VALUE, atoi.atoi(string));
    }

}