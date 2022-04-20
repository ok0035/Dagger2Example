package com.example.dagger2test

import javax.inject.Inject

class MyClass {
    var str: String? = null //kotlin에선 get/set메소드를 따로 만들지 않기 때문에 Property를 사용하여 set에만 Inject Annotation을 붙여준다.
        @Inject set

}