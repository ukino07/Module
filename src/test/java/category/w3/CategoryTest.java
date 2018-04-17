package category.w3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 4. 7..
 */
public class CategoryTest {
    ObjectMapper mapper = new ObjectMapper();

    // 카테고리 준비 (DB table 에 만들거임)
    Category root = new Category("전체");
    Category brandFashion = new Category("브랜드패션");
    Category fashionGoods = new Category("패션잡화");
    Category beauty = new Category("뷰티");
    Category foodHealth = new Category("식품/건강");
    Category livingGoods = new Category("생활/주방");
    Category sports = new Category("스포츠/자동차");
    Category bestHoneyDeal = new Category("베스트꿀딜");
    Category superSpecialPrice = new Category("슈퍼특가");
    Category honeyDeal = new Category("꿀딜");
    Category boyshoes = new Category("남성화");
    Category bags = new Category("가방");
    Category accessary = new Category("쥬얼리");

    @Before
    public void makeTree() throws Exception {
        // 트리 생성
        TreeFactory<Category> treeFactory = new TreeFactory<>(root);

        // 1 뎁스
        treeFactory.addNode(brandFashion, root);
        treeFactory.addNode(fashionGoods, root);
        treeFactory.addNode(beauty, root);

        // 2 뎁스
        treeFactory.addNode(foodHealth, brandFashion);
        treeFactory.addNode(livingGoods, brandFashion);
        treeFactory.addNode(boyshoes, fashionGoods);
        treeFactory.addNode(bags, fashionGoods);
        treeFactory.addNode(accessary, fashionGoods);

        // 3뎁스
        treeFactory.addNode(sports, foodHealth);
        treeFactory.addNode(bestHoneyDeal, foodHealth);

        // 3뎁스
        treeFactory.addNode(superSpecialPrice, livingGoods);
        treeFactory.addNode(honeyDeal, livingGoods);

//        treeFactory.moveNode(bags, fashionGoods, boyshoes);

        System.out.println("[root] : ");
        System.out.println(mapper.writeValueAsString(treeFactory.getAllTree()));
    }

    @Test
    public void testTreeCategory() throws Exception {
        assertEquals(3, fashionGoods.getChildren().size());
        assertEquals(true, foodHealth.getChildren().contains(sports));
    }

    @Test
    public void testFlatCategory() throws JsonProcessingException {

    }
}
