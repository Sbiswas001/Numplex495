import java.util.*

fun main(){

    val num = 495
    var result = ""
    result+= if (isEven(num)) "Number is Even\n" else "Number is Odd\n"
    result+= "Number of digits is ${digitCount(num)}\n"
    result+= "Sum of digits is ${digitSum(num)}\n"
    result+= "Reverse of number is ${reverse(num)}\n"
    result+= if (isPalindrome(num)) "Number is Palindrome\n" else "Number is not Palindrome\n"
    result += "Binary representation is ${decimalToBin(num)}\n"
    result += "Octal representation is ${decimalToOct(num)}\n"
    result += "Hexadecimal representation is ${decimalToHex(num)}\n"
    println(result)
}

fun isEven(number : Int) = number % 2 == 0

fun digitCount(number : Int) = number.toString().length

fun digitSum(number: Int): Int = number.toString().map { it - '0' }.sum()

fun reverse(number : Int) = number.toString().reversed().toInt()

fun isPalindrome(number:Int) = number==reverse(number)

fun decimalToBin(n: Int): String = n.toString(2) 

fun decimalToOct(n: Int): String = n.toString(8)

fun decimalToHex(n: Int): String = n.toString(16).uppercase(Locale.getDefault())
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
var s=0
fun factors(n: Int):String{
    var num= n
    var count=0
    var result =""
    for (i in 1..num)
    {
        if (num % i == 0 || count==0)
        {
            result+= i
            s+=i
            return result
            continue
        }
        if(num%i==0)
        {
            s+=i
            return (",$i")
        }
    }
}
fun sumofFactors(n: Int):Int{
    var sum=s
    return sum
}
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
