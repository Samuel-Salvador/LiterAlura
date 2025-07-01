package com.ONE.LiterAlura.models;

public enum Language {

    pt("portugues"),
    en("ingles"),
    fr("frances"),
    es("espanhol");

    private final String language;

    Language(String language) {
        this.language = language;
    }

    public static Language fromString(String language){
        for (Language type : values()){
            if(language.equalsIgnoreCase(type.toString())){
                return type;
            }
        }
        throw new IllegalArgumentException("Língua não conhecida!");
    }

    public String getLanguage() {
        return language;
    }
}
