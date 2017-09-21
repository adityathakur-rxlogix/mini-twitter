package minitwitter

import grails.transaction.Transactional

@Transactional
class TweetService {

    TwitterSecurityService twitterSecurityService

    List<Tweet> fetchLatestTweets() {
        return Tweet.createCriteria().list {
            maxResults(10)
            order('dateCreated', 'desc')
        } as List<Tweet>
    }

    boolean postTweet(String tweetText) {
        Tweet newTweet = new Tweet()
        newTweet.with {
            text = tweetText
            createdBy = twitterSecurityService.loggedInUser
        }
        if (newTweet.save()){
            return true
        }
        return false
    }
}
