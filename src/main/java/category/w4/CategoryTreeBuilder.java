package category.w4;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by u_kino07 on 2018. 4. 14..
 */
public class CategoryTreeBuilder extends TreeBuilder<Category> {
    @Override
    protected void setTree() {
        for (Category category : this.nodes) {
            if (category.getId() == category.getParentId()) {
                this.root = category;
            }
            category.setChildren(map.get(category.getId()));
        }
    }

    public Category getAllTree() {
        return this.root;
    }

    public CategoryTreeBuilder build() throws JsonProcessingException {
        super.build();

        for (Category category : this.nodes) {
            category.setChildren(this.map.get(category.getId()));
        }

        System.out.println("[자 map] : ");
        System.out.println(mapper.writeValueAsString(map));
        System.out.println("[자 root] : ");
        System.out.println(mapper.writeValueAsString(root));

        return this;
    }

//    public Category getTree(long rootKey) {
//        for (Category category : this.nodes) {
//            if (node.getKey() == (long)rootKey) {
//                return node;
//            }
//        }
//        return null;
//    }

}
