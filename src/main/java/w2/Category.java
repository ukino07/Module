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
    // 다른 속성들 추가 (depth)
    private List<Category> children;

    public Category(long parentNo) throws Exception {
        if (parentNo > CATEGORY_COUNT) {
            throw new Exception("해당 부모카테고리가 없습니다.");
        }
        this.parentNo = parentNo;
        this.catNo = CATEGORY_COUNT++;
        CategoryManager.addCatMappingInfo(this);
    }

    private Category() {}

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
        List<Category> children = new ArrayList<Category>();
        Category category;

        for (long childNo : childNos) {
            category = CategoryManager.getCatMap().get(childNo);
            children.add(category);

            if (! CollectionUtils.isEmpty(CategoryManager.getChainMap().get(childNo))) {
                category.setChildren();
            }
        }
        this.children = children;
    }
}
