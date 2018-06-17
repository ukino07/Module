package internship2;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by u_kino07 on 2018. 6. 12..
 */
public class TransportationCompanyTest {
    @Test
    public void result() throws Exception {
        TransportationCompany company = new TransportationCompany(20);
        List<Ship> ships = company.getShips();

        if (CollectionUtils.isEmpty(ships)) {
            return;
        }

        Map<String, String> result = new HashMap<>();

        for (int i = 1; i <= ships.size(); i++) {
            result.put(i + "척", company.getTotalNumberItemDelivered(i) + "개");
        }

        System.out.println(result.toString());

        assertEquals(20, result.size());
    }

    @Test
    public void ships() throws Exception {
        TransportationCompany company = new TransportationCompany(20);
        List<Ship> ships = company.getShips();

        if (CollectionUtils.isEmpty(ships)) {
            return;
        }

        int numberItemdelivered = company.getTotalNumberItemDelivered(20);




        System.out.println(company.getShips().toString());

        assertEquals(20, company.getShips().size());
    }

}