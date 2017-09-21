package minitwitter

import grails.transaction.Transactional
import minitwitter.co.RegisterCO
import minitwitter.constants.RoleConstants

@Transactional
class UserService {

    RoleService roleService
    TwitterSecurityService twitterSecurityService

    User findUserByUsername(String username) {
        return username ? User.findByUsername(username) : null
    }

    void addRoleToUser(User user, String authority) {
        new UserRole(user:user, role: roleService.findRoleByAuthority(authority))
    }

    User signup(RegisterCO co) {
        if(!co.hasErrors()) {
            User newUser = new User()
            newUser.with {
                fullName = co.fullName
                email = co.email
                password = co.password
                enabled = false
                username = generateRandomUserName(co.fullName)
                fullName=co.fullName
                email=co.email
            }
            newUser.save()
            if(!newUser.hasErrors()){
                addRoleToUser(newUser,RoleConstants.ROLE_USER)
                return newUser
            } else {
                return null
            }
        }
        return null
    }

    boolean modifyPhoneNumber(String username, Integer phone) {
        boolean status = false
        User loggedInUser = twitterSecurityService.loggedInUser
        User user = loggedInUser?: findUserByUsername(username)
        if (user && (loggedInUser.id == user.id || !user.enabled)) {
            user.phone = phone
            user.save()
            if(!user.hasErrors()){
                status = true
            }
        }
        return status
    }
}
