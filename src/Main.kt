import java.util.*

fun main(){

    val num = 495
    var result = ""
    result+= if (isEven(num)) "Number is Even\n" else "Number is Odd\n"
    result+= "Number of digits is ${digitCount(num)}\n"
    result+= "Sum of digits is ${digitSum(num)}\n"
    result+= "Reverse of number is ${reverse(num)}\n"
    result+= if (isPalindrome(num)) "Number is Palindrome\n" else "Number is not Palindrome\n"
    result += "Factors of $num are ${factors(num)}\n"
    result += "Number of Factors of $num is $count.\n"
    result += "Sum of Factors of $num is $s.\n"
    result += "$num is ${if(!isPrime(num) && num != 1) "a Composite" else "not a Composite"} number.\n"
    result += "Binary representation is ${decimalToBin(num)}\n"
    result += "Octal representation is ${decimalToOct(num)}\n"
    result += "Hexadecimal representation is ${decimalToHex(num)}\n"
    result += "$num is ${if(isNiven(num)) "a Niven"  else "not a Niven"} Number.\n"
    result += "$num is ${if(isEmirp(num)) "an Emirp"  else "not an Emirp"} Number.\n"
    result += "$num is ${if(isAbundant(num)<=0) "not an Abundant Number. " else "an Abundant Number with Abundance ${isAbundant(num)}."} \n"
    println(result)
}

fun isEven(number : Int) = number % 2 == 0

fun digitCount(number : Int) = number.toString().length

fun digitSum(number: Int): Int = number.toString().map { it - '0' }.sum()

fun reverse(number : Int) = number.toString().reversed().toInt()

fun isPalindrome(number:Int) = number==reverse(number)

fun decimalToBin(n: Int): String = n.toString(2) 

fun decimalToOct(n: Int): String = n.toString(8)

fun decimalToHex(n: Int): String = n.toString(16).toUpperCase()

fun primeFactorization(n: Int): MutableList<Int> {
    var num = n
    val factors = mutableListOf<Int>()
    fun smallestPrimeFactor(num: Int): Int {
        if (num % 2 == 0) return 2
        var i = 3
        while (i * i <= num) {
            if (num % i == 0) return i
            i += 2
        }
        return num
    }
    while (num > 1) {
        val factor = smallestPrimeFactor(num)
        factors.add(factor)
        num /= factor
    }

    return factors
}
fun formatFactors(factors: List<Int>): String {
    val factorCount = factors.groupingBy { it }.eachCount()
    return factorCount.entries.joinToString(", ") { "${it.key}^${it.value}" }
}

var s=1
var count = 1 
fun factors(n: Int):String{
    var result ="1"
    for (i in 2..n)
    {
        if(n%i==0)
        {
            s+=i
            count++ 
            result += ",$i"
        }
    }
    return result
}

fun sumofFactors(n: Int): Int = s 

var primelen=0
var primesum=0
fun primeFactors(n: Int): List<Int> {
    val primefactor=primeFactorization(n)
    val distinctprimeList = primefactor.distinct()
    primefactor.clear()
    primefactor.addAll(distinctprimeList)
    primelen=distinctprimeList.size
    primesum=distinctprimeList.sum()
    return distinctprimeList
}
fun numberofPrimes(n: Int):Int{
    return primelen
}
fun sumofPrimes(n: Int):Int{
    return primesum
}

fun isNiven(number: Int): Boolean = if(number % digitSum(number) == 0) true else false

fun isEmirp(number: Int): Boolean = if(isPrime(number)) (if(isPrime(reverse(number))) true else false) else false

fun isPrime(n: Int): Boolean{
  if(n == 1){
    return false
  }
  if(n == 2 || n == 3){
    return true
  }
  if(n%2==0 || n%3==0){
    return false 
  }
  for(i in 5..n step 6 ){
    if(i*i > n){
      break
    }
    if(n%i == 0 || n%(i+2) == 0){
      return false
    }
  }
  return true
}

fun isAbundant(number : Int): Int = (sumofFactors(number)-number) - number

