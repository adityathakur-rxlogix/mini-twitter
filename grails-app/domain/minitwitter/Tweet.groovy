package minitwitter

class Tweet {

    String text
    Date dateCreated
    User createdBy

    static belongsTo = [createdBy:User]

    static constraints = {
        text nullable: false, blank: false, maxSize: 140

    }
}
