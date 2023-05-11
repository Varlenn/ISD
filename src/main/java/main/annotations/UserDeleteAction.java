package main.annotations;

@PermissionRequired(User.Permission.USER_MANAGMENT)

public class UserDeleteAction {
    public void invoke(User user) {

    }
}
