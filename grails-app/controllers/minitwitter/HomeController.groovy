package minitwitter

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class HomeController {

    TwitterSecurityService twitterSecurityService

    def index() {
        [name : twitterSecurityService.loggedInUser?.name]
    }
}
