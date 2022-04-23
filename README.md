# nagare

Nagare (流れ) is japanese and means "flow" / "stream". This is an assertion/matcher library for kotlin using infix functions.
It is easily extendable using extension functions.

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
