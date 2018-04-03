package w2;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.LinkedMultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by u_kino07 on 2018. 3. 31..
 */
public class CategoryManager {
    private static Map<Long, Category> catMap = new HashMap<Long, Category>();
    private static LinkedMultiValueMap<Long, Long> chainMap = new LinkedMultiValueMap<Long, Long>();

    public static Map<Long, Category> getCatMap() {
        return catMap;
    }

    public static LinkedMultiValueMap<Long, Long> getChainMap() {
        return chainMap;
    }

    public static void registerCategories(List<Category> categories) throws JsonProcessingException {
        clean();

        categories.stream().forEach(category -> {
            if (! catMap.containsKey(category.getCatNo())) {
                catMap.put(category.getCatNo(), category);

                if (category.getCatNo() != category.getParentNo()) {
                    chainMap.add(category.getParentNo(), category.getCatNo());
                }
            }
        });
    }

    public static void clean() {
        catMap.clear();
        chainMap.clear();
    }

    public static Category getCategoryTree(long topCatNo) throws JsonProcessingException {
        Category topCategory = catMap.get(topCatNo);
        topCategory.setChildren();
        return topCategory;
    }

    public static List<Category> getCategoryFlat(long topCatNo) throws JsonProcessingException {
        return chainMap.get(topCatNo)
                .stream()
                .map(childNo -> catMap.get(childNo))
                .collect(Collectors.toList());
    }





    // TODO. update, delete
}
