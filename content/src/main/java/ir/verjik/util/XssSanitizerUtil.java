package ir.verjik.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class XssSanitizerUtil {

    public static String sanitize(String input) {
        return input
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&#x27;")
                .replaceAll("&", "&amp;");
    }

    public static String sanitizeHtml(String htmlContent) {
        // فقط اجازه عناصر امن مانند <p>, <b>, <strong> و ...
        Safelist safelist = Safelist.basicWithImages();
        safelist.addTags("div", "span", "br","hr","blockquote")
                .addAttributes("img", "style", "width", "height");;
        return Jsoup.clean(htmlContent, safelist);
    }
}
