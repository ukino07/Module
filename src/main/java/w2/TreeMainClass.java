package w2;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by u_kino07 on 2018. 3. 31..
 */
public class TreeMainClass {
    public static void main(String[] args) throws Exception {
        // 카테고리 준비
        new Category(0L); // 1
        new Category(0L); // 2
        new Category(0L); // 3
        new Category(0L); // 4

        new Category(1L); // 5
        new Category(1L); // 6
        new Category(1L); // 7
        new Category(1L); // 8

        new Category(2L); // 9
        new Category(2L); // 10
        new Category(2L); // 11

        new Category(3L); // 12
        new Category(3L); // 13

        new Category(4L); // 14

        new Category(5L); // 15
        new Category(5L); // 16
        new Category(5L); // 17

        new Category(6L); // 18
        new Category(6L); // 19

        new Category(7L); // 20

        new Category(9L); // 21
        new Category(9L); // 22

        new Category(10L); // 23

        new Category(12L); // 24

        new Category(15L); // 25
        new Category(15L); // 26
        new Category(15L); // 27

        new Category(16L); // 28
        new Category(16L); // 29

        new Category(17L); // 30

        new Category(18L); // 31
        new Category(18L); // 32

        new Category(19L); // 33

        new Category(21L); // 34
        new Category(21L); // 35

        new Category(25L); // 36
        new Category(25L); // 37
        new Category(25L); // 38

        new Category(36L); // 39

        Category result = CategoryManager.getCategoryTree(0L);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("결과");
        System.out.println(mapper.writeValueAsString(result));
        System.out.println("카테고리 정보");
        System.out.println(mapper.writeValueAsString(CategoryManager.getCatMap()));
        System.out.println("연결 정보");
        System.out.println(mapper.writeValueAsString(CategoryManager.getChainMap()));
    }
}
