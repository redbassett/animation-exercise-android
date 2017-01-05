package io.intrepid.animationexercise.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.intrepid.animationexercise.models.Cat;

public class DataUtils {

    private static final List<String> URLS = Collections.unmodifiableList(Arrays.asList(
            "http://24.media.tumblr.com/tumblr_m7qy0sdwbO1qdwizao1_1280.jpg",
            "http://25.media.tumblr.com/tumblr_lhbzejSLlX1qfyzelo1_1280.jpg",
            "http://25.media.tumblr.com/tumblr_m1idljxe1y1qjc1a7o1_500.jpg",
            "http://24.media.tumblr.com/tumblr_m06tvrKPCS1qzfsnio1_500.jpg",
            "http://25.media.tumblr.com/tumblr_m3kio7ZzN31qjc1a7o1_1280.jpg",
            "http://24.media.tumblr.com/tumblr_m2avntGAON1qze0hyo1_1280.jpg",
            "http://25.media.tumblr.com/tumblr_m1mg9xfGfN1qay66po1_500.jpg",
            "http://25.media.tumblr.com/tumblr_lp6fgzkJ4i1qlj2dwo1_1280.jpg",
            "http://24.media.tumblr.com/tumblr_lzys99EFsr1qzpwi0o1_1280.jpg",
            "http://25.media.tumblr.com/tumblr_m4ielv6qKV1qd477zo1_1280.jpg",
            "http://24.media.tumblr.com/tumblr_m4rzqsp1oh1r6jd7fo1_500.jpg",
            "http://25.media.tumblr.com/tumblr_m0xvyxtl611r2ks68o1_1280.jpg",
            "http://29.media.tumblr.com/tumblr_lu5xv8Bml71r4xjo2o1_r1_500.jpg",
            "http://24.media.tumblr.com/tumblr_ltagshb1v21r27cnwo1_1280.jpg",
            "http://24.media.tumblr.com/3222402_500.jpg",
            "http://27.media.tumblr.com/tumblr_lwib45dy5X1qbhms5o1_500.jpg",
            "http://25.media.tumblr.com/tumblr_lm677qiCkY1qbe5pxo1_1280.jpg",
            "http://26.media.tumblr.com/tumblr_m32nq5PGu91qhwmnpo1_1280.jpg",
            "http://25.media.tumblr.com/tumblr_li3wtxLXuU1qgnva2o1_500.jpg",
            "http://24.media.tumblr.com/tumblr_m4nxpe4dwI1qd477zo1_500.jpg")
    );

    private static final List<String> NAMES = Collections.unmodifiableList(Arrays.asList(
            "Johnny",
            "Peanut",
            "Cheerio",
            "Duo",
            "Neko",
            "Fang",
            "Maxxy",
            "Willow",
            "Mr Kittenpants",
            "Pepper",
            "Lola",
            "Oreo",
            "Pookie",
            "Gadget",
            "Toby",
            "Silvester",
            "Diane",
            "Princess Caroline",
            "Bear",
            "Raja")
    );

    public static List<Cat> getData() {
        List<Cat> cats = new ArrayList<>(20);
        for (int i = 0; i < NAMES.size(); i++) {
            Cat cat = new Cat(NAMES.get(i), URLS.get(i));
            cats.add(cat);
        }
        return cats;
    }
}
