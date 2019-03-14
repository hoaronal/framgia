package com.framgia.support;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FaceBookClient {

    /*public static void main(String[] args) {
        FacebookClient facebookClient = new DefaultFacebookClient("EAAGgqIEfQWQBABIRCbZBX2mtUIcFQRCPs8UmJpvzDdyGgyqlt1QTt1A3Oj3qHOpjilsD5uxIiXhgxJjQQSEeTBuZBwxtKBa7fzh7kApzhuK4ttK1aZASZB5F4sivcUSrMM5jnZC0jLGShAKH3IzjkLLbgOQEsOlkD54OQ2vIGsSpHZBA8k0XALMeQi0vLXstIZD", Version.VERSION_2_11);
        User user = facebookClient.fetchObject("me", User.class);
        System.out.println(user.getName());

        FacebookClient facebookClient1 = new DefaultFacebookClient(appProperties.FACEBOOK_ACCESS_TOKEN, Version.VERSION_2_11);
        Connection<Post> albumConnection = facebookClient1.fetchConnection(
                "turingcom/posts", Post.class);
        List<Post> albums = albumConnection.getData();
        //"https://graph.facebook.com/v2.8/2532283523468697?fields=permalink_url&access_token=458120557969764|FjqL9W2IcHCP79lQLvPWGTMlaf0"
        for (Post album : albums) {
            System.out.println("Album name:" + album.getName());
        }
    }*/
}
