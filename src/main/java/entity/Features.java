package entity;

import static java.util.Objects.isNull;

public enum Features {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private String value;

    Features(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Features getFeatureByValue(String value) {
        if(isNull(value) || value.isEmpty()){
            return  null;
        }
        Features[] features = Features.values();
        for (Features feature: features) {
            if (feature.value.equals(value)){
                return feature;
            }

        }
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
