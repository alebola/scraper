package es.ulpgc.scraper;

public class Main {

    public static void main(String[] args) {
        int nPages = 2;
        String urlWithoutOffset = "https://www.booking.com/searchresults.es.html?label=tenerife-sur-sPDWPGTZy0WFBQ_MBnpM" +
                "zwS410722624025%3Apl%3Ata%3Ap1%3Ap2%3Aac%3Aap%3Aneg%3Afi%3Atikwd-11985842509%3Alp9047034%3Ali%3Adec%3Adm%3" +
                "Appccp%3DUmFuZG9tSVYkc2RlIyh9YTiRJUvwM0AZDoPI6XBbFtM&sid=5cd4ae3e13df6db0916e6dc06398f874&aid=1610834&sb=1&sb_lp" +
                "=1&src=region&src_elem=sb&error_url=https%3A%2F%2Fwww.booking.com%2Fregion%2Fes%2Ftenerife-sur.es.html%3" +
                "Faid%3D1610834%26label%3Dtenerife-sur-sPDWPGTZy0WFBQ_MBnpMzwS410722624025%253Apl%253Ata%253Ap1%253Ap2%253A" +
                "ac%253Aap%253Aneg%253Afi%253Atikwd-11985842509%253Alp9047034%253Ali%253Adec%253Adm%253Appccp%253DUmFuZG9tSV" +
                "Ykc2RlIyh9YTiRJUvwM0AZDoPI6XBbFtM%26sid%3D5cd4ae3e13df6db0916e6dc06398f874%26&ss=Tenerife+Sur&is_ski_area=0&s" +
                "sne=Tenerife+Sur&ssne_untouched=Tenerife+Sur&region=13444&checkin_year=&checkin_month=&checkout_year=&checko" +
                "ut_month=&group_adults=2&group_children=0&no_rooms=1&b_h4u_keep_filters=&from_sf=1&offset=";
        Controller controller = new Controller();
        controller.run(nPages, urlWithoutOffset);
    }
}
