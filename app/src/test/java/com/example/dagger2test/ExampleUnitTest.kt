package com.example.dagger2test


import com.example.dagger2test.inout.Animal2
import com.example.dagger2test.inout.Cat
import com.example.dagger2test.test.case01.DaggerMyComponent
import com.example.dagger2test.test.case01.MyClass
import com.example.dagger2test.test.case01.MyComponent
import com.example.dagger2test.test.case03.DaggerMyComponent2
import com.example.dagger2test.test.case03.MyComponent2
import com.example.dagger2test.test.case04.DaggerPersonComponent
import com.example.dagger2test.test.case04.PersonB
import com.example.dagger2test.test.case04.PersonComponent
import com.example.dagger2test.test.case05.Counter
import com.example.dagger2test.test.case05.CounterComponent
import com.example.dagger2test.test.case05.DaggerCounterComponent
import com.example.dagger2test.test.case06.DaggerNoStrComponent
import com.example.dagger2test.test.case06.DaggerStrComponent
import com.example.dagger2test.test.case06.Foo
import com.example.dagger2test.test.case07.BindsComponent
import com.example.dagger2test.test.case07.DaggerBindsComponent
import com.example.dagger2test.test.case07.Foo2
import com.example.dagger2test.test.case08.DaggerSetComponent
import com.example.dagger2test.test.case08.Foo3
import com.example.dagger2test.test.case09.DaggerMapComponent
import com.example.dagger2test.test.case09.MapComponent
import com.example.dagger2test.test.case10.Animal
import com.example.dagger2test.test.case10.DaggerMapKeyComponent
import com.example.dagger2test.test.case10.MapKeyComponent
import com.example.dagger2test.test.case11.DaggerParentComponent
import com.example.dagger2test.test.case11.ParentComponent
import com.example.dagger2test.test.case12.DaggerMultibindsComponent
import com.example.dagger2test.test.case12.MultibindsComponent
import com.example.dagger2test.test.case13.ComponentA
import com.example.dagger2test.test.case13.ComponentB
import com.example.dagger2test.test.case13.DaggerComponentA
import com.example.dagger2test.test.case13.DaggerComponentB
import com.example.dagger2test.test.case13.Foo4
import org.junit.Assert
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun testHelloWorld() {
        val myComponent: MyComponent = DaggerMyComponent.create()
        println("result = " + myComponent.string)
    }

    @Test
    fun testMyComponent2() {
        val myComponent2: MyComponent2 = DaggerMyComponent2.create()
        val person = myComponent2.person
        Assert.assertNotNull(person)
        Assert.assertEquals(person!!.name, "Charles")
        Assert.assertEquals(person.age.toLong(), 100)
    }

    @Test
    fun testNullable() {
        val myComponent: MyComponent = DaggerMyComponent.create()
        Assert.assertNull(myComponent.integer)
    }

    @Test
    fun testMemberInjection() {
        val myClass = MyClass()
        val str = myClass.str
        Assert.assertNull(str)
        val myComponent: MyComponent = DaggerMyComponent.create()
        myComponent.inject(myClass)
        Assert.assertEquals("Hello World", myClass.str)
    }

    @Test
    fun testInjection() {
        val personComponent: PersonComponent = DaggerPersonComponent.create()
        val personA = personComponent.personA
        val personB = PersonB()
        DaggerPersonComponent.create().inject(personB)
        Assert.assertEquals("Charles", personA!!.name)
        Assert.assertEquals("Charles", personB.name)
        Assert.assertEquals(100, personA.age.toLong())
        Assert.assertEquals(100, personB.age)
    }

    @Test
    fun testLazy() {
        println("testLazy start")
        val component: CounterComponent = DaggerCounterComponent.create()
        val counter = Counter()
        component.inject(counter)
        counter.printLazy()
        println("testLazy end")
    }

    @Test
    fun testProvider() {
        println("test provider start")
        val component: CounterComponent = DaggerCounterComponent.create()
        val counter = Counter()
        component.inject(counter)
        counter.printProvider()
        println("test provider end")
    }

    @Test
    fun testMyComponentWithNamed() {
        val myClass = MyClass()
        DaggerMyComponent.create().inject(myClass)
        Assert.assertEquals("Hello", myClass.strHello)
        Assert.assertEquals("World", myClass.strWorld)
    }

    @Test
    fun testHelloWithQualifier() {
        val myClass = MyClass()
        DaggerMyComponent.create().inject(myClass)
        Assert.assertEquals(myClass.strHelloWithQualifier, "Hello")
    }

    @Test
    fun testObjectIdentity() {
        println("testObjectIdentity start")
        println("singleton?????? ????????? ?????????\nReusable ???????????? ????????? ???????????? ??????????????? ?????? ?????? ?????? ?????????")
        val myComponent: MyComponent = DaggerMyComponent.create()
        val temp1 = myComponent.`object`
        val temp2 = myComponent.`object`
        println(temp1.hashCode())
        println(temp2.hashCode()) // ??? ????????? ???????????? ???????????? ??????????????? ????????? ????????? ????????? ????????? ?????? ??????
        println(temp1 === temp2)
        Assert.assertEquals(temp1, temp2)
        println("testObjectIdentity end")
    }

    @Test
    fun testFoo() {
        println("testFoo start")
        val foo = Foo()
        DaggerStrComponent.create().inject(foo)
        println("daggerStrComponent -> ${foo.str?.isPresent}")
        println("daggerStrComponent -> ${foo.str?.get()}")
        Assert.assertTrue(foo.str!!.isPresent)
        Assert.assertNotNull(foo.str!!.get())

        DaggerNoStrComponent.create().inject(foo)
        Assert.assertFalse(foo.str!!.isPresent)
        println("daggerStrComponent -> ${foo.str?.isPresent}")
        //println("daggerStrComponent -> ${foo.str?.get()}")
        //foo.str.get(); ????????? NoSuchElementException ??????
        println("testFoo end")
    }

    @Test
    fun testBindsInstance() {
        println("testBindsInstance start")
        val hello = "Hello World"
        val foo2 = Foo2()
        val component: BindsComponent = DaggerBindsComponent.builder()
            .setString(hello)!!.build()
        component.inject(foo2)
        println(foo2.str)
        println("testBindsInstance end")
    }

    @Test
    fun testMultibindingSet() {
        println("testMultibindingSet start")
        val foo3 = Foo3()
        DaggerSetComponent.create().inject(foo3)
        foo3.print()
        println("testMultibindingSet end")
    }

    @Test
    fun testMultibindingMap() {
        println("testMultibindingMap start")
        val component: MapComponent = DaggerMapComponent.create()
        val value = component.longsByString!!["foo"]!!
        val str = component.stringsByClass!![Foo::class.java]
        Assert.assertEquals(100, value)
        Assert.assertEquals("Foo String", str)
        println("testMultibindingMap end")
    }

    @Test
    fun testCustomMapKey() {
        println("testCustomMapKey start")
        val component: MapKeyComponent = DaggerMapKeyComponent.create()
        val cat = component.stringsByAnimal!![Animal.CAT]
        val dog = component.stringsByAnimal!![Animal.DOG]
        val number = component.stringsByNumber!![Float::class.java]
        println("cat -> $cat\ndog -> $dog\nnumber -> $number")
        Assert.assertEquals("Meow", cat)
        Assert.assertEquals("Bow-wow", dog)
        Assert.assertEquals("100f", number)
        println("testCustomMapKey end")
    }

    @Test
    fun testMultibindingWithSubcomponent() {
        val parentComp: ParentComponent = DaggerParentComponent.create()
        val childComp = parentComp.childCompBuilder()!!.build()
        println("List set in Parent")
        var itr: Iterator<*> = parentComp.strings()!!.iterator()
        while (itr.hasNext()) {
            println(itr.next())
        }
        println("List set in Child")
        itr = childComp!!.strings()!!.iterator()
        while (itr.hasNext()) {
            println(itr.next())
        }
    }

    @Test
    fun testAbstractMultiBinds() {
        val component: MultibindsComponent = DaggerMultibindsComponent.create()
        //?????? ??????
        for (s in component.strings!!) {
            println(s)
        }
        Assert.assertEquals(0, component.strings!!.size.toLong())
    }

    @Test
    fun testDependency() {
        val foo4 = Foo4()
        val componentA: ComponentA = DaggerComponentA.create()
        val componentB: ComponentB = DaggerComponentB.builder()
            .componentA(componentA)
            .build()
        componentB.inject(foo4)
        Assert.assertEquals("String from ModuleA", foo4.str)
        Assert.assertEquals(100, foo4.integer)
    }

    @Test
    fun testInOut() {
        println("Generic's In/Out Keyword test")

        /*
        * out ???????????? ????????? ?????? ??????
        * Cat??? Animal2??? ???????????? ?????????
        * Array<Cat>??? Array<Animal2>??? ???????????? ?????? ?????? ????????? ????????? ??????
        * ?????????(Invariance) ????????? ????????? ??????
        * ???????????? ????????? ?????????(??? ????????? ???????????? ???????????? ???)??? ?????? ??????????????? ????????? ?????????
        * ???????????? ?????????(Covariance)?????? ???????????? ?????? ????????? -> out
        *
        * ?????? ???????????? ???????????? ?????? ?????? -> invariance
        * out keyword -> read ?????? write ????????? -> covariance
        * in keyword -> write ?????? read ????????? -> contravariance
        * */

        var animalList:Array<Animal2> = arrayOf(Animal2(), Animal2(), Animal2()) //?????? ??????
        val catList:Array<Cat> = arrayOf(Cat(), Cat(), Cat()) //?????? ??????

        copyAnimalFromTo(catList, animalList)
        println("===")
    }

    //in -> any??? animal2??? ??????????????? ??????
    //out -> Cat??? Animal2??? ???????????? ????????? Class<Cat> ??? Class<Animal2>??? ??????????????? ?????????. Array<Cat> -> Array<Animal2>
    private fun copyAnimalFromTo(from: Array<out Animal2>, to:Array<in Animal2>) {
        from.forEachIndexed { i, _ ->
            to[i] = from[i]   //from(in) -> write ??????, read ????????? ???????????? ??????????????? ????????? ???????????? Any??? Animal2??? ?????? ?????? ?????????.
//            to[i] = from[i] //to(out) -> write ?????????, read ?????? out keyword??? ?????? out T??? ?????? ?????? ?????? ??????????????? ??? ??? ?????? ?????????.
            (to[i] as Animal2).printSound()
        }
        to[0] = Cat()
    }

}