package category.w2;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 3. 31..
 */
public class Category {
    private static long CATEGORY_COUNT = 0;

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
    }

    public Category() {
        this.parentNo = 0L;
        this.catNo = CATEGORY_COUNT++;
    }

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

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren() throws JsonProcessingException {
        List<Long> childNos = CategoryManager.getChainMap().get(this.catNo);

        if (CollectionUtils.isEmpty(childNos)) {
            return;
        }

        List<Category> children = new ArrayList<Category>();

        for (long childNo : childNos) {
            Category child = CategoryManager.getCatMap().get(childNo);
            children.add(child);
            child.setChildren();
        }

        this.children = children;
    }
}
