package com.thoughtworks.capability.gtb;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 脑洞会议系统v3.0
 * 1.当前会议时间"2020-04-01 14:30:00"表示伦敦的本地时间，而输出的新会议时间是芝加哥的本地时间
 * 2.用Period来实现下个会议时间的计算
 *
 * @author itutry
 * @create 2020-05-19_18:43
 */
public class MeetingSystemV3 {

    public static void main(String[] args) {
        String timeStr = "2020-04-01 14:30:00";

        // 根据格式创建格式化类
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 从字符串解析得到会议时间
        LocalDateTime meetingTime = LocalDateTime.parse(timeStr, formatter);

        ZoneId zoneLondon = ZoneId.of("Europe/London");
        ZoneId zoneChicago = ZoneId.of("America/Chicago");

        ZonedDateTime LondonMeeting = ZonedDateTime.of(meetingTime, zoneLondon);
        ZonedDateTime LondonNow = ZonedDateTime.now(zoneLondon);

        if (LondonNow.isAfter(LondonMeeting)) {
            Period period = Period.of(0, 0, 1);
            ZonedDateTime changedLondonMeeting = LondonMeeting.plus(period);

            ZonedDateTime chicagoMeeting = changedLondonMeeting.withZoneSameInstant(zoneChicago);
            String showTimeStr = formatter.format(chicagoMeeting);

            System.out.println(showTimeStr);
        } else {
            System.out.println("会议还没开始呢");
        }
    }
}
