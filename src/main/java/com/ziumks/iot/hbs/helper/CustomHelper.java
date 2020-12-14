package com.ziumks.iot.hbs.helper;

import com.github.jknack.handlebars.Handlebars;
import org.springframework.stereotype.Component;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@Component
@HandlebarsHelper
public class CustomHelper {

    public CharSequence greet() {
        return "HI ziumks";
    }


    public Handlebars.SafeString htmlzium() {
        return new Handlebars.SafeString("<div><a href='#'> HTML ziumks </a></div>");
    }




}