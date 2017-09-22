package minitwitter

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import minitwitter.co.PasswordCO
import minitwitter.constants.RoleConstants

@Secured([RoleConstants.ROLE_USER,RoleConstants.ROLE_ADMIN])
class HomeController {

    TwitterSecurityService twitterSecurityService
    TweetService tweetService
    UserService userService

    def index() {
        [user : twitterSecurityService.loggedInUser, tweets: tweetService.fetchLatestTweets()]
    }

    def fetchLatestTweets() {
        String tweetsHTML = g.render(template: '/common/tweets', model: ['tweets': tweetService.fetchLatestTweets()])
        render([html: tweetsHTML] as JSON)
    }

    def postTweet(String tweetText) {
        boolean status = tweetService.postTweet(tweetText)
        String message = status ? message(code: 'tweet.success') : message(code: 'tweet.fail')
        if(status) {
            servletContext.feedVersion++;
        }
        render([status: status, message: message] as JSON)
    }

    def updateFeedVersion() {
        render([feedVersion : servletContext.feedVersion] as JSON)
    }

    def settings() {
        [user: twitterSecurityService.loggedInUser]
    }

    def checkIfUsernameNotExists(String username) {
        render username ? !userService.checkIfUsernameExists(username) : true
    }

    def updateUsername(String username) {
        boolean status = username ? userService.updateUsername(username) : false
        String message = status ? message(code: 'username.update.success') : message(code: 'username.update.fail')
        render([status: status, message: message] as JSON)
    }

    def updateFullName(String fullName) {
        boolean status = fullName ? userService.updateFullName(fullName) : false
        String message = status ? message(code: 'fullname.update.success') : message(code: 'fullname.update.fail')
        render([status: status, message: message] as JSON)
    }

    def updatePassword(PasswordCO passwordCO) {
        String status = userService.updatePassword(passwordCO)
        String message = status ? message(code: 'password.update.success') : message(code: 'password.update.fail')
        render([status: status, message: message] as JSON)
    }
}
