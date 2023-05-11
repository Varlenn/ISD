package main.annotations;

import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;


@Value
@Builder
public class User {
    String id;
    String login;
    String password;

    public  static enum Permission {
        USER_MANAGMENT, CONTENT_MANAGMENT
    }

    private List<Permission> permissions;
    public List<Permission> getPermissions() {
        return new ArrayList<Permission>(permissions);
    }
}
