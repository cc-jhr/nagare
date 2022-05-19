[![Build](https://github.com/cc-jhr/nagare/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/cc-jhr/nagare/actions/workflows/build.yml)

# nagare

Nagare (流れ) is japanese and means "flow" / "stream". This is an assertion/matcher library for kotlin using infix functions.
It is easily extendable using extension functions.

## Setup

In order to use this library you need a github account and a repository read token.
When logged-in open the [personal tokens page](https://github.com/settings/tokens). Create a new token having
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
    testImplementation("io.github.ccjhr:nagare:1.0.0")
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
        val anyObj: Any,
        val list: List<String>
    )
```
