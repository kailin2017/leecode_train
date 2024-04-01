package org.example

// 1. Two Sum
fun twoSum(nums: IntArray, target: Int): IntArray {
    val num2Index = mutableMapOf<Int, Int>()
    nums.forEachIndexed { i, it ->
        val diff = target - it
        if (num2Index.contains(diff)) {
            return intArrayOf(num2Index[diff]!!, i)
        }
        num2Index[it] = i
    }
    return intArrayOf()
}

// 14. Longest Common Prefix
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    strs.sort()
    val first = strs.first()
    val last = strs.last()
    var i = 0
    while (i < first.length && i < last.length && first[i] == last[i]) {
        i++
    }
    return first.substring(0, i)
}

// 13.Roman to Integer
fun romanToInt(s: String): Int {
    val romanValues = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    var result = 0
    var prevValue = 0
    for (i in s.length - 1 downTo 0) {
        val currChar = s[i]
        val currValue = romanValues[currChar] ?: 0
        if (currValue < prevValue) {
            result -= currValue
        } else {
            result += currValue
        }
        prevValue = currValue
    }
    return result
}

// 20. Valid Parentheses
fun isValid(s: String): Boolean {
    val tamp = mutableListOf<Char>()

    s.forEach {
        when (it) {
            '(', '[', '{' -> tamp.add(it)
            ')' -> if (tamp.isEmpty() || tamp.removeAt(tamp.size - 1) != '(') return false
            ']' -> if (tamp.isEmpty() || tamp.removeAt(tamp.size - 1) != '[') return false
            '}' -> if (tamp.isEmpty() || tamp.removeAt(tamp.size - 1) != '{') return false
        }
    }

    return tamp.isEmpty()
}