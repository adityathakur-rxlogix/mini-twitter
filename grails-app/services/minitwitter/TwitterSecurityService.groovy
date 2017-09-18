package minitwitter

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional

@Transactional
class TwitterSecurityService{

    SpringSecurityService springSecurityService

    User getLoggedInUser() {
        Long userId = (Long) springSecurityService.currentUserId
        return userId ? User.get(userId) : null
    }
}
