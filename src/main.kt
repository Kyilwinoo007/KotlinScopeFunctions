fun main(args:Array<String>){
	
	val firstPerson = Person("John",22,"Programmer")
	val secondPerson = Person("Dave",23,"Graphic Designer")
	
	val olderPerson = if(firstPerson.age >= secondPerson.age) firstPerson else secondPerson
	olderPerson.printPerson()
	
	run{
		if(firstPerson.age >= secondPerson.age) firstPerson else secondPerson
	}.printPerson()
	
	/** Scope Function:'with'
		Property 1 :Refer to context object using 'this'
		Property 2 :The return value is the 'lambda result' **/
	with(firstPerson){
		age += 1
		"Age is now $age"   //return String
	}.println()
	
	/** Scope Function: 'apply'
		Property 1 :Refer to context object using 'this'
		Property 2 :The return value is the 'context object' **/
	secondPerson.apply{
		age += 1
		job = "Software Tester"
	}.printPerson()
	
	
	/** Scope Function: 'also'
		Property 1 :Refer to context object using 'it'
		Property 2 :The return value is the 'context object' **/
	
	secondPerson.also{   
		it.age += 1
		it.job = "Manager"
	}.printPerson()
	
	
	/** Scope Function: 'let'
		Property 1 :Refer to context object using 'it'
		Property 2 :The return value is the 'lambda result' **/
	
	//Use 'let' function to avoid NullPointerException
	
	firstPerson.let{
		modifyPerson ->
		modifyPerson.age += 1
		"Age is now ${modifyPerson.age}"  //return String
	}.println()
	
	val name:String? = null
	name?.let{
		println(it.reversed());
		println(it.capitalize())
		println(it.length)
	}
	
	
	
	/** Scope Function: 'run'
		Property 1 :Refer to context object using 'this'
		Property 2 :The return value is the 'lambda result' **/
	
	
	firstPerson.run{
		age += 1
		"Age is now $age"   //return String
	}.println()
	
		
}

data class Person(var name:String,var age:Int,var job:String){
	fun printPerson() = println(this.toString())
}

fun String.println() = println(this)