import org.junit.Test;

import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.CRC32;

/**
 * Created by u_kino07 on 2018. 6. 12..
 */
public class FilterMicroTest {

    @Test
    public void tet() {
        List<String> pids = new ArrayList<>();
        pids.add("ac0b7896-d57e-4122-84df-5eff7feb1863");
//        pids.add("91527e6d-ff20-4993-8d88-2720b76f8ded");
//        pids.add("407e54dc-1e27-46d8-9111-eb9131a82cc7");
//        pids.add("e82e3770-f6bf-4e6d-89d3-723bb2bf2ce0");
//        pids.add("03c31523-8d60-4ec6-9ed5-2d2539dbaab2");
//        pids.add("a821b3ba-7964-4165-954d-5152401fdcf5");
//        pids.add("e111455e-9ee6-49f5-b123-1354c49fd0f9");
//        pids.add("d518a90e-fdc0-41aa-bca1-bc6c34c0406f");
//        pids.add("957330e1-f999-4b9b-8dac-14999fcdb63e");

        Map<Integer, AbTestType> result = new HashMap<>();

        for (int i = 0; i < pids.size(); i++) {
            int key = makeCrcKey(pids.get(i));
            result.put(key, getAbType(key));
        }

        System.out.println(result);
    }

    enum AbTestType {
        A, B, C;
    }

    private Integer makeCrcKey(String pid) {  // AbTest abtest, String pid) {
        String localDateTime = "2017-11-09 11:00:09";
                // abtest.getUpdateAt().format(LocalDateTimeConstants.DATE_TIME_FORMATTER);
        return (int) (Math.abs(getCrc32Value(pid) + getCrc32Value(localDateTime)) % (long) 100) + 1;
    }

    private long getCrc32Value(String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes(Charset.forName("UTF-8")));
        return crc32.getValue();
    }

    private AbTestType getAbType(Integer value) {
        Map<AbTestType, Integer> map = makeAbTestMap();
        System.out.println(map);

        return map.entrySet().stream()
                .filter(entry -> value <= entry.getValue())
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(AbTestType.A);
    }

    public Map<AbTestType, Integer> makeAbTestMap() {
        EnumMap<AbTestType, Integer> map = new EnumMap<>(AbTestType.class);
        IncreaseRatio ratio = new IncreaseRatio();
        putIfValid(map, AbTestType.A, ratio.next(0));
        putIfValid(map, AbTestType.B, ratio.next(100));
        putIfValid(map, AbTestType.C, ratio.next(null));

        return map;
    }

    private void putIfValid(EnumMap<AbTestType, Integer> map, AbTestType type, Integer value) {
        if (value != null) {
            map.put(type, value);
        }
    }

    private class IncreaseRatio {
        Integer sum = 0;

        Integer next(Integer ratio) {
            if (ratio != null) {
                sum += ratio;
            }
            return sum;
        }
    }

    @Test
    public void test() {
        Long[] dataArray = new Long[]{
                605448558L,
                762862070L,
                732020850L,
                876940510L,
                875396186L,
                873003746L,
                871351898L,
                866817582L,
                866184262L,
                865578134L,
                858040266L,
                832804306L,
                813862586L,
                766360978L,
                745639890L,
                744606046L,
                678663454L,
                655668646L,
                598130130L,
                589300850L,
                537157714L,
                492975882L,
                211881929L,
                879427318L,
                879390246L,
                878247022L,
                877899414L,
                876871570L,
                875675642L,
                874242322L,
                874098478L,
                873674842L,
                872358130L,
                870334650L,
                867534906L,
                865758634L,
                854274438L,
                802324154L,
                787439214L,
                780455198L
        };

        Long[] todaysPickArray = new Long[]{
                1169806986L
                ,1181007358L
                ,1199172390L
                ,1201333070L
                ,1169028498L
                ,1167845994L
                ,739368590L
                ,1198877018L
                ,1178660766L
                ,1199427446L
                ,1160608838L
                ,1215911926L
                ,1215894722L
                ,1165438910L
                ,1201463518L
                ,1143235242L
                ,1205626430L
                ,452865058L
                ,1200006822L
                ,1179176690L
                ,1181204678L
                ,1199198358L
                ,1198832002L
                ,1182500942L
                ,1163300710L
                ,1203638462L
                ,1181665194L
                ,1187300514L
                ,1157744954L
                ,1179270022L
                ,1053339654L
                ,596400070L
                ,1204673054L
                ,1198954142L
                ,1199014018L
                ,1205745002L
                ,1163430426L
                ,1201668790L
                ,1198096186L
                ,1165098774L
                ,1205402582L
                ,1190641018L
                ,1201134498L
                ,1204897354L
                ,1215850230L
                ,1200324226L
                ,1188989534L
                ,1190717058L
                ,1157813790L
                ,1200769086L
                ,1203242734L
                ,1205525150L
                ,1181035262L
                ,1042355086L
                ,758476498L
                ,662832062L
                ,1083696594L
                ,1201125458L
                ,1191687614L
                ,1190831326L
                ,927438638L
                ,1198868674L
                ,1187489102L
                ,1203816146L
                ,605448558L
                ,1161072390L
                ,778016126L
                ,1203733446L
                ,1089748814L
                ,1163211034L
        };

        Long[] excludeArray = new Long[]{
                520123294L,
                364758342L,
                474139062L,
                463146954L,
                514309190L,
                516528742L,
                388622990L,
                493806894L,
                501445078L,
                498410842L,
                497085558L,
                494998818L,
                444318710L,
                481425142L,
                468132706L,
                463048626L,
                388827378L,
                422511986L,
                450261522L,
                410844710L,
                443556906L
        };

        List<Long> dataApi = Arrays.asList(dataArray);
        System.out.println(dataApi.size());
        List<Long> todaysPickApi = Arrays.asList(todaysPickArray);
        List<Long> excludeApi = Arrays.asList(excludeArray);

//        dataApi.stream().filter(d -> !todaysPickApi.contains(d)).filter(d -> !excludeApi.contains(d)).collect(Collectors.toList());

        System.out.println(dataApi.stream().filter(d -> !todaysPickApi.contains(d)).filter(d -> !excludeApi.contains(d)).collect(Collectors.toList())); // 39
    }
}
