package ir.verjik.util;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class SlugUtil {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String toSlug(String input) {
        if (input == null) {
            return "";
        }
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        slug = slug.replaceAll("-{2,}", "-"); // حذف چند خط تیره متوالی
        slug = slug.toLowerCase(Locale.ENGLISH);
        slug = slug.startsWith("-") ? slug.substring(1) : slug;
        slug = slug.endsWith("-") ? slug.substring(0, slug.length() - 1) : slug;
        return slug;
    }
}
