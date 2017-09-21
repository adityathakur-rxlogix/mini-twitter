package minitwitter

import java.util.concurrent.TimeUnit

class Tweet {

    String text
    Date dateCreated
    User createdBy

    static belongsTo = [createdBy:User]

    static constraints = {
        text nullable: false, blank: false, maxSize: 140

    }

    static transients = ['isRecent']

    boolean getIsRecent() {
        return  (new Date().time - dateCreated.time) < TimeUnit.MINUTES.toMillis(2)
    }
}
