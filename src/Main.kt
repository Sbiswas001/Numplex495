fun main(){
    print("Enter a number:")
    var num = readLine()?.toInt()?:return
}

fun oddEven(number:Int):Boolean {
    if(number%2==0){
       return true
    }
    else{
        return false
    }
}

fun numdigits(number:Int):Int {
    var count = 0
    var temp = number
    while(temp!=0){
        temp/=10
        count++
    }
    return count
}

fun sumDigits(number:Int):Int{
    var sum = 0
    var temp = number
    while(temp!=0){
        sum += temp%10
        temp/=10
    }
    return sum
}

fun reverse(number:Int):Int{
    var str = number.toString()
    var newRev = number.toString().reversed()
    return newRev.toInt()
}

fun isPalindrome(number:Int):Boolean {
    val numStr = number.toString()
    return number.toString() == numStr.reversed()
}

