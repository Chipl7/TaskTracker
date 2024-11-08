package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Music music = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);


        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer);
        System.out.println(musicPlayer1);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        musicPlayer1.setVolume(-100);
        musicPlayer1.setName("name Some");


        System.out.println(musicPlayer1.getName());
        System.out.println(musicPlayer1.getVolume());

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        context.close();
    }
}
