package mainsrc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MarketPlaceScrapper {
    public static List<String> scrapeMarketplaceIds(String url) throws IOException {
        List<String> marketplaceIds = new ArrayList<String>();
        Document doc = Jsoup.connect(url).get();
        Element table = doc.select(".rdmd-table").get(1);
        Elements rows = table.getElementsByTag("tr");

        for (Element row : rows) {
            Elements columns = row.getElementsByTag("td");
            if (columns.size() > 1) {
                String marketplaceId = columns.get(1).text();
                marketplaceIds.add(marketplaceId);
            }
        }

        return marketplaceIds;
    }


}