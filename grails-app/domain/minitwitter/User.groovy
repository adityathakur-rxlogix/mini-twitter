package minitwitter

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.apache.commons.lang.RandomStringUtils

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String fullName
    String email
    Long phone
    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        email nullable: false, blank: false, unique: true
        fullName nullable: true, blank: true
        phone nullable: true, min: 1000000000l, max: 9999999999l
    }

    static transients = ['name']

    static mapping = {
        password column: '`password`'
    }

    String getName() {
        fullName ?: username
    }

    String generateRandomUserName(String fullName) {
        return fullName.replaceAll(' ', '').toLowerCase() + '_' + RandomStringUtils.randomNumeric(5)
    }
}
