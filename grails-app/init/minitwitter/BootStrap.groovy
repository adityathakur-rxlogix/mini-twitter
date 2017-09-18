package minitwitter

class BootStrap {

    PopulateDataService populateDataService

    def init = { servletContext ->
        populateDataService.populateDefaultRoles()
    }

    def destroy = {
    }
}
