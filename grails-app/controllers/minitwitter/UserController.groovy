package minitwitter

import grails.plugin.springsecurity.annotation.Secured
import minitwitter.co.RegisterCO
import minitwitter.vo.UserVO

@Secured(['permitAll'])
class UserController {

    UserService userService
    TwitterSecurityService twitterSecurityService

    def signup(RegisterCO co) {
        User newUser = userService.signup(co)
        UserVO userVO = new UserVO(newUser, co)
        Map model = [userVO: userVO]
        if (!newUser) {
            flash.message = 'Unable to register new accounts at the moment.'
            render(view: '/user/register', model: model)
        }
        else {
            redirect(controller: 'home')
        }
    }

    def addPhoneNumber(String id) {
        User user = userService.findUserByUsername(id)
        if(!user) {
            redirect(view: '/notFound')
            return
        }
        [userVO: new UserVO(user)]

    }

    def modifyPhoneNumber(String username, Integer phone) {
        userService.modifyPhoneNumber(username, phone)
        redirect(controller: 'home')
    }
}
