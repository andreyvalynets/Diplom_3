package model;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private static String name;
    private static String email;
    private static String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User getRandom() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(8) + "@test.ru";
        String password = RandomStringUtils.randomAlphabetic(8) + "@test.ru";
        return new User(name, email, password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
