package org.example

object LeeCode75 {

    //1480. Running Sum of 1d Array題目
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1..<nums.size) {
            nums[i] += nums[i - 1]
        }
        return nums
//        val result = IntArray(nums.size)
//        var temp = 0
//        nums.forEachIndexed { index, i ->
//            temp += i
//            result[index] = temp
//        }
//        return result
    }

    // 724. Find Pivot Index
    fun pivotIndex(nums: IntArray): Int {
        var totalSum = 0
        var leftSum = 0
        nums.forEach {
            totalSum += it
        }
        nums.forEachIndexed { i, it ->
            if (leftSum * 2 == totalSum - it) {
                return i
            }
            leftSum += it
        }
        return -1
    }

    // 205. Isomorphic Strings
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val sArray = IntArray(96)
        val tArray = IntArray(96)
        for (i in s.indices) {
            val sChar = s[i].code - 31
            val tChar = t[i].code - 31

            if (sArray[sChar] != tArray[tChar]) return false

            sArray[sChar] = i + 1
            tArray[tChar] = i + 1
        }
        return true
    }
}