package com.example.dagger2test


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
        val component: CounterComponent = DaggerCounterComponent.create()
        val counter = Counter()
        component.inject(counter)
        counter.printLazy()
    }

    @Test
    fun testProvider() {
        val component: CounterComponent = DaggerCounterComponent.create()
        val counter = Counter()
        component.inject(counter)
        counter.printProvider()
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
        val myComponent: MyComponent = DaggerMyComponent.create()
        val temp1 = myComponent.`object`
        val temp2 = myComponent.`object`
        println(temp1.hashCode())
        println(temp2.hashCode())
        println(temp1 === temp2)
        Assert.assertEquals(temp1, temp2)
    }

    @Test
    fun testFoo() {
        val foo = Foo()
        DaggerStrComponent.create().inject(foo)
        Assert.assertTrue(foo.str!!.isPresent)
        Assert.assertNotNull(foo.str!!.get())
        DaggerNoStrComponent.create().inject(foo)
        Assert.assertFalse(foo.str!!.isPresent)
        //foo.str.get(); 호출시 NoSuchElementException 발생
    }

    @Test
    fun testBindsInstance() {
        val hello = "Hello World"
        val foo2 = Foo2()
        val component: BindsComponent = DaggerBindsComponent.builder()
            .setString(hello)!!.build()
        component.inject(foo2)
        println(foo2.str)
    }

    @Test
    fun testMultibindingSet() {
        val foo3 = Foo3()
        DaggerSetComponent.create().inject(foo3)
        foo3.print()
    }

    @Test
    fun testMultibindingMap() {
        val component: MapComponent = DaggerMapComponent.create()
        val value = component.longsByString!!["foo"]!!
        val str = component.stringsByClass!![Foo::class.java]
        Assert.assertEquals(100, value)
        Assert.assertEquals("Foo String", str)
    }

    @Test
    fun testCustomMapKey() {
        val component: MapKeyComponent = DaggerMapKeyComponent.create()
        val cat = component.stringsByAnimal!![Animal.CAT]
        val dog = component.stringsByAnimal!![Animal.DOG]
        val number = component.stringsByNumber!![Float::class.java]
        Assert.assertEquals("Meow", cat)
        Assert.assertEquals("Bow-wow", dog)
        Assert.assertEquals("100f", number)
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
    fun testAbstractMultibinds() {
        val component: MultibindsComponent = DaggerMultibindsComponent.create()
        //비어 있음
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
}