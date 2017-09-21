package minitwitter

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import minitwitter.constants.RoleConstants

@Secured([RoleConstants.ROLE_USER,RoleConstants.ROLE_ADMIN])
class HomeController {

    TwitterSecurityService twitterSecurityService
    TweetService tweetService

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
}
