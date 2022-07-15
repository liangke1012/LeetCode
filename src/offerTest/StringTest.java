package offerTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StringTest {
    public static void main(String[] args) {
//        long[] time = {1646735903195L,1646735904194L,1646735905192L,1646735906348L,1646737321729L,1646737322695L,1646737328511L,1646737332113L,1646740922738L,1646740923698L,1646740924433L,1646740928555L,1646747595061L,1646747705793L,1646747711762L,1646748005978L,1646748129634L,1646748138310L,1646751722115L,1646751724175L,1646753892069L,1646754115061L,1646754297342L,1646755200297L,1646755325264L,1646758925359L,1646760398247L,1646760448092L,1646760456633L,1646762522381L,1646762525167L,1646766130709L,1646766132545L,16,46789764419L
//        };
        long[] time = {1646828755655L,1646830929647L,1646730527244L,1646730542220L,1646730576115L,1646730622246L,1646730663026L,1646730680715L,1646730743109L,1646730749040L,1646730814365L,1646730869381L};
        int len = time.length;
        for (int i = 0; i < len; i++) {
            Date date = new Date(time[i]);
            DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = df1.format(date);
            //System.out.println("onProcessingTime,time:" + dateStr);
        }

        List<Float> ll = new ArrayList<>();
        List<Float> ll2 = new ArrayList<>();
        ll.add(1.0f);
        ll.add(2.0f);
        ll.add(3.0f);
        ll2.add(1.0f);
        ll2.add(2.0f);
        ll2.add(3.0f);
        List<List<Float>> list = new ArrayList<>(2);
        list.add(ll);
        list.add(ll2);


        System.out.println(list.toString());


    }
}
