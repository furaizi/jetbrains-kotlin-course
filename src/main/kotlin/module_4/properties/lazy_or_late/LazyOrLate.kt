package module_4.properties.lazy_or_late

/*
Lazy or late initialization of properties
 */

val lazyValue: String by lazy {
    println("computed")
    "Hello"
}
// It has optimizations and computes only once if not changes

// Late initialization
// Value is not initialized in constructor but later
    /*
    class KotlinActivity: Activity() {
    var myData: MyData? = null
    // but better:
    lateinit var myData: MyData
    // throws a kotlin.UninitializedPropertyAccessException if we try to use it when it's not initialized
    // lateinit cant be val
    // field type cant be primitive

    override fun onCreate(savedIntanceState: Bundle?) {
        super.onCreate(savedIntanceState)
        myData = intent.getParceableExtra("MY_DATA")
    }

    lateinit var lateinitVar: String

    fun initLogic() {
        println(this::lateinitVar.isInitialized)
    }
}
     */