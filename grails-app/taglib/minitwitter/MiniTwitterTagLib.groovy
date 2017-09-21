package minitwitter

class MiniTwitterTagLib {

    static namespace = 'twt'

    TwitterSecurityService twitterSecurityService

    def loggedInUserFullName = {attrs, body->
        out << twitterSecurityService.loggedInUser?.name
    }

    def feedVersion = {attrs, body->
        out << servletContext.feedVersion
    }
}
