import java.util.*

fun main(){

    var num = 495
    var result = ""
    result+= if (isEven(num)) "Number is Even\n" else "Number is Odd\n"
    result+= "Number of digits is ${digitCount(num)}\n"
    result+= "Sum of digits is ${digitSum(num)}\n"
    result+= "Reverse of number is ${reverse(num)}\n"
    result+= if (isPalindrome(num)) "Number is Palindrome\n" else "Number is not Palindrome\n"
    println(result)
}

fun isEven(number : Int) = number % 2 == 0

fun digitCount(number : Int) = number.toString().length

fun digitSum(number: Int): Int = number.toString().map { it - '0' }.sum()

fun reverse(number : Int) = number.toString().reversed()

fun isPalindrome(number:Int) = number==reverse(number).toInt()

