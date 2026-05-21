package com.google.gson;

/* loaded from: classes.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l5) {
            return l5 == null ? JsonNull.INSTANCE : new JsonPrimitive(l5);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l5) {
            return l5 == null ? JsonNull.INSTANCE : new JsonPrimitive(l5.toString());
        }
    };

    public abstract JsonElement serialize(Long l5);
}
