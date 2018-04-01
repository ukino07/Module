package w2;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 3. 31..
 */
public class Category {
    private static long CATEGORY_COUNT = 0;
    private static Category topCategory;

    static {
        topCategory = new Category();
        topCategory.catNo = CATEGORY_COUNT++;
        CategoryManager.addCatMappingInfo(topCategory);
    }

    private long catNo;
    private long parentNo;
    // 다른 속성들 추가 (자동으로 depth 도 되도록)
    private List<Category> children;

    // 생성자
    public Category(long parentNo) throws Exception {
        if (parentNo > CATEGORY_COUNT) {
            throw new Exception("해당 부모카테고리가 없습니다.");
        }
        this.parentNo = parentNo;
        this.catNo = CATEGORY_COUNT++;
        CategoryManager.addCatMappingInfo(this);
    }

    private Category() {}

    // 게터 세터
    public long getParentNo() {
        return parentNo;
    }

    public void setParentNo(long parentNo) {
        this.parentNo = parentNo;
    }

    public long getCatNo() {
        return catNo;
    }

    public void setCatNo(long catNo) {
        this.catNo = catNo;
    }

    public void setChildren() {
        List<Long> childNos = CategoryManager.getChainMap().get(this.catNo);
        List<Category> children = new ArrayList<Category>(); // 빈 자식 카테고리
        Category category;

        for (long childNo : childNos) {
            //자식 모델 가져옴
            category = CategoryManager.getCatMap().get(childNo);
            //자식의 자식번호 가져옴
//            System.out.println("자식번호를 찍어보자");
//            System.out.println(childNo);
//            System.out.println(CategoryManager.getChainMap().get(childNo));
            children.add(category);

            if (! CollectionUtils.isEmpty(CategoryManager.getChainMap().get(childNo))) {
                category.setChildren();
            }
        }
        this.children = children;
    }
}
