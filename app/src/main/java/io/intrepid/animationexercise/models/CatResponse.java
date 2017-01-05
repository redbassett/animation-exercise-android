package io.intrepid.animationexercise.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "response")
public class CatResponse {

    @Path("data")
    @ElementList(name = "images")
    private List<Cat> cats;

    public List<Cat> getCats() {
        return cats;
    }
}


