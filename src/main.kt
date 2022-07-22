fun main(args:Array<String>){
	
	val firstPerson = Person("John",22,"Programmer")
	val secondPerson = Person("Dave",23,"Graphic Designer")
	
	val olderPerson = if(firstPerson.age >= secondPerson.age) firstPerson else secondPerson
	olderPerson.printPerson()
	
	run{
		if(firstPerson.age >= secondPerson.age) firstPerson else secondPerson
	}.printPerson()
	
	with(firstPerson){
		age += 1
		"Age is now $age"
	}.println()
	
	firstPerson.run{
		age += 1
		"Age is now $age"
	}.println()
	
	firstPerson.let{
		modifyPerson ->
		modifyPerson.age += 1
		"Age is now ${modifyPerson.age}"
	}.println()
	
	firstPerson.printPerson()
	
	secondPerson.apply{
		age += 1
		job = "Software Tester"
	}.printPerson()
	
	secondPerson.also{
		it.age += 1
		it.job = "Manager"
	}.printPerson()
}

data class Person(var name:String,var age:Int,var job:String){
	fun printPerson() = println(this.toString())
}

fun String.println() = println(this)