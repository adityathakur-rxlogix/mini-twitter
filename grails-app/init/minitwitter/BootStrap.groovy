package minitwitter

class BootStrap {

    PopulateDataService populateDataService

    def init = { servletContext ->

        servletContext.feedVersion = 0;

        populateDataService.populateDefaultRoles()
        populateDataService.populateAdminUserAndWelcomeTweet()
    }

    def destroy = {
    }
}
