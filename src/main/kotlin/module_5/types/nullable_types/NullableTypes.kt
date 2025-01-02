package module_5.types.nullable_types

/*
Java                Kotlin
@Nullable Type      Type?
@NotNull Type       Type
Type                Type! (platform type) - type that came from Java, type of "unknown" nullability

You can use it like Type in Kotlin, but you may have NullPointerException

In order not to explicitly mark every type as @Nullable or @NotNull, you can choose one of these types as a default one
You need to create your own annotation class with @TypeQualifierDefault and use it before package name
Or you can add explicit types specifications to the Kotlin code
 */