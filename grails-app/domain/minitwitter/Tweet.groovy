package minitwitter

class Tweet {

    String content
    Date dateCreated
    User createdBy

    static belongsTo = [createdBy:User]

    static constraints = {
        content nullable: false, blank: false, maxSize: 140

    }
}
