package me.weldnor.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VkService {

    @SneakyThrows
    public boolean isUserOnline(String userId) {
        Document doc = Jsoup.connect("https://vk.com/" + userId).get();
        Elements profileOnlineElement = doc.select(".profile_online_lv");
        return profileOnlineElement.text().equals("online");
    }
}
