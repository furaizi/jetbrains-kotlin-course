package module_3.nullability.safe_casts

/*
Type cast: as
if (any is String) {
    val s = any as String // not necessary
    s.toUpperCase()
}

if (any is String)
    any.toUpperCase() // ok
}

Safe cast: as?
(any as? String)?.toUpperCase()

foo as? Type
if (foo is Type)
    foo as Type
else
    null
 */