package com.ttn.bootcamp.RestFulWebServicePart1.versioning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class PersonVersionController {
    /*
     * URI versioning
     * To create a completely different URI for the new service.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v1")
    public Person1 person1() {
        return new Person1("Harry Potter", "harry@gmail.com");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v2")
    public Person2 person2() {
        return new Person2(new PersonDetails("Harry", " Potter", "harry@gmail.com"));
    }

    /*
     * Request Parameter versioning
     * To use the request parameter to differentiate versions
     */
    @RequestMapping(method = RequestMethod.GET, path = "/param", params = "version=1")
    public Person1 paramPerson1() {
        return new Person1("Harry Potter", "harry@gmail.com");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/param", params = "version=2")

    public Person2 paramPerson2() {
        return new Person2(new PersonDetails("Harry", " Potter", "harry@gmail.com"));
    }

    /*
     *Custom Header Versioning
     * To use a Request Header to differentiate the version
     */
    @RequestMapping(method = RequestMethod.GET, path = "/header", headers = "X-API-VERSION=1")

    public Person1 headerPerson1() {
        return new Person1("Harry Potter", "harry@gmail.com");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/header", headers = "X-API-VERSION=2")
    public Person2 headerPerson2() {
        return new Person2(new PersonDetails("Harry", " Potter", "harry@gmail.com"));
    }

    /*
     * MimeType Versioning
     * To use the Accept Header in the request
     */
    @RequestMapping(method = RequestMethod.GET, path = "/produces", produces = "application/vnd.company.app-v1+json")
    public Person1 producesPerson1() {
        return new Person1("Harry Potter", "harry@gmail.com");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/produces", produces = "application/vnd.company.app-v2+json")
    public Person2 producesPerson2() {
        return new Person2(new PersonDetails("Harry", " Potter", "harry@gmail.com"));
    }
}
