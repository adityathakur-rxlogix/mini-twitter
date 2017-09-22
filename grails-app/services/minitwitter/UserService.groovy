package minitwitter

import grails.transaction.Transactional
import minitwitter.co.PasswordCO
import minitwitter.co.RegisterCO
import minitwitter.constants.RoleConstants

@Transactional
class UserService {

    RoleService roleService
    TwitterSecurityService twitterSecurityService

    User findUserByUsername(String username) {
        return username ? User.findByUsername(username) : null
    }

    boolean checkIfUsernameExists(String username) {
        return User.countByUsername(username) != 0
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

    boolean updateUsername(String username) {
        boolean status = false
        if(!checkIfUsernameExists(username)) {
            User user = twitterSecurityService.loggedInUser
            user.setUsername(username)
            if (user.save(flush:true)) status = true
        }
        return status
    }

    boolean updateFullName(String fullName) {
        User user = twitterSecurityService.loggedInUser
        user.setFullName(fullName)
        return user.save(flush:true)
    }

    boolean updatePassword(PasswordCO passwordCO) {
        boolean status = false
        if (passwordCO.validate()) {
            User user = twitterSecurityService.loggedInUser
            if (user.password.equals(passwordCO.currentPassword)) {
                user.setPassword(passwordCO.newPassword)
                if(user.save(flush:true)) status = true
            }
        }
        return status
    }

}
