import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)
    print("Enter a number: ")
    val num = scanner.nextInt()
    var result = ""
    result+= if (isEven(num)) "Number is Even\n" else "Number is Odd\n"
    result+= "Number of digits is ${digitCount(num)}\n"
    result+= "Sum of digits is ${digitSum(num)}\n"
    result+= "Reverse of number is ${reverse(num)}\n"
    result+= if (isPalindrome(num)) "Number is Palindrome\n" else "Number is not Palindrome\n"
    result+= "Prime factorization is ${primeFactorization(num)}\n"
    result+= "Prime factors are ${primeFactors(num).toSet().joinToString(separator = ", ")}\n"
    result+= "Number of prime factors is ${primeFactors(num).toSet().size}\n"
    result+= "Sum of prime factors is ${primeFactors(num).toSet().sum()}\n"
    result += "Factors of $num are ${factors(num).toSet().joinToString(separator = ", ")}\n"
    result += "Number of factors is ${factors(num).toSet().size}\n"
    result += "Sum of factors is ${factors(num).toSet().sum()}\n"
    result += "$num is ${if(!isPrime(num)) "a Composite" else "not a Composite"} number\n"
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

fun decimalToHex(n: Int): String = n.toString(16).uppercase(Locale.getDefault())

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    if (n <= 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false
    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
    }
    return true
}

fun primeFactors(n: Int): List<Int> {
    var num = n
    val factors = mutableListOf<Int>()
    for (i in 2..num) {
        if (isPrime(i)) {
            while (num % i == 0) {
                factors.add(i)
                num /= i
            }
        }
    }
    return factors
}

fun primeFactorization(n: Int): String {
    val factors = primeFactors(n)
    if (factors.isEmpty()) return "$n has no prime factors"
    val factorCount = mutableMapOf<Int, Int>()
    for (factor in factors) {
        factorCount[factor] = factorCount.getOrDefault(factor, 0) + 1
    }
    return factorCount.entries.joinToString(separator = " \u00D7 ") { "${it.key}^${it.value}" }
}

fun factors(n: Int): List<Int> {
    val factors = mutableListOf<Int>()
    for (i in 1..n) {
        if (n % i == 0) {
            factors.add(i)
        }
    }
    return factors
}

fun isNiven(number: Int): Boolean = if(number % digitSum(number) == 0) true else false

fun isEmirp(number: Int): Boolean = if(isPrime(number)) (if(isPrime(reverse(number))) true else false) else false

fun isAbundant(number : Int): Int = (factors(number).toSet().sum()-number) - number