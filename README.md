[![Build](https://github.com/cc-jhr/nagare/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/cc-jhr/nagare/actions/workflows/build.yml)

# nagare

Nagare (流れ) is japanese and means "flow" / "stream". This is an assertion/matcher library for kotlin using infix functions.
It is easily extendable using extension functions. You can use it with both junit or testng.

## Setup

In order to use this library you need a github account and a repository read token.
When logged-in open the [personal access tokens page](https://github.com/settings/tokens). Create a new token having
`read:packages` as the only permission.

### Gradle - kotlin-dsl

Add the repository to your existing list of repositories:

```gradle
repositories {
    maven {
        name = "nagare"
        url = uri("https://maven.pkg.github.com/cc-jhr/nagare")
        credentials {
            username = "your-github-username-here"            // you should probably use environment variables
            password = "your-github-packages-read-token-here" // or gradle properties here to inject the values
        }
    }
}
```

Add the dependency to your `dependencies` block:

```gradle
dependencies {
    testImplementation("io.github.ccjhr:nagare:VERSION")
}
```

## Usage

Origin of a test is the object itsef. The object must satisfy criteria
```kotlin
    @Test
    fun `usage test`() {
        12 mustSatisfy {
            
        }
    }
```

Various criteria can be described depending on the class type. `Int` for example provides functions like `isGreaterThan`/`isLesserThan`.
```kotlin
    @Test
    fun `usage test`() {
        12 mustSatisfy {
            it isGreaterThan 6
        }
    }
```

Nullability can be checked using additional adjectives:
```kotlin
    @Test
    fun `usage test`() {
        val obj: String? = null
        
        obj mustSatisfy {
            it isNot Null
        }
    }
```

Checking a parameter of a more complex object can be achieved using a nested `mustSatisfy` block:
```kotlin
    @Test
    fun `usage test`() {
        val obj = MyObj(12, "", emptyList())

        obj mustSatisfy {
            it isNot Null
            it isOfType MyObj::class

            it.content.number mustSatisfy { number ->
                number isEqualTo 12
            }
        }
    }

    data class MyObj(
        val number: Int,
    )
```

## Individual extensions

Lets assume we have an individual object.

```kotlin
data class MyObj(
    val title: String = "",
    val number: Int = 0,
)
```

### Based on values

The extension function itself always has a similar structure. In the signature we place our object type as
well as the class type that we want to test against and give the function a name.
Check for nullability. It's possible to make this non-nullable, but then you would have to use `!!` operator or
a kotlin function which uses contracts like `requireNotNull` if your resulting object is nullable.

```kotlin
inline infix fun <reified T : MyObj?> AssertionContext<T>.hasTitleMatching(regex: Regex) {
    requireNotNull(this.content) { "Object for assertion is null." }
    if (!regex.matches(this.content.title)) {
        fail("Expecting title <${this.content.title}> to match <${regex.pattern}>, but it doesn't.")
    }
}
```

Then we can use it in a test.

```kotlin
@Test
fun `test the newly created extension`() {
    // given
    // setting up the test case

    // when
    val result: MyObj = // code that returns an instance of MyObj

    // then
    result mustSatisfy {
        it hasTitleMatching Regex("[a-z]+-[0-9]+")
    }
}
```

### Based on adjectives

We can create extensions using adjectives by adding an `enum class` for the adjectives.
Here we simply imply that the object is "valid" in a way.

```kotlin
enum class MyObjAssertionAdjective {
    Valid
}
```

The only difference is that the extension function takes the enum class as parameter and we use a `when` to apply to the
different cases.

Just for the demonstration we assume that the object is valid if it has a `number` greater than `0` and a `title` which
is not blank.

```kotlin
inline infix fun <reified T : MyObj?> AssertionContext<T>.hasToBe(adjective: MyObjAssertionAdjective) {
    requireNotNull(this.content) { "Object for assertion is null." }
    when(adjective) {
        Valid -> if (content.number <= 0 || content.title.isBlank()) fail("Object is not valid.")
    }
}
```

Then we can use it in a test.

```kotlin
@Test
fun `test the newly created extension`() {
    // given
    // setting up the test case

    // when
    val result: MyObj = // code that returns an instance of MyObj

    // then
    result mustSatisfy {
        it hasToBe Valid
    }
}
```