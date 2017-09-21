package minitwitter.vo

import minitwitter.User
import minitwitter.co.RegisterCO

class UserVO {
    String fullName
    String username
    String email

    UserVO(User user, RegisterCO registerCO) {
        fullName = user?.fullName?: registerCO.fullName
        username = user?.username?: ''
        email = user?.email?: registerCO.email
    }

    UserVO(User user) {
        if (user?.id) {
            fullName = user.fullName
            username = user.username
            email = user.email
        }
    }
}
